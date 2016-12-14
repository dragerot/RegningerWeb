package hello.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAIN001_XML")
public class Pain001XML implements Serializable {

    private static final long serialVersionUID = -3966047090748691847L;

    @Id
    @Column(name = "MESSAGE_ID")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Lob
    @Column(name = "XML_DATA")
    private String xmlData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_CODE")
    private Status status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE_ID")
    private PaymentMessage paymentMessage;
}
