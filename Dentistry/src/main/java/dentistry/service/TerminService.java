package dentistry.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dentistry.model.Termin;
import dentistry.repository.TerminRepository;

@Service
public class TerminService {

	@Autowired
	private TerminRepository terminRepository;
	
	public List<Termin> getAllTermins() {
//		List<Termin> termins= new ArrayList<>();
//		terminRepository.findAll()
//		.forEach(termins::add);
		return (List<Termin>) terminRepository.findAll();
	}

//	public List<Termin> findByPacient(String name) {
////		Termin t= terminRepository.findById(name).orElse(null);
//		return terminRepository.findByPacientetLike("%"+name+"%");
////		return t;
//	}
	

	public List<Termin> gjejSipasDates(String koha) {
//		Termin t= terminRepository.findById(name).orElse(null);
		return terminRepository.findSipasDates(koha);
//		return t;
	}
	
//	public List<Termin> findAll() {
////		Termin t= terminRepository.findById(name).orElse(null);
//		return terminRepository.findAll();
////		return t;
//	}

	public void shtoTermin(Termin t) {
		terminRepository.save(t);
		
	}
	
	
	
}
