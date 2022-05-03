package ro.sd.a2.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import ro.sd.a2.utils.UserRole;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "username")
    private String username;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "email", unique = true)
    private String email;

    @NonNull
    @Column(name = "phone_num")
    private String phoneNumber;

    @NonNull
    @Column(name = "role")
    private UserRole userRole;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + firstName + " " + lastName + '\'' +
                '}';
    }
}
