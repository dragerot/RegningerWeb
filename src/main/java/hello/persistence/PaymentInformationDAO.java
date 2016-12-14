package hello.persistence;

import java.math.BigDecimal;
import java.util.List;
import hello.dto.AvvikBunt;
import hello.entities.PaymentInformation;
import hello.entities.PaymentMessage;
import hello.entities.Status;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentInformationDAO extends JpaRepository<PaymentInformation, String> {

    PaymentInformation findById(String id);

    List<PaymentInformation> findByDebitAccountNumber(String debitAccountNumber);

    List<PaymentInformation> findByTransactionsSum(BigDecimal transactionsSum);

    List<PaymentInformation> findByTransactionsSumGreaterThan(BigDecimal transactionsSum);

    List<PaymentInformation> findByTransactionsSumGreaterThanEqual(BigDecimal transactionsSum);

    List<PaymentInformation> findByTransactionsSumLessThan(BigDecimal transactionsSum);

    List<PaymentInformation> findByTransactionsSumLessThanEqual(BigDecimal transactionsSum);
//
//    @Query("Select p from PaymentInformation p where p.paymentMessage =?1")
//    List<PaymentInformation> findByPaymentMessage(PaymentMessage paymentMessage);
//
//    List<PaymentInformation> findByPaymentMessageId(String id);
//
//    @Query("Select p from PaymentInformation p where p.status =?1")
//    List<PaymentInformation> findByStatus(Status status);
//
//    List<PaymentInformation> findByStatusCode(String statusCode);
//
//    @Query("Select p from PaymentInformation p where p.id =?1")
//    PaymentInformation findByPaymentInformationId(String paymentInformationId);

//    @Query("select new hello.dto.AvvikBunt(b.id, b.numberOfTransactions, b.transactionsSum, a.avvikKode, a.avvikBeskrivelse) from PaymentMessage m, PaymentInformation b, Avvik a\n"
//            +
//            " where m.id =?1\n" +
//            " and b.paymentMessage.id = m.id\n" +
//            " and a.buntId = b.id")
//    List<AvvikBunt> findAvvikInBunt(String meldingId);

//    @Query("select pt.id, pt.endId, pt.accountNumber, pt.name, pt.amount, pi.id, pi.transactionsSum, pi.dueDate, pi.paymentMessage.id FROM PaymentInformation pi, PaymentTransaction pt where pi.id = '1' and pt.status.code = 'ACCP'")
//    List<PaymentInformation> testList();

    @Query("Select p from PaymentInformation p where p.dueDate =?1 and (p.status =?2 or p.status =?3)")
    List<PaymentInformation> findCorrectPaymentInformation(LocalDate date, Status accepted, Status partlyAccepted);

}
