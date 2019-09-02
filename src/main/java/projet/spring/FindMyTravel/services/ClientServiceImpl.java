package projet.spring.FindMyTravel.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projet.spring.FindMyTravel.entities.Client;
import projet.spring.FindMyTravel.repositories.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	EntityManager em;
	@Autowired
	ClientRepository cr;
	
	@Transactional
	@Override
	public ResponseEntity<Client> addClient(Client c) {
		em.persist(c);
		return ResponseEntity.ok().build();
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
