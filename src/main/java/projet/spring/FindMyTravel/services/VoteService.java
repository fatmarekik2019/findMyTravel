package projet.spring.FindMyTravel.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import projet.spring.FindMyTravel.entities.Vote;

public interface VoteService {


	ResponseEntity<?> votePublication(Vote vote, Integer ClientId, Integer PublicationId);

	List<Vote> getVoteList(Integer clientId);


}
