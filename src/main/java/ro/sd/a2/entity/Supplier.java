package ro.sd.a2.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "supplier_name")
    private String supplierName;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public Supplier(String supplierName) {
        this.supplierName = supplierName;
    }
}
