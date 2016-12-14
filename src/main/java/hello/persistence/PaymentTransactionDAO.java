package hello.persistence;

import hello.dto.AvvikTransaksjon;
import hello.entities.PaymentInformation;
import hello.entities.PaymentTransaction;
import hello.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentTransactionDAO extends JpaRepository<PaymentTransaction, String> {

    PaymentTransaction findById(String id);

    List<PaymentTransaction> findByAccountNumber(String accountNumber);

    List<PaymentTransaction> findByName(String name);

    List<PaymentTransaction> findByAmount(BigDecimal amount);

    List<PaymentTransaction> findByAmountGreaterThan(BigDecimal amount);

    List<PaymentTransaction> findByAmountGreaterThanEqual(BigDecimal amount);

    List<PaymentTransaction> findByAmountLessThan(BigDecimal amount);

    List<PaymentTransaction> findByAmountLessThanEqual(BigDecimal amount);

//    @Query("Select p from PaymentTransaction p where p.paymentInformation =?1")
//    List<PaymentTransaction> findByPaymentInformation(PaymentInformation paymentInformation);
//
//    List<PaymentTransaction> findByPaymentInformationId(String paymentInformationId);
//
//    @Query("Select p from PaymentTransaction p where p.status =?1")
//    List<PaymentTransaction> findByStatus(Status status);
//
//    List<PaymentTransaction> findByStatusCode(String statusCode);

//    @Query("select new no.nav.betsystestkomponent.repository.dto.AvvikTransaksjon(t.id, t.endToEndId, t.accountNumber, t.name, t.amount, t.currency, t.paymentInformation.id," +
//            " b.debitAccountNumber, a.avvikKode, a.avvikBeskrivelse) from PaymentMessage m, PaymentInformation b, PaymentTransaction t, Avvik a\n "
//            +
//            "where m.id =?1\n " +
//            "and b.paymentMessage.id = m.id\n " +
//            "and t.paymentInformation.id = b.id\n " +
//            "and (a.transaksjonId is not null and t.id = a.transaksjonId)")
//    List<AvvikTransaksjon> findAvvikInTransaksjonId(String meldingId);

//    @Query("select new no.nav.betsystestkomponent.repository.dto.AvvikTransaksjon(t.id, t.endToEndId, t.accountNumber, t.name, t.amount, t.currency, t.paymentInformation.id," +
//            " b.debitAccountNumber, a.avvikKode, a.avvikBeskrivelse) from PaymentMessage m, PaymentInformation b, PaymentTransaction t, Avvik a\n "
//            +
//            "where m.id =?1\n " +
//            "and b.paymentMessage.id = m.id\n " +
//            "and t.paymentInformation.id = b.id\n " +
//            "and (a.navnMottaker is not null and t.name = a.navnMottaker)")
//    List<AvvikTransaksjon> findAvvikInTransaksjonNavnMottaker(String meldingId);

//    @Query("select new no.nav.betsystestkomponent.repository.dto.AvvikTransaksjon(t.id, t.endToEndId, t.accountNumber, t.name, t.amount, t.currency, t.paymentInformation.id," +
//            " b.debitAccountNumber, a.avvikKode, a.avvikBeskrivelse) from PaymentMessage m, PaymentInformation b, PaymentTransaction t, Avvik a\n "
//            +
//            "where m.id =?1\n " +
//            "and b.paymentMessage.id = m.id\n " +
//            "and t.paymentInformation.id = b.id\n " +
//            "and (a.kontonrMottager is not null and t.accountNumber = a.kontonrMottager)")
//    List<AvvikTransaksjon> findAvvikInTransaksjonKontonrMottaker(String meldingId);

//    @Query("SELECT SUM(p.amount) FROM PaymentTransaction p where p.paymentInformation.id =?1 and p.status=?2")
//    BigDecimal sum(String buntId, Status status);
}
