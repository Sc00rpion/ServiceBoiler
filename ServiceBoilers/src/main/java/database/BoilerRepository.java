package database;

import org.springframework.data.repository.CrudRepository;

import entity.Boiler;

public interface BoilerRepository extends CrudRepository<Boiler, Long> {

}
