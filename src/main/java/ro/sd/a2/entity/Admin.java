package ro.sd.a2.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "admins")
public class Admin extends User {

    @OneToMany(mappedBy = "admin")
    private List<Report> reports;
}
