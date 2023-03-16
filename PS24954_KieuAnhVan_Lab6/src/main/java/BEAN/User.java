package BEAN;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name="User.findUserById" , query = "Select o from User o where  o.id=:idInput")

})


@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long Id;
	

	private String  Fullname;
	

	private String Password;
	

	private String Email;
	

	private Boolean Admin = false;
	@OneToMany(mappedBy = "User")
	List<Favourite> favorites;

	public User() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(Boolean admin) {
		Admin = admin;
	}
	

	public List<Favourite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favourite> favorites) {
		this.favorites = favorites;
	}

	public Boolean getAdmin() {
		return Admin;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", Fullname=" + Fullname + ", Password=" + Password + ", Email=" + Email + ", Admin="
				+ Admin + "]";
	}
	
}
