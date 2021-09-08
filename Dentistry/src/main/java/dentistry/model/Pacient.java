package dentistry.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Pacient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String emri;
	@NotEmpty
	private String adresa;
	private String tel;
//	@ManyToMany(mappedBy="pacientet")
	@ManyToOne
	@JoinColumn(name="TERMIN_ID")
	private Termin termin;
	 @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "pacient_semundja",
	        joinColumns = @JoinColumn(name = "pacient_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(name = "semundja_id", referencedColumnName = "id"))
	private List<Semundja> semundjet;
	
	public Pacient() {}

	public Pacient(Long id, String emri, String adresa, String tel, Termin terminet, List<Semundja> semundjet) {
		super();
		this.id = id;
		this.emri = emri;
		this.adresa = adresa;
		this.tel = tel;
		this.termin = terminet;
		this.semundjet = semundjet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmri() {
		return emri;
	}

	public void setEmri(String emri) {
		this.emri = emri;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Termin getTerminet() {
		return termin;
	}

	public void setTerminet(Termin terminet) {
		this.termin = terminet;
	}

	public List<Semundja> getSemundjet() {
		return semundjet;
	}

	public void setSemundjet(List<Semundja> semunjdet) {
		this.semundjet = semunjdet;
	}
	
	

}
