package projet.spring.FindMyTravel.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String address;
	private String description;
	private Long cost;
	private Integer duration;
	private Date createdDate = new Date();
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JsonIgnore
	private Client client;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name="publication_cursus", joinColumns = { @JoinColumn(name = "publication_id")}, inverseJoinColumns = { @JoinColumn(name = "cursus_id")})
	private List<Cursus> ListCursus = new ArrayList<Cursus>();
	
	@OneToMany(mappedBy="publication", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Image> listImage = new ArrayList<Image>();
	
	public List<Cursus> getListCursus() {
		return ListCursus;
	}
	public void setListCursus(List<Cursus> listCursus) {
		ListCursus = listCursus;
	}
	public List<Image> getListImage() {
		return listImage;
	}
	public void setListImage(List<Image> listImage) {
		this.listImage = listImage;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
