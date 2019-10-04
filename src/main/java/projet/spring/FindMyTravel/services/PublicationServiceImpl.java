package projet.spring.FindMyTravel.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projet.spring.FindMyTravel.entities.Publication;
import projet.spring.FindMyTravel.entities.Status;
import projet.spring.FindMyTravel.entities.User;
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
		return ResponseEntity.ok().body(p);
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
	
	@Transactional
	@Override
	public List<Publication> findAllPublicationById(Integer id){
		TypedQuery<Publication> query = (TypedQuery<Publication>) em.createQuery("SELECT p FROM Publication p WHERE p.client.id = :id" ,Publication.class);
		List<Publication> ListP = query.setParameter("id", id).getResultList();
		
		return ListP;
	}

	@Override
	public List<Publication> findAllPublication() {
		List<Publication> listPub = new ArrayList<Publication>(pr.findAll());
		return listPub;
	}
	@Override
	public List<Publication> getActivatedPublication(){
		TypedQuery<Publication> query = (TypedQuery<Publication>) em.createQuery("SELECT p FROM Publication p WHERE p.status = :activated" ,Publication.class);
		List<Publication> ListP = query.setParameter("activated", Status.activated).getResultList();
		
		return ListP;
	}
	@Override
	public List<Publication> getRecentPublication(){
		TypedQuery<Publication> query = (TypedQuery<Publication>) em.createQuery("SELECT p FROM Publication p  WHERE p.status = :activated ORDER BY id DESC");
		List<Publication> ListP = query.setParameter("activated", Status.activated).setMaxResults(4).getResultList();
		
		return ListP;
	}

}
