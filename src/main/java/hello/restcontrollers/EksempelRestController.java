package hello.restcontrollers;

import hello.entities.Customer;
import hello.entities.CustomerOrder;
import hello.entities.Status;
import hello.entities.StromMaaling;
import hello.persistence.CustomerRepository;
import hello.persistence.CustomerOrderRepository;
import hello.persistence.StatusDAO;
import hello.persistence.StromMaalingerRepository;
import hello.services.MaalingerService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/eksempler")
@Transactional
public class EksempelRestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    MaalingerService maalingerService;

    @Autowired
    StatusDAO statusDAO;

    @Autowired
    StromMaalingerRepository stromMaalingerRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerOrderRepository customerOrderRepository;


    /**
     * Registrer faste register
     * @return
     */
    @RequestMapping(value = "/fasteregister",method = RequestMethod.GET,produces = "application/json")
    public Boolean fasteregister() {
        Boolean resultat=false;
        if(statusDAO!=null){
           if(statusDAO.findAll()!=null && statusDAO.findAll().size()<=0){
            statusDAO.save(Status.builder().statusDefinition("ACTC").code("Accepted technical").build());
            statusDAO.save(Status.builder().statusDefinition("RCVD").code("Received").build());
            statusDAO.save(Status.builder().statusDefinition("PART").code("Partially accepted").build());
            statusDAO.save(Status.builder().statusDefinition("RJCT").code("Rejected").build());
            statusDAO.save(Status.builder().statusDefinition("PDNG").code("Pending").build());
            statusDAO.save(Status.builder().statusDefinition("ACCP").code("'Accepted'").build());
            statusDAO.save(Status.builder().statusDefinition("ACSP").code("Accepted settlement in process").build());
            statusDAO.save(Status.builder().statusDefinition("ACSC").code("Accepted settlement completed").build());
            statusDAO.save(Status.builder().statusDefinition("ACWC").code("Accepted with change").build());

            stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate()).melding("Hallo").totaltForbruk(1000L).utleieForbruk(300L).build());
            stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(1)).melding("Hallo1").totaltForbruk(1000L).utleieForbruk(300L).build());
            stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(2)).melding("Hallo2").totaltForbruk(1010L).utleieForbruk(400L).build());
            stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(3)).melding("Hallo3").totaltForbruk(1200L).utleieForbruk(500L).build());
            stromMaalingerRepository.save(StromMaaling.builder().dato(new LocalDate().minusDays(4)).melding("Hallo4").totaltForbruk(1003L).utleieForbruk(200L).build());

               http://localhost:8080/stromsystem/fasteregister.save(Customer.builder().ssn("1").firstName("Tore1").lastName("Andersen1").build());
            customerRepository.save(Customer.builder().ssn("2").firstName("Tore2").lastName("Andersen2").build());
            customerRepository.save(Customer.builder().ssn("3").firstName("Tore3").lastName("Andersen3").build());
            customerRepository.save(Customer.builder().ssn("4").firstName("Tore4").lastName("Andersen4").build());

               return true;
           }
        }
        else return false;

        return resultat;
    }

//    @RequestMapping(value = "/getstatuser",produces = "application/json")
//    public List<Status> hentstatuser() {
//        return maalingerService.hentStatuser();
//    }

    @RequestMapping(value= "/getmaalinger",produces = "application/json")
    public List<StromMaaling> getmaalinger() {
        return stromMaalingerRepository.findAll();
    }

    //ResponseEntity<String>
    @RequestMapping(value = "/oppdaterkunde/{id}/{navn}",method = RequestMethod.GET, produces = "application/json")
    public boolean registereroppdater(@PathVariable String id,@PathVariable String navn) {
        Boolean ok=false;
        Customer customer = customerRepository.getOne(id);
        customer.setFirstName(navn);
        ok=true;
//        if(navn!=null){
//         if(navn.trim().toUpperCase().equals("save")) customerRepository.save(customer);
//         else  if(navn.trim().toUpperCase().equals("savef")) customerRepository.saveAndFlush(customer);
//        }
       //return customerRepository.save(customer);
        return ok;
    }

    @RequestMapping(value="/getregistrerordre/{id}/{ordreid}",produces = "application/json")
    public boolean hentekunder(@PathVariable String id,@PathVariable String ordreid) {
        Boolean ok=false;
        Customer customer = customerRepository.findOne(id);
        if(customer!=null){
            CustomerOrder customerOrder1 = CustomerOrder.builder().
                    customerOrderId(ordreid).
                    name("Bestille123").
                    customer(customer).
                    build();
            customer.getOrders().add(customerOrder1);

            CustomerOrder customerOrder2 = CustomerOrder.builder().
                    customerOrderId(ordreid+"1").
                    name("Bestille1234").
                    customer(customer).
                    build();
            customer.getOrders().add(customerOrder2);
            ok=true;
        }
        return ok;
    }

//
//    private List<StromMaaling> getStromMaalinger(){
//        List<StromMaaling> maalinger = new ArrayList<StromMaaling>();
//
//        StromMaaling maaling = StromMaaling.builder().dato(new LocalDate()).
//                melding("Hallo").
//                totaltForbruk(1000L).utleieForbruk(300L).
//                build();
//        maalinger.add(maaling);
//        return maalinger;
//    }
}
