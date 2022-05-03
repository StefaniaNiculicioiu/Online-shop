package ro.sd.a2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "clients")
@NoArgsConstructor
@Getter
@SuperBuilder
public class Client extends User{
    
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_date")
    private LocalDate cardExpirationDate;

    @Column(name = "cvv")
    private String cvv;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(mappedBy = "client")
    private Cart cart;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;
}
