package ro.sd.a2.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import ro.sd.a2.utils.ProductStatus;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "product_status")
    private ProductStatus productStatus;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
