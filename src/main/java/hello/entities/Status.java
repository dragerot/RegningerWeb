package hello.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "STATUS")
public class Status implements Serializable {

    private static final long serialVersionUID = -6636050808217519485L;

    @Id
    @Column(name = "STATUS_CODE", unique = true, nullable = false)
    private String code;

    @Column(name = "STATUS_DEFINITION")
    private String statusDefinition;

}