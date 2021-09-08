package dentistry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dentistry.model.Pacient;
import dentistry.repository.PacientRepository;
import dentistry.repository.TerminRepository;

@Service
public class PacientService {

	@Autowired
	private PacientRepository pacientRepository;
	
	
	public List<Pacient> getPacientByName(String emri) {
		return pacientRepository.findByEmriLike("%"+emri+"%");
	}
	
}
