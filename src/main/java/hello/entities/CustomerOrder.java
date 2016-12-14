package hello.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER_ORDER")
public class CustomerOrder implements Serializable {
    @Id
    String customerOrderId;
    String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ssn")
    private Customer customer;

}


