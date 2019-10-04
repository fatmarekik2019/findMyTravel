package projet.spring.FindMyTravel.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import projet.spring.FindMyTravel.entities.Publication;

public interface PublicationService {
	
	ResponseEntity<Publication> addPublication(Publication c);

	ResponseEntity<Publication> findOnePublication(Integer id);

	List<Publication> findAllPublication();
	
	List<Publication> findAllPublicationById(Integer id);

	List<Publication> getActivatedPublication();

	List<Publication> getRecentPublication();

}
