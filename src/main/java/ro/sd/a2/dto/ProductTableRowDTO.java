package ro.sd.a2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.sd.a2.entity.ProductCategory;
import ro.sd.a2.entity.Supplier;

@Getter
@Setter
@Builder

public class ProductTableRowDTO {
    private String id;
    private String name;
    private double price;
    private int unitsInStock;
    private String description;
    private ProductCategory category;
    private Supplier supplier;
}
