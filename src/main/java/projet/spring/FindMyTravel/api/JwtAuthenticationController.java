package projet.spring.FindMyTravel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projet.spring.FindMyTravel.config.JwtTokenUtil;
import projet.spring.FindMyTravel.entities.*;

import projet.spring.FindMyTravel.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class JwtAuthenticationController {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception 
	{
		final User userDetails = userservice.loadByUsername(user.getUsername(), user.getPassword());

		if(userDetails == null) {
			
			return ResponseEntity.ok("error password");
		}
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JWTResponse(token));
	}
	}
	
	
	
	


