package ro.sd.a2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.sd.a2.entity.Address;

@Getter
@Setter
@Builder
public class ClientTableRowDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private Address address;
}
