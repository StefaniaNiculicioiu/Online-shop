package ro.sd.a2.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @OneToMany(mappedBy = "cart")
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
