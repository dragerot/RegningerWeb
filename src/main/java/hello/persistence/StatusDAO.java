package hello.persistence;

import hello.entities.Status;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDAO extends JpaRepository<Status, String> {

}