package dentistry.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Termin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date koha;
	
//	 @ManyToMany(cascade = CascadeType.ALL)
//	    @JoinTable(name = "termin_pacient",
//	        joinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"),
//	        inverseJoinColumns = @JoinColumn(name = "pacient_id", referencedColumnName = "id"))
	
	@OneToMany(mappedBy="termin", cascade=CascadeType.ALL)
	private List<Pacient> pacientet = new ArrayList<Pacient>();
	


	public Termin() {}


	public Termin(Date koha, Long pacient_id) {
		super();
		this.id = id;
		this.koha = koha;
//		this.pacientet = pacientet;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getKoha() {
		return koha;
	}


	public void setKoha(Date koha) {
		this.koha = koha;
	}


	public List<Pacient> getPacientet() {
		return pacientet;
	}


	public void setPacientet(List<Pacient> pacientet) {
		this.pacientet = pacientet;
	}
	
	
	public void addPacient(Pacient p) {
		this.pacientet.add(p);
	}
}
