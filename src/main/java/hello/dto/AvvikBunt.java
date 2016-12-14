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
public class AvvikBunt {

    private String paymentInformationId;
    private Integer numberOfTransactions;
    private BigDecimal transactionsSum;
    private String avvikKode;
    private String avvikBeskrivelse;

}
