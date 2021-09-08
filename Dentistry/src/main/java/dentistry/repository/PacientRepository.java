package dentistry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dentistry.model.Pacient;

public interface PacientRepository extends CrudRepository<Pacient,Long>{

//	@Query(value="Select * from pacient where emri like \"%ismet%\"")
	List<Pacient> findByEmriLike(String emri);
}
