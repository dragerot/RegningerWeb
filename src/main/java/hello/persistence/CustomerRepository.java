package hello.persistence;

import java.util.List;

import hello.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> findByLastName(String lastName);
}
