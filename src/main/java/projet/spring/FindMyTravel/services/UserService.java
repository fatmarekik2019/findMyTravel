package projet.spring.FindMyTravel.services;


import projet.spring.FindMyTravel.entities.User;


public interface UserService {
	
	public User loadByUsername(String username, String password);
	public User loadByUsernameToken(String username);
	public Boolean userCheckPassword(String username, String password);
	public User updatePassword(User user);
	
	
}
