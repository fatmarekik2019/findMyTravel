package projet.spring.FindMyTravel.services;


import projet.spring.FindMyTravel.entities.User;


public interface UserService {
	
	public User loadByUsername(String username, String password);

	User loadByUsernameToken(String username);
	
	
}
