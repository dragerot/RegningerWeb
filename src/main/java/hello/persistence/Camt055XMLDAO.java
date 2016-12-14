package hello.persistence;

import hello.entities.Camt055XML;
import hello.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface Camt055XMLDAO extends JpaRepository<Camt055XML, String> {

    List<Camt055XML> findByCreatedDate(Date paymentDate);

    List<Camt055XML> findByCreatedDateGreaterThan(Date paymentDate);

    List<Camt055XML> findByCreatedDateGreaterThanEqual(Date paymentDate);

    List<Camt055XML> findByCreatedDateLessThan(Date paymentDate);

    List<Camt055XML> findByCreatedDateLessThanEqual(Date paymentDate);

    @Query("Select c from Camt055XML c where c.status =?1")
    List<Camt055XML> findByStatus(Status status);

    List<Camt055XML> findByStatusCode(String statusCode);

}