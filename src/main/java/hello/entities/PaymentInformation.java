package hello.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT_INFORMATION")
public class PaymentInformation implements Serializable {

    private static final long serialVersionUID = 2750261481705730378L;

    @Id
    @Column(name = "PAYMENT_INFORMATION_ID", unique = true, nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE_ID")
    private PaymentMessage paymentMessage;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "NUMBER_OF_TRANSACTIONS")
    private Integer numberOfTransactions;

    @Column(name = "TRANSACTIONS_SUM")
    private BigDecimal transactionsSum;

    @Column(name = "DEBITOR_ACCOUNT_NUMBER")
    private String debitAccountNumber;

    @OneToMany(mappedBy = "paymentInformation", fetch = FetchType.LAZY)
    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
    private List<PaymentTransaction> paymentTransactionList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_CODE")
    private Status status;

    @Transient
    private List<PaymentTransaction> transientPaymentTransactionList = new ArrayList<>();
}
