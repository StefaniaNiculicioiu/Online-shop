package ro.sd.a2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.sd.a2.entity.Client;

@Getter
@Setter
@Builder
@ToString
public class AddressDTO {
    private String id;
    private String city;
    private String county;
    private String street;
    private Integer streetNo;
    private Integer postalCode;
    private Client client;
}
