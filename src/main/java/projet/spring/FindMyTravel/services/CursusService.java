package projet.spring.FindMyTravel.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import projet.spring.FindMyTravel.entities.Cursus;

public interface CursusService {


	ResponseEntity<Cursus> addCursus(Cursus c);

	ResponseEntity<Cursus> findOneCursus(Integer id);

	List<Cursus> findAllCursus();
}
