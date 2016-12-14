package hello.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT_TRANSACTION")
public class PaymentTransaction implements Serializable {

    private static final long serialVersionUID = -8734916189581646344L;

    @Id
    @Column(name = "TRANSACTION_ID", unique = true, nullable = false)
    private String id;

    @Column(name = "END_TO_END_ID", nullable = false)
    private String endToEndId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAYMENT_INFORMATION_ID")
    private PaymentInformation paymentInformation;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "CURRENCY")
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_CODE")
    private Status status;

}