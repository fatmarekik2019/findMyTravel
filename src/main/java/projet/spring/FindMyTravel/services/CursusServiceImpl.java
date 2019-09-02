package projet.spring.FindMyTravel.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import projet.spring.FindMyTravel.entities.Cursus;
import projet.spring.FindMyTravel.repositories.CursusRepository;

@Service("curService")
public class CursusServiceImpl implements CursusService{

	@Autowired
	EntityManager em;
	@Autowired
	CursusRepository cr;
	
	@Override
	public ResponseEntity<Cursus> addCursus(Cursus c) {
		em.persist(c);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Cursus> findOneCursus(Integer id) {
		Cursus c = em.find(Cursus.class, id);
		if(c==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(c);
	}

	@Override
	public List<Cursus> findAllCursus() {
		
		List<Cursus> listCursus = new ArrayList<Cursus>(cr.findAll());
		return listCursus;
		
	}

	
}
