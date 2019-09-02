package projet.spring.FindMyTravel.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import projet.spring.FindMyTravel.entities.Company;
import projet.spring.FindMyTravel.repositories.CompanyRepository;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	EntityManager em;
	@Autowired
	CompanyRepository cr;
	
	@Override
	public ResponseEntity<Company> addCompany(Company c) {
		em.persist(c);
		return ResponseEntity.ok().build();
	}
	
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
