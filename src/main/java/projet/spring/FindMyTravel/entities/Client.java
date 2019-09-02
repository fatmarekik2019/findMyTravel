package projet.spring.FindMyTravel.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Client extends User{

	private String firstName;
	private String lastName;
	private Date birthday;
	public Client() {
		super();
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

}
