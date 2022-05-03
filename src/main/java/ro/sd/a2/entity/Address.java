package ro.sd.a2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private Integer streetNo;

    @Column(name = "postal_code")
    private Integer postalCode;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Client client;

    public Address(String city, String county, String street, Integer streetNo, Integer postalCode) {
        this.city = city;
        this.county = county;
        this.street = street;
        this.streetNo = streetNo;
        this.postalCode = postalCode;
    }
}
