package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.builder.ProductBuilder;
import ro.sd.a2.dto.ProductCreationDTO;
import ro.sd.a2.dto.ProductDTO;
import ro.sd.a2.entity.Product;
import ro.sd.a2.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductBuilder productBuilder;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductBuilder productBuilder) {
        this.productRepository = productRepository;
        this.productBuilder = productBuilder;
    }

    /**
     * Method to create a new product in the db using DTOs, useful for communicating with the frontend.
     * @param productCreationDTO object containing product information from frontend form input fields
     */
    public void create(ProductCreationDTO productCreationDTO) {
        Product product = productBuilder.toProductEntity(productCreationDTO);
        productRepository.save(product);
    }

    /**
     * Method for getting all product information from the db
     * @return product information to be displayed in the frontend table.
     */
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productBuilder::toProductDTO)
                .collect(Collectors.toList());
    }

    /**
     * Method to get a product by its id.
     * @param id keeps the auto-generated id that is assigned to each product individually. With it we determine which product we choose.
     * @return the product with the specified id
     */
    public Optional<Product> getById(String id) {
        return productRepository.findById(id);
    }

    /**
     * Method to update a product information from the db
     * @param productDTO object containing product information from frontend form input fields.
     */
    public void update(ProductDTO productDTO) {
        Optional<Product> productFromDB = productRepository.findById(productDTO.getId());
        if (productFromDB.isPresent()) {
            Product product = productFromDB.get();
            product.setName(productDTO.getName());
            product.setCategory(productDTO.getCategory());
            product.setProductStatus(productDTO.getProductStatus());
            product.setPrice(productDTO.getPrice());
            product.setUnitsInStock(productDTO.getUnitsInStock());
            product.setSupplier(productDTO.getSupplier());
            productRepository.saveAndFlush(product);
        }
    }

    /**
     * Method to delete a product by its id from the db
     * @param id keeps the auto-generated id that is assigned to each product individually. With it we determine which product we choose to delete.
     */
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
