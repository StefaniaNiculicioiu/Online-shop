package ro.sd.a2.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.ClientCreationDTO;
import ro.sd.a2.dto.ClientDTO;
import ro.sd.a2.dto.ClientTableRowDTO;
import ro.sd.a2.entity.Address;
import ro.sd.a2.entity.Client;
import ro.sd.a2.utils.UserRole;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class ClientBuilder {

    private final AddressBuilder addressBuilder;

    @Autowired
    public ClientBuilder(AddressBuilder addressBuilder) {
        this.addressBuilder = addressBuilder;
    }

    public ClientDTO toClientDTO(Client client){
        if(Objects.isNull(client)){
            return null;
        }
        return ClientDTO.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .username(client.getUsername())
                .email(client.getEmail())
                .phoneNumber(client.getPhoneNumber())
                .address(client.getAddress())
                .cardNumber(client.getCardNumber())
                .cardExpirationDate(client.getCardExpirationDate())
                .cvv(client.getCvv())
                .orders(client.getOrders())
                .cart(client.getCart())
                .build();
    }

    public ClientTableRowDTO toClientTableRowDTO(Client client){
        if(Objects.isNull(client)){
            return null;
        }
        return ClientTableRowDTO.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .username(client.getUsername())
                .email(client.getEmail())
                .phoneNumber(client.getPhoneNumber())
                .address(client.getAddress())
                .build();
    }

    public Client toClientEntity(ClientDTO clientDTO){
        if(Objects.isNull(clientDTO)){
            return null;
        }
        return Client.builder()
                .id(clientDTO.getId())
                .firstName(clientDTO.getFirstName())
                .lastName(clientDTO.getLastName())
                .username(clientDTO.getUsername())
                .email(clientDTO.getEmail())
                .phoneNumber(clientDTO.getPhoneNumber())
                .address(clientDTO.getAddress())
                .cardNumber(clientDTO.getCardNumber())
                .cardExpirationDate(clientDTO.getCardExpirationDate())
                .cvv(clientDTO.getCvv())
                .orders(clientDTO.getOrders())
                .cart(clientDTO.getCart())
                .build();
    }

    public Client toClientEntity(ClientCreationDTO clientCreationDTO){
        if(Objects.isNull(clientCreationDTO)){
            return null;
        }
        return Client.builder()
                .id(clientCreationDTO.getId())
                .userRole(UserRole.ROLE_CLIENT)
                .firstName(clientCreationDTO.getFirstName())
                .lastName(clientCreationDTO.getLastName())
                .username(clientCreationDTO.getUsername())
                .email(clientCreationDTO.getEmail())
                .password(clientCreationDTO.getPassword())
                .phoneNumber(clientCreationDTO.getPhoneNumber())
                .address(new Address(clientCreationDTO.getAddressCity(),
                        clientCreationDTO.getAddressCounty(),
                        clientCreationDTO.getAddressStreet(),
                        Integer.parseInt(clientCreationDTO.getAddressNumber()),
                        Integer.parseInt(clientCreationDTO.getPostalCode())))
                .cardNumber(clientCreationDTO.getCardNumber())
                .cardExpirationDate(LocalDate.parse(clientCreationDTO.getCardExpiryDate()))
                .cvv(clientCreationDTO.getCvv())
                .build();
    }
}
