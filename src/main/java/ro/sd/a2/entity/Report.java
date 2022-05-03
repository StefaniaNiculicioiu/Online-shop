package ro.sd.a2.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "admin_reports")
public class Report {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "issuance_date")
    private LocalDateTime issuanceDate;

    @Column(name = "sold_products")
    private int soldProducts;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
