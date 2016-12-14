package hello.persistence;

import java.util.Date;
import java.util.List;

import hello.entities.Pain001XML;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Pain001XMLDAO extends JpaRepository<Pain001XML, String> {

    List<Pain001XML> findByCreatedDate(Date createdDate);

    List<Pain001XML> findByCreatedDateGreaterThan(Date createdDate);

    List<Pain001XML> findByCreatedDateGreaterThanEqual(Date createdDate);

    List<Pain001XML> findByCreatedDateLessThan(Date createdDate);

    List<Pain001XML> findByCreatedDateLessThanEqual(Date createdDate);

}