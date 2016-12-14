package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import hello.entities.*;
import hello.persistence.*;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import hello.config.RepositoryConfig;
//import hello.entities.Customer;
//import hello.entities.CustomerOrder;
//import hello.persistence.CustomerRepository;
//import hello.persistence.OrderRepository;
//
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//
//import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableJpaRepositories
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//@EnableAutoConfiguration
//@Profile(value = "test")
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
public class Application implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private CustomerRepository customerRepository;
//	private StromMaalingerRepository stromMaalingerRepository;
	private StatusDAO statusDAO;
//	private PaymentMessageDAO paymentMessageDAO;
//	private PaymentInformationDAO paymentInformationDAO;
//	private PaymentTransactionDAO paymentTransactionDAO;

	public Application(
			CustomerRepository customerRepository,
//			StromMaalingerRepository stromMaalingerRepository,
			PaymentMessageDAO paymentMessageDAO,
			PaymentInformationDAO paymentInformationDAO,
			PaymentTransactionDAO paymentTransactionDAO){
		this.statusDAO=statusDAO;
		this.customerRepository=customerRepository;
//		this.stromMaalingerRepository=stromMaalingerRepository;
//		this.paymentMessageDAO=paymentMessageDAO;
//		this.paymentInformationDAO=paymentInformationDAO;
//		this.paymentTransactionDAO=paymentTransactionDAO;

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {

//		statusDAO.save(Status.builder().statusDefinition("ACTC").code("Accepted technical").build());
//		statusDAO.save(Status.builder().statusDefinition("RCVD").code("Received").build());
//		statusDAO.save(Status.builder().statusDefinition("PART").code("Partially accepted").build());
//		statusDAO.save(Status.builder().statusDefinition("RJCT").code("Rejected").build());
//		statusDAO.save(Status.builder().statusDefinition("PDNG").code("Pending").build());
//		statusDAO.save(Status.builder().statusDefinition("H6").code("A6").build());

//		stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate()).melding("Hallo").totaltForbruk(1000L).utleieForbruk(300L).build());
//		stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(1)).melding("Hallo1").totaltForbruk(1000L).utleieForbruk(300L).build());
//		stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(2)).melding("Hallo2").totaltForbruk(1010L).utleieForbruk(400L).build());
//		stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(3)).melding("Hallo3").totaltForbruk(1200L).utleieForbruk(500L).build());
//		stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(4)).melding("Hallo4").totaltForbruk(1003L).utleieForbruk(200L).build());

		//		paymentMessageDAO.save(createPaymentMessage());
		//		System.out.println("******HALLO**************"+paymentMessageDAO.findById("1").toString());
	}

	private Pain001XML createPaint001XML(){

		return Pain001XML.builder().createdDate(new Date()).
				id("1").
				xmlData("xml").status(createStatus()).
				build();

	}

	private Status createStatus(){
		return statusDAO.findOne("ACTC");
	}

	private PaymentMessage createPaymentMessage(){
		List<PaymentInformation> paymentInformations = new ArrayList<PaymentInformation>();
		PaymentMessage paymentMessage =PaymentMessage.builder().
				id("PaymentMessageId").
				status(createStatus()).
				bic("bic").createdDate(new Date()).id("1").
				messagename("meldingnavn").
				numberOfTransactions(new Integer(1)).
				pain001XML(createPaint001XML()).
				transactionSum(BigDecimal.valueOf(1)).
				status(statusDAO.findOne("RJCT")).
				paymentInformationList(paymentInformations).
				build();
		paymentInformations.add(createPaymentInformation(paymentMessage));
		return paymentMessage;

	}

	private PaymentInformation createPaymentInformation(PaymentMessage paymentMessage){
		return PaymentInformation.builder().
				id("PaymentInformationId").
				paymentMessage(paymentMessage).
				status(statusDAO.findOne("RJCT")).
				debitAccountNumber("debetAccoubt").
				dueDate(new LocalDate()).
				numberOfTransactions(Integer.valueOf(23)).
				transactionsSum(BigDecimal.valueOf(1212.0)).
				build();
	}

	private PaymentTransaction createPaymentTransaction(){
		return PaymentTransaction.builder().
				id("1").
				accountNumber("02020202").
				amount(BigDecimal.valueOf(2000L)).
				currency("NOK").
				endToEndId("VetIkke").
				name("navn").
				status(statusDAO.findOne("RJCT")).
				build();
	}
}

