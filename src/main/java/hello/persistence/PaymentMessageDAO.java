package hello.persistence;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import hello.dto.AvvikMelding;
import hello.entities.PaymentMessage;
import hello.entities.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentMessageDAO extends JpaRepository<PaymentMessage, String> {

    PaymentMessage findById(String messageId);

    List<PaymentMessage> findByBic(String bic);

    List<PaymentMessage> findByMessagename(String messagename);

    List<PaymentMessage> findByTransactionSum(BigDecimal transactionSum);

    List<PaymentMessage> findByTransactionSumGreaterThan(BigDecimal transactionSum);

    List<PaymentMessage> findByTransactionSumGreaterThanEqual(BigDecimal transactionSum);

    List<PaymentMessage> findByTransactionSumLessThan(BigDecimal transactionSum);

    List<PaymentMessage> findByTransactionSumLessThanEqual(BigDecimal transactionSum);

    List<PaymentMessage> findByCreatedDate(Date createdDate);

    List<PaymentMessage> findByCreatedDateGreaterThan(Date createdDate);

    List<PaymentMessage> findBycreatedDateGreaterThanEqual(Date createdDate);

    List<PaymentMessage> findByCreatedDateLessThan(Date createdDate);

    List<PaymentMessage> findByCreatedDateLessThanEqual(Date createdDate);

//    @Query("Select p from PaymentMessage p where p.status =?1")
//    List<PaymentMessage> findByStatus(Status status);
//
//    @Query("Select p.id from PaymentMessage p where p.status.code =?1")
//    List<String> findMessageIdByStatusCode(String statusCode);
//
//    @Query("select new hello.dto.AvvikMelding(m.id, m.numberOfTransactions, m.transactionSum, m.messagename, a.avvikKode, a.avvikBeskrivelse) from PaymentMessage m, Avvik a\n"
//            +
//            "where m.id =?1\n" +
//            "and a.meldingIdVal =?1")
//    AvvikMelding findAvvikInMeldingValidert(String meldingId);
//
//    @Query("select new no.nav.betsystestkomponent.repository.dto.AvvikMelding(m.id, m.numberOfTransactions, m.transactionSum, m.messagename, a.avvikKode, a.avvikBeskrivelse) from PaymentMessage m, Avvik a\n"
//            +
//            "where m.id =?1\n" +
//            "and a.meldingIdTek =?1")
//    AvvikMelding findAvvikInMeldingTeknisk(String meldingId);

//    @Query("select p from PaymentMessage p where p.id not in(select pain001.id from Pain002XML)")
//    List<PaymentMessage> findPaymentMessageNotInPain002XML();

    @Query("select p from PaymentMessage p where p.id =?1 and p.status.code =?2")
    PaymentMessage findByIdAndStatusCode(String id, String statusCode);

}
