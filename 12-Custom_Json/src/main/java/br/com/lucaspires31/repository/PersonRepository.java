package br.com.lucaspires31.repository;

import br.com.lucaspires31.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
