package ro.sd.a2.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
public class ClientCreationDTO {
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String addressCity;
    @NonNull
    private String addressStreet;
    @NonNull
    private String addressNumber;
    @NonNull
    private String addressCounty;
    @NonNull
    private String postalCode;

    private String cardNumber;
    private String cardExpiryDate;
    private String cvv;
}
