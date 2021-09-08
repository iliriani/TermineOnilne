package dentistry.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Semundja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String emri;
	@ManyToMany(mappedBy="semundjet")
	private List<Pacient> pacientet;

	public Semundja() {}

	public Semundja(int id, String emri, List<Pacient> pacientet) {
		super();
		this.id = id;
		this.emri = emri;
		this.pacientet = pacientet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmri() {
		return emri;
	}

	public void setEmri(String emri) {
		this.emri = emri;
	}

	public List<Pacient> getPacientet() {
		return pacientet;
	}

	public void setPacientet(List<Pacient> pacientet) {
		this.pacientet = pacientet;
	}
	
	
	
}
