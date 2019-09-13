package projet.spring.FindMyTravel.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import projet.spring.FindMyTravel.entities.*;


@Service("userservice")
public class UserDetailsService implements UserService{

@Autowired
PasswordEncoder passwordEncoder;
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public User loadByUsername(String username, String password) {
		
		TypedQuery<User> query = (TypedQuery<User>) em.createQuery("SELECT u FROM User u WHERE u.userName = :username" ,User.class);
		User u=query.setParameter("username", username).getSingleResult();
		
         Boolean decodedPassword = passwordEncoder.matches(password, u.getPassword());
		 if(decodedPassword) {
				return  u;	
		 } else {
			 return null;
		 }
	}
	@Override
	public User loadByUsernameToken(String username) {
		
		TypedQuery<User> query = (TypedQuery<User>) em.createQuery("SELECT u FROM User u WHERE u.userName = :username" ,User.class);
		User u=query.setParameter("username", username).getSingleResult();
		
        return  u;	
		 
	}

}
