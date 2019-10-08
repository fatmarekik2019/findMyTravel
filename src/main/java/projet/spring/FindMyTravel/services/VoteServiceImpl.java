package projet.spring.FindMyTravel.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projet.spring.FindMyTravel.entities.Client;
import projet.spring.FindMyTravel.entities.Publication;
import projet.spring.FindMyTravel.entities.Vote;
import projet.spring.FindMyTravel.repositories.ClientRepository;
import projet.spring.FindMyTravel.repositories.PublicationRepository;
import projet.spring.FindMyTravel.repositories.VoteRepository;

@Service("voteService")
public class VoteServiceImpl implements VoteService{
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	VoteRepository voteRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	PublicationRepository publicationRepository;
	
	@Transactional
	@Override
	public ResponseEntity<?> votePublication(Vote vote, Integer ClientId, Integer PublicationId) {
		
		TypedQuery<Vote> query = (TypedQuery<Vote>) em.createQuery("SELECT v FROM Vote v WHERE v.client.id = :client_id AND v.publication.id = :publication_id", Vote.class);
		List<Vote> Listvote =query.setParameter("client_id", ClientId).setParameter("publication_id", PublicationId).getResultList();
		if(Listvote.isEmpty()) {
			
			Client c = clientRepository.getOne(ClientId);
			Publication p = publicationRepository.getOne(PublicationId);
			vote.setClient(c);
			vote.setPublication(p);
			em.persist(vote);
			return ResponseEntity.ok(vote);
		}
		else {
			
			voteRepository.deleteAll(Listvote);
			return null;
		}

	}
	
	@Override
	public List<Vote> getVoteList(Integer clientId)
	{
		TypedQuery<Vote> query = (TypedQuery<Vote>) em.createQuery("SELECT v.publication.id FROM Vote v WHERE v.client.id = :client_id");
		List<Vote> Listvote = query.setParameter("client_id", clientId).getResultList();
		return Listvote;
		
	}
}
