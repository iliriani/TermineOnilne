package dentistry.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dentistry.model.*;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	List<User> findByName(String name);
//	Optional<User> findById(String id);
}
