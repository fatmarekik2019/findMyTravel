package projet.spring.FindMyTravel.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

protected String userName;
protected String password;
protected String status;
protected Date lastCnxDate;

@Enumerated(EnumType.STRING)
protected Role role;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Date getLastCnxDate() {
	return lastCnxDate;
}

public void setLastCnxDate(Date lastCnxDate) {
	this.lastCnxDate = lastCnxDate;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}


}
