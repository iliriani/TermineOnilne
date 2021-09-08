package dentistry.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dentistry.model.User;
import dentistry.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser() {
		List<User> users= new ArrayList<>();
		userRepository.findAll()
		.forEach(users::add);
		return users;
	}
	
	
	public void addUser(User u) {
		userRepository.save(u);
	}
	
	public User getUser(String name) {
		return (User)userRepository.findByName(name);
	}


	public boolean isUserPresent(String id) {
		User u=userRepository.findById(id).orElse(null);
//		User u=userRepository.findById(id);
		if(u != null) {return true;}
		return false;
	}
}
