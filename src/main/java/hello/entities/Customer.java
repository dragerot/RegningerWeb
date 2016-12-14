package hello.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = 7550958171280794634L;
    @Id
    private String ssn;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,
               orphanRemoval = true,
               mappedBy = "customer")
     private List<CustomerOrder> orders;

    @Override
    public String toString() {
        return String.format(
                "Customer[ssn=%s, firstName='%s', lastName='%s']",
                ssn, firstName, lastName);
    }


}

