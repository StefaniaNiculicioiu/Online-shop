package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository  extends JpaRepository<Client, String> {
}
