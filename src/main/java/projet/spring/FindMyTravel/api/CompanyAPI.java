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

import projet.spring.FindMyTravel.entities.Company;
import projet.spring.FindMyTravel.services.CompanyService;

@RestController
@RequestMapping(value="/Company")
public class CompanyAPI {

	@Autowired
	CompanyService companyService;
	
	@PostMapping(value="/addCompany")
	public ResponseEntity<Company> addCompany(@RequestBody Company c){
		return companyService.addCompany(c);
	}
	
	@GetMapping(value="/getAllCompany")
	public List<Company> getAllCompany(){
		return companyService.findAllCompany();
	}
	
	@GetMapping(value="/getCompany/{id}")
	public ResponseEntity<Company> getOneCompany(@PathVariable("id") Integer id) {
		return companyService.findOneCompany(id);
	}
}
