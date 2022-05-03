package ro.sd.a2.builder;

import org.springframework.stereotype.Service;
import ro.sd.a2.dto.AddressDTO;
import ro.sd.a2.dto.ClientCreationDTO;
import ro.sd.a2.entity.Address;

import java.util.Objects;

@Service
public class AddressBuilder {
    public Address toAddressEntity(AddressDTO addressDTO) {
        if (Objects.isNull(addressDTO))
            return null;
        return Address.builder()
                .street(addressDTO.getStreet())
                .streetNo(addressDTO.getStreetNo())
                .city(addressDTO.getCity())
                .county(addressDTO.getCounty())
                .postalCode(addressDTO.getPostalCode())
                .build();
    }

    public AddressDTO toAddressDTO(ClientCreationDTO clientCreationDTO) {
        if (Objects.isNull(clientCreationDTO))
            return null;
        return AddressDTO.builder()
                .street(clientCreationDTO.getAddressStreet())
                .streetNo(Integer.parseInt(clientCreationDTO.getAddressNumber()))
                .city(clientCreationDTO.getAddressCity())
                .county(clientCreationDTO.getAddressCounty())
                .postalCode(Integer.parseInt(clientCreationDTO.getPostalCode()))
                .build();
    }
}
