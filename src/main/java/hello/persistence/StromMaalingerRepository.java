package hello.persistence;

import hello.entities.StromMaaling;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StromMaalingerRepository extends JpaRepository<StromMaaling, LocalDate> {

}
