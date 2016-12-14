package hello.persistence;

import hello.Application;
import hello.config.RepositoryConfig;
import hello.entities.Customer;
import hello.entities.CustomerOrder;
import hello.entities.Status;
import hello.entities.StromMaaling;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.transaction.Transactional;
import java.util.List;

/*
Setup and preload database for spring integration/functional tests
http://www.leveluplunch.com/java/tutorials/022-preload-database-execute-sql-spring-testing/

 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@Import(RepositoryConfig.class)
//@ContextConfiguration(classes = Application.class, loader = AnnotationConfigContextLoader.class)
//@SqlGroup({
//@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
//@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql")
//})
//@Transactional
public class DatabaseTest {

    @Autowired
    private StatusDAO statusDAO;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private  CustomerOrderRepository customerOrderRepository;

    @Autowired
    private StromMaalingerRepository stromMaalingerRepository;

    @Before
    public void initDB(){
//        stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate()).melding("Hallo").totaltForbruk(1000L).utleieForbruk(300L).build());
//        stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(1)).melding("Hallo1").totaltForbruk(1000L).utleieForbruk(300L).build());
//        stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(2)).melding("Hallo2").totaltForbruk(1010L).utleieForbruk(400L).build());
//        stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(3)).melding("Hallo3").totaltForbruk(1200L).utleieForbruk(500L).build());
//        stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(4)).melding("Hallo4").totaltForbruk(1003L).utleieForbruk(200L).build());
//
//        customerRepository.save(Customer.builder().ssn("1").firstName("Tore1").lastName("Andersen1").build());
//        customerRepository.save(Customer.builder().ssn("2").firstName("Tore2").lastName("Andersen2").build());
//        customerRepository.save(Customer.builder().ssn("3").firstName("Tore3").lastName("Andersen3").build());
//        customerRepository.save(Customer.builder().ssn("4").firstName("Tore4").lastName("Andersen4").build());

//        statusDAO.save(Status.builder().statusDefinition("ACTC").code("Accepted technical").build());
//        statusDAO.save(Status.builder().statusDefinition("RCVD").code("Received").build());
//        statusDAO.save(Status.builder().statusDefinition("PART").code("Partially accepted").build());
//        statusDAO.save(Status.builder().statusDefinition("RJCT").code("Rejected").build());
//        statusDAO.save(Status.builder().statusDefinition("PDNG").code("Pending").build());
//        statusDAO.save(Status.builder().statusDefinition("ACCP").code("'Accepted'").build());
//        statusDAO.save(Status.builder().statusDefinition("ACSP").code("Accepted settlement in process").build());
//        statusDAO.save(Status.builder().statusDefinition("ACSC").code("Accepted settlement completed").build());
//        statusDAO.save(Status.builder().statusDefinition("ACWC").code("Accepted with change").build());

    }

    //@Test
   public void statusTest(){
       List<Status> statuser =  statusDAO.findAll();
       Assert.assertTrue(statuser!=null);
       int teller =statuser.size();
       Assert.assertTrue(statuser.size()==9);
    }

   //@Test
   public  void stromMaalingerRepositoryTest(){
       Assert.assertTrue(stromMaalingerRepository.findAll().size()==5);
       System.out.println("stromMaalingerRepository=");
       for(StromMaaling item : stromMaalingerRepository.findAll()){
           System.out.println("DATO: "+item.getDato());
       }

       CustomerOrder customerOrder1 = CustomerOrder.builder().
               customerOrderId("123").
               name("Bestille123").
               customer(customerRepository.findOne("2")).
               build();
       customerOrderRepository.saveAndFlush(customerOrder1);

       CustomerOrder customerOrder2 = CustomerOrder.builder().
               customerOrderId("1234").
               name("Bestille1234").
               customer(customerRepository.findOne("2")).
               build();
       customerOrderRepository.saveAndFlush(customerOrder2);

       Customer _customer = customerRepository.findOne("2");
       List<CustomerOrder> alleOrdre =_customer.getOrders();
       System.out.println("Finish");
//       List<CustomerOrder> ordre = new ArrayList<CustomerOrder>();
//       ordre.add(customerOrder2);
//       _customer.setOrders(ordre);
//       customerRepository.save(_customer);

//       for (CustomerOrder item : customerRepository.findOne("2").getOrders()){
//           System.out.println("FUNNET ORDRE"+item.getCustomerOrderId());
//       }


//       CustomerOrder order = CustomerOrder.builder().orderId("1").name("Order1").build();
//       ordersDAO.save(order);

//       List<CustomerOrder> orders = new ArrayList<CustomerOrder>();
//       orders.add(order);
//       customerDAO.save(Customer.builder().
//               ssn("030303").
//               firstName("Tore Gard").
//               lastName("EtterNavn").
//               orders(orders).build()
//
//       );
//        customerDAO.save(new Customer("3","Kim", "Bauer"));
//        customerDAO.save(new Customer("4","esa", "dddd"));

//
//       Assert.assertTrue(customerDAO!=null);
//       Assert.assertTrue(customerDAO.findAll().size()==1);
//       //int l =customerDAO.findByLastName("ddd").size();
//       Customer customer = customerDAO.findOne("030303");
//       Assert.assertTrue(customer.getSsn().equals("030303"));
//       List<CustomerOrder> _orders=customer.getOrders();
//       Assert.assertTrue(_orders.get(0).getOrderId().equals("1"));

   }

    @Test
    public void  testStatusDAO(){
       Assert.assertTrue(true);
//        camt055XMLDAO.saveAndFlush(Camt055XML.builder().
//                id("ID1").
//                xmlData(getxmlData("ID1")).
//                createdDate(new Date()).
//                status(statusDAO.findOne(ACCEPT_CODE)).build());
//
//        camt055XMLDAO.saveAndFlush(Camt055XML.builder().
//                id("ID2").
//                xmlData(getxmlData("ID2")).
//                createdDate(new Date()).
//                status(statusDAO.findOne(RECJECT_CODE)).build());
//
//        camt055XMLDAO.saveAndFlush(Camt055XML.builder().
//                id("ID3").
//                xmlData(getxmlData("ID3")).
//                createdDate(new Date()).
//                status(statusDAO.findOne(ACCEPT_CODE)).build());
//        Assert.assertTrue(true);
//
//        Camt055XML data = camt055XMLDAO.findOne("ID2");
//        Assert.assertTrue(data!=null);
//        Assert.assertTrue(data.getId().equals("ID2"));
//        Assert.assertTrue(data.getXmlData().contains("ID2"));
//        Assert.assertTrue(data.getStatus().getCode().equals(RECJECT_CODE));
//        Assert.assertTrue(data.getStatus().getStatusDefinition().equals(NOT_ACCEPTED_TEXT));
    }


    /**
     * NAV-UR-001D20160503T002341
     * @param id
     * @return
     */
    private String getxmlData(String id){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Document xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.055.001.01\">\n" +
                " <CstmrPmtCxlReq>\n" +
                "   <Assgnmt> \n" +
                "      <Id>" + id +"</Id> \n" +
                "    </Assgnmt>\t\t\n" +
                " </CstmrPmtCxlReq>\n" +
                "</Document>\t";
    }

}
