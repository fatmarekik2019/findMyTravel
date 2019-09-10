package projet.spring.FindMyTravel.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projet.spring.FindMyTravel.entities.Client;
import projet.spring.FindMyTravel.entities.Role;
import projet.spring.FindMyTravel.entities.Status;
import projet.spring.FindMyTravel.entities.User;
import projet.spring.FindMyTravel.repositories.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	EntityManager em;
	@Autowired
	ClientRepository cr;
	
	@Transactional
	@Override
	public String addClient(Client c) {
		c.setRole(Role.client);
		c.setStatus(Status.activated);
		em.persist(c);
		return "ok";
	}
	
	@Transactional
	@Override
	public Boolean verifUserName(String username) {
		
		TypedQuery<User> query = (TypedQuery<User>) em.createQuery("SELECT u FROM User u WHERE u.userName = :username" ,User.class);
		List<User> u=query.setParameter("username", username).getResultList();
		
		if(u.isEmpty() == true) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
	@Transactional
	@Override
	public ResponseEntity<Client> findOneClient(Integer id) {
		Client c = em.find(Client.class, id);
		if(c==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(c);
	}
	
	
	@Override
	public List<Client> findAllClient() {
		List<Client> listClient = new ArrayList<Client>(cr.findAll());
		return listClient;
	}
}
