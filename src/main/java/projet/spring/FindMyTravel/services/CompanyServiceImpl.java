package projet.spring.FindMyTravel.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projet.spring.FindMyTravel.entities.Company;
import projet.spring.FindMyTravel.entities.Role;
import projet.spring.FindMyTravel.entities.Status;
import projet.spring.FindMyTravel.repositories.CompanyRepository;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	EntityManager em;
	
	@Autowired
	CompanyRepository cr;
	
	@Transactional
	@Override
	public ResponseEntity<Company> addCompany(Company c) {
		c.setRole(Role.company);
		c.setStatus(Status.activated);
		em.persist(c);
		return new ResponseEntity<Company>(c,HttpStatus.CREATED);
	}
	
	@Transactional
	@Override
	public ResponseEntity<Company> findOneCompany(Integer id) {
		Company c = em.find(Company.class, id);
		if(c==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(c);
	}
	@Override
	public List<Company> findAllCompany() {
		List<Company> listCompany = new ArrayList<Company>(cr.findAll());
		return listCompany;
	}
}
