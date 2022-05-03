package ro.sd.a2.controller;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.dto.ClientTableRowDTO;
import ro.sd.a2.dto.ProductCreationDTO;
import ro.sd.a2.dto.ProductDTO;
import ro.sd.a2.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    /**
     * Method for retrieving all products from db as DTOs to be displayed in front-end component
     * @return ModelAndView object that returns Products.html template
     */
    @GetMapping("/allProducts")
    public ModelAndView getAllProducts() {
        List<ProductDTO> productDTOS = productService.getAll();
        ModelAndView mav = new ModelAndView();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("productDTOs", productDTOS);
        mav.addAllObjects(model);
        mav.setViewName("Products");
        return mav;
    }

    /**
     * Post method for inserting a new product in db
     * @param productCreationDTO object containing product information from frontend form input fields
     * @return ModelAndView object that returns Products.html template
     */
    @RequestMapping(value = "/addProduct", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView insertProduct(ProductCreationDTO productCreationDTO) {
        if (ObjectUtils.isEmpty(productCreationDTO)) {
            log.error("Product insert operation failed: ProductCreationDTO is null.");
        } else {
            productService.create(productCreationDTO);
            log.info("Product with id {" + productCreationDTO.getName() + "} was created successfully.");
        }
        ModelAndView mav = getAllProducts();
        return mav;
    }

}
