package projet.spring.FindMyTravel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import projet.spring.FindMyTravel.entities.Company;
import projet.spring.FindMyTravel.entities.Cursus;
import projet.spring.FindMyTravel.entities.Publication;
import projet.spring.FindMyTravel.services.CompanyService;
import projet.spring.FindMyTravel.services.CursusService;

@RestController
@RequestMapping("/Cursus")
public class CursusAPI {

	@Autowired
	CursusService cursusService;
	
	@Autowired
	CompanyService companyservice;
	
	@PostMapping(value="/addCursus/{companyid}")
	public ResponseEntity<Cursus> addCursus(@RequestBody Cursus c, @PathVariable("companyid") Integer companyid){
		Company company = companyservice.getCompanyById(companyid);
		c.setCompany(company);
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
	
	@RequestMapping(value = "/updateCursus/{companyid}/{cursusid}", method = RequestMethod.POST)
	public Cursus UpdateDepartement(@RequestBody Cursus cursus, @PathVariable("cursusid") Integer cursusid, @PathVariable("companyid") Integer companyid) {
		
		Company company = companyservice.getCompanyById(companyid);
		cursus.setCompany(company);
		cursus.setId(cursusid);
    	cursus.setId(cursusid);
    	return cursusService.UpdateCursus(cursus);
	
		
    	
	}
	
	@GetMapping(value="/getActivatedCursus")
	public List<Cursus> getActivatedPublication(){
		return cursusService.getActivatedCursus();
	}
	
}
