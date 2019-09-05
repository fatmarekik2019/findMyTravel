package projet.spring.FindMyTravel.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Service;


import projet.spring.FindMyTravel.entities.*;


@Service("userservice")
public class UserDetailsService implements UserService{


	@PersistenceContext
	EntityManager em;
	
	
	
	@Override
	public User loadByUsername(String username) {
		
		TypedQuery<User> query = (TypedQuery<User>) em.createQuery("SELECT u FROM User u WHERE u.userName = :username" ,User.class);
		User u=query.setParameter("username", username).getSingleResult();
			return  u;	
	}

}
