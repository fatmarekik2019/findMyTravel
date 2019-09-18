package projet.spring.FindMyTravel.services;


import projet.spring.FindMyTravel.entities.User;


public interface UserService {
	
	public User loadByUsername(String username, String password);
<<<<<<< HEAD
	public User loadByUsernameToken(String username);
	public Boolean userCheckPassword(String username, String password);
=======

	public User loadByUsernameToken(String username);
	public User updatePassword(User user);
	
>>>>>>> a7fa7b3b7118b9a29a736e06a340ec997bdf2f3f
	
}
