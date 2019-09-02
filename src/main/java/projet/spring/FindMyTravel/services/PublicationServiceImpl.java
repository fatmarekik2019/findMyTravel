package projet.spring.FindMyTravel.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projet.spring.FindMyTravel.entities.Publication;
import projet.spring.FindMyTravel.repositories.PublicationRepository;

@Service("pubService")
public class PublicationServiceImpl implements PublicationService{
	

	@Autowired
	EntityManager em;
	@Autowired
	PublicationRepository pr;

	@Transactional
	@Override
	public ResponseEntity<Publication> addPublication(Publication p) {
		em.persist(p);
		return ResponseEntity.ok().build();
	}

	@Transactional
	@Override
	public ResponseEntity<Publication> findOnePublication(Integer id) {
		Publication p = em.find(Publication.class, id);
		if(p==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(p);
	}

	@Override
	public List<Publication> findAllPublication() {
		List<Publication> listPub = new ArrayList<Publication>(pr.findAll());
		return listPub;
	}

}
