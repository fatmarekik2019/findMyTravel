package projet.spring.FindMyTravel.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.spring.FindMyTravel.entities.Client;
import projet.spring.FindMyTravel.services.ClientService;

@RestController
@RequestMapping(value="/Client")
public class ClientAPI {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping(value="/addClient")
	public ResponseEntity<Client> addClient(@RequestBody Client c){
		return clientService.addClient(c);
	}

	@GetMapping(value="/getAllClient")
	public List<Client> getAllClient(){
		return clientService.findAllClient();
	}
	
	@GetMapping(value="/getClient/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id){
		return clientService.findOneClient(id);
	}
	
}
