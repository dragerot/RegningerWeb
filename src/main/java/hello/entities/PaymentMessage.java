package hello.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT_MESSAGE")
public class PaymentMessage implements Serializable {

    private static final long serialVersionUID = -6375028985612963223L;

    @Id
    @Column(name = "MESSAGE_ID", unique = true, nullable = false)
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "NUMBER_OF_TRANSACTIONS")
    private Integer numberOfTransactions;

    @Column(name = "TRANSACTION_SUM")
    private BigDecimal transactionSum;

    @Column(name = "BIC")
    private String bic;

    @Column(name = "MESSAGE_NAME")
    private String messagename;

    @OneToMany(mappedBy = "paymentMessage", fetch = FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<PaymentInformation> paymentInformationList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_CODE")
    private Status status;

    @OneToOne(mappedBy = "paymentMessage", fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE_ID")
    private Pain001XML pain001XML;

    @Transient
    private List<PaymentInformation> transientPaymentInformationList = new ArrayList<>();

    @Override
    public String toString() {
        return "PaymentMessage{" +
                "id='" + id + '\'' +
                ", createdDate=" + createdDate +
                ", numberOfTransactions=" + numberOfTransactions +
                ", transactionSum=" + transactionSum +
                ", bic='" + bic + '\'' +
                ", messagename='" + messagename + '\'' +
                ", paymentInformationList=" + paymentInformationList +
                ", status=" + status +
                ", pain001XML=" + pain001XML +
                '}';
    }
}
