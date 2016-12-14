package hello.entities;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STROMMAALINGER")
public class StromMaaling {
    @Id
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dato;
    private Long totaltForbruk;
    private Long utleieForbruk;
    private String melding;

    @Override
    public String toString() {
        return "StromMaaling{" +
                "dato=" + dato +
                ", totaltForbruk=" + totaltForbruk +
                ", utleieForbruk=" + utleieForbruk +
                ", melding='" + melding + '\'' +
                '}';
    }
}
