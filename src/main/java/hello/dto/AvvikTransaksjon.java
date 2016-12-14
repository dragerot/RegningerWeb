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
public class AvvikTransaksjon {

    private String id;
    private String endToEndId;
    private String accountNumber;
    private String name;
    private BigDecimal amount;
    private String currency;
    private String paymentInformationId;
    private String debitAccountNumber;
    private String avvikKode;
    private String avvikBeskrivelse;
}
