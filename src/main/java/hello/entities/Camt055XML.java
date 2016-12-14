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
@Table(name = "CAMT055_XML")
public class Camt055XML implements Serializable {
    private static final long serialVersionUID = -5091382599291247481L;

    @Id
    @Column(name = "MESSAGE_ID", unique = true, nullable = false)
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

}
