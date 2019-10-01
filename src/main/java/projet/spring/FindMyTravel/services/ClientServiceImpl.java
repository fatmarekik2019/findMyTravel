package projet.spring.FindMyTravel.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity getByUserName(String username) {
		
		TypedQuery<User> query = (TypedQuery<User>) em.createQuery("SELECT u FROM User u WHERE u.userName = :username" ,User.class);
		User u=query.setParameter("username", username).getSingleResult();
		
		if(u==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
		else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
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
	@Transactional
	@Override
	public ResponseEntity update(Client c) {
		Client client = em.find(Client.class, c.getId());
		client.setFirstName(c.getFirstName());
		client.setLastName(c.getLastName());
		client.setBirthday(c.getBirthday());
		client.setStatut(c.getStatut());
		em.merge(client);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(client);
	}
	
	@Transactional
	@Override
	public ResponseEntity<?> updateImage(Client c) {
		Client client = em.find(Client.class, c.getId());
		client.setImage(c.getImage());
		System.out.print("----ID-----"+c.getId()+"----"+c.getImage());
		em.merge(client);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(client);
	}
}
