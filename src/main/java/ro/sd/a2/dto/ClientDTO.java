package ro.sd.a2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.sd.a2.entity.Address;
import ro.sd.a2.entity.Cart;
import ro.sd.a2.entity.Order;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class ClientDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private Address address;
    private String cardNumber;
    private LocalDate cardExpirationDate;
    private String cvv;
    private Cart cart;
    private List<Order> orders;
}
