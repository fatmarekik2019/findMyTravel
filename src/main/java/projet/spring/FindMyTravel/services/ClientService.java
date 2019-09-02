package projet.spring.FindMyTravel.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import projet.spring.FindMyTravel.entities.Client;


public interface ClientService {
	public ResponseEntity<Client> addClient(Client c);
	public ResponseEntity<Client> findOneClient(Integer id);
	public List<Client> findAllClient();
}
