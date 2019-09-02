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

import projet.spring.FindMyTravel.entities.Cursus;
import projet.spring.FindMyTravel.services.CursusService;

@RestController
@RequestMapping("/Cursus")
public class CursusAPI {

	@Autowired
	CursusService cursusService;
	
	@PostMapping(value="/addCursus")
	public ResponseEntity<Cursus> addCursus(@RequestBody Cursus c){
		return cursusService.addCursus(c);
	}
	
	@GetMapping(value="/getAllCursus")
	public List<Cursus> getAllCursus(){
		return cursusService.findAllCursus();
	}
	
	@GetMapping(value="/getCursus/{id}")
	public ResponseEntity<Cursus> getOneCursus(@PathVariable("id") Integer id){
		return cursusService.findOneCursus(id);
	}
	
}
