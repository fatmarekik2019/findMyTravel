package projet.spring.FindMyTravel.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import projet.spring.FindMyTravel.entities.Image;
import projet.spring.FindMyTravel.repositories.ImageRepository;

@Service("imgService")
public class ImageServiceImpl implements ImageService{

	@Autowired
	EntityManager em;
	@Autowired
	ImageRepository ir;
	
	@Override
	public ResponseEntity<Image> addImage(Image i) {
		em.persist(i);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Image> findOneImage(Integer id) {
		Image i = em.find(Image.class, id);
		if(i==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(i);
	}

	@Override
	public List<Image> findAllImage() {
		List<Image> listImage = new ArrayList<Image>(ir.findAll());
		return listImage;
	}
	

}
