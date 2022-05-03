package ro.sd.a2.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.ProductCreationDTO;
import ro.sd.a2.dto.ProductDTO;
import ro.sd.a2.dto.ProductTableRowDTO;
import ro.sd.a2.entity.Product;
import ro.sd.a2.entity.ProductCategory;
import ro.sd.a2.entity.Supplier;
import ro.sd.a2.utils.ProductStatus;

import java.util.Objects;

@Service
public class ProductBuilder {

    private final ProductCategoryBuilder productCategoryBuilder;

    @Autowired
    public ProductBuilder(ProductCategoryBuilder productCategoryBuilder) {
        this.productCategoryBuilder = productCategoryBuilder;
    }

    public ProductDTO toProductDTO(Product product){
        if(Objects.isNull(product)){
            return null;
        }

        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .unitsInStock(product.getUnitsInStock())
                .category(product.getCategory())
                .description(product.getDescription())
                .supplier(product.getSupplier())
                .reviews(product.getReviews())
                .cart(product.getCart())
                .build();
    }
    public ProductTableRowDTO toProductTableRowDTO(Product product){
        if(Objects.isNull(product)){
            return null;
        }
        return ProductTableRowDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .unitsInStock(product.getUnitsInStock())
                .description(product.getDescription())
                .category(product.getCategory())
                .supplier(product.getSupplier())
                .build();
    }

    public Product toProductEntity(ProductDTO productDTO){
        if(Objects.isNull(productDTO)){
            return null;
        }
        return Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .unitsInStock(productDTO.getUnitsInStock())
                .category(productDTO.getCategory())
                .description(productDTO.getDescription())
                .supplier(productDTO.getSupplier())
                .reviews(productDTO.getReviews())
                .cart(productDTO.getCart())
                .build();
    }

    public Product toProductEntity(ProductCreationDTO productCreationDTO){
        if(Objects.isNull(productCreationDTO)){
            return null;
        }
        return Product.builder()
                .id(productCreationDTO.getId())
                .name(productCreationDTO.getName())
                .price(Double.parseDouble(productCreationDTO.getPrice()))
                .unitsInStock(Integer.parseInt(productCreationDTO.getUnitsInStock()))
                .description(productCreationDTO.getDescription())
                .productStatus(ProductStatus.IN_STOCK)
                .category(new ProductCategory(productCreationDTO.getProductCategoryName()))
                .supplier(new Supplier(productCreationDTO.getSupplierName()))
                .build();
    }
}
