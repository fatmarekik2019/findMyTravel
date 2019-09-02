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

import projet.spring.FindMyTravel.entities.Publication;
import projet.spring.FindMyTravel.services.PublicationService;

@RestController
@RequestMapping("/Publication")
public class PublicationAPI {

	@Autowired
	PublicationService publicationService;
	
	@PostMapping(value="/addPublication")
	public ResponseEntity<Publication> addPub(@RequestBody Publication p){
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
	
}
