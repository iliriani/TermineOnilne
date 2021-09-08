package dentistry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
		
	@Id
	@NotEmpty
	@Column(unique=true)
	private String id;
	@NotEmpty
	private String name;
	@NotEmpty
	@Size(min=3)
	private String pass;
	private String role;
	
	public User() {}

	public User(String id, String name, String pass, String role) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.role = role;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
