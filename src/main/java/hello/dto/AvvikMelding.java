package hello.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvvikMelding {

    private String messageId;
    private Integer numberOfTransactions;
    private BigDecimal transactionSum;
    private String messageName;
    private String avvikKode;
    private String avvikBeskrivelse;
}
