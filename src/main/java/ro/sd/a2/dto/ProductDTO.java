package ro.sd.a2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.sd.a2.entity.*;
import ro.sd.a2.utils.ProductStatus;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class ProductDTO {
    private String id;
    private String name;
    private double price;
    private int unitsInStock;
    private ProductStatus productStatus;
    private ProductCategory category;
    private String description;
    private Supplier supplier;
    private List<Review> reviews;
    private Cart cart;
}
