package projet.spring.FindMyTravel.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Client extends User{

	private String firstName;
	private String lastName;
	private String image;
	private String statut;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	
	public Client() {
		super();
	}
	public Client(String userName, String password, String firstName, String lastName, String image, String statut) {
	
		super(userName, password);
		this.firstName=firstName;
		this.lastName=lastName;
		this.image=image;
		this.statut=statut;
	}

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Publication> ListPublication = new ArrayList<Publication>();
	
	public List<Publication> getListPublication() {
		return ListPublication;
	}
	public void setListPublication(List<Publication> listPublication) {
		ListPublication = listPublication;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	

}
