package projet.spring.FindMyTravel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.spring.FindMyTravel.entities.Publication;
import projet.spring.FindMyTravel.services.ClientService;
import projet.spring.FindMyTravel.services.PublicationService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Publication")
public class PublicationAPI {

	@Autowired
	PublicationService publicationService;
	@Autowired
	ClientService clientService;
	
	@PostMapping(value="/addPublication/{id}")
	public ResponseEntity<Publication> addPub(@RequestBody Publication p, @PathVariable("id") Integer id){
		p.setClient(clientService.findOneClient(id).getBody());
		return publicationService.addPublication(p);
	}
	
	@GetMapping(value="/getAllPublication")
	public List<Publication> getAllPub(){
		return publicationService.findAllPublication();
	}
	
	@GetMapping(value="/getOnePublication/{id}")
	public ResponseEntity<Publication> getOnePub(@PathVariable("id") Integer id){
		return publicationService.findOnePublication(id);
	}
	@GetMapping(value="/getAllPublicationById/{id}")
	public List<Publication> getAllPubById(@PathVariable("id") Integer id){
		return publicationService.findAllPublicationById(id);
	}
	
	@GetMapping(value="/getActivatedPublication")
	public List<Publication> getActivatedPublication(){
		return publicationService.getActivatedPublication();
	}
	
	@GetMapping(value="/getRecentPublication")
	public List<Publication> getRecentPublication(){
		return publicationService.getRecentPublication();
	}
	
}
