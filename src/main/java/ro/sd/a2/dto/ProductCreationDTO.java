package ro.sd.a2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ProductCreationDTO {
    private String id;
    private String name;
    private String price;
    private String unitsInStock;
    private String description;
    private String productCategoryName;
    private String supplierName;
}
