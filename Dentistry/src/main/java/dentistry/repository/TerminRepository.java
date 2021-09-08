package dentistry.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dentistry.model.*;

public interface TerminRepository extends JpaRepository<Termin,Long>{

	List<Termin> findAll();
	List<Termin> findByPacientetLike(String pacient);
	Optional<Termin> findById(Long s);
	
//	@Query(value="select * from termin where DATE(koha) = ?1", nativeQuery=true)
	@Query(value="select * from termin where DATE(koha)=?1", nativeQuery=true)
	List<Termin> findSipasDates(String date);

}
