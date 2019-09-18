package projet.spring.FindMyTravel.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import projet.spring.FindMyTravel.entities.Client;


public interface ClientService {
	public String addClient(Client c);
	public Boolean verifUserName(String username);
	public ResponseEntity<Client> findOneClient(Integer id);
	public List<Client> findAllClient();
	public ResponseEntity getByUserName(String username);
<<<<<<< HEAD
	public ResponseEntity update(Client c);
=======
	
>>>>>>> a7fa7b3b7118b9a29a736e06a340ec997bdf2f3f
}
