package projet.spring.FindMyTravel.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import projet.spring.FindMyTravel.entities.Client;
import projet.spring.FindMyTravel.entities.User;


public interface ClientService {
	public String addClient(Client c);
	public Boolean verifUserName(String username);
	public ResponseEntity<Client> findOneClient(Integer id);
	public List<Client> findAllClient();
}
