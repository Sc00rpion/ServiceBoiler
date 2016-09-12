package database;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.Boiler;

public interface BoilerRepository extends JpaRepository<Boiler, Long> {
	
	List<Boiler> findByAddressCity(String city);
	
	@Query("select b from Boiler b where (select max(s.dateOfService) from Boiler c join c.service s where c.id = b.id) between :start and :end")
	List<Boiler> findByService(@Param("start") Date start, @Param("end") Date end);

}
