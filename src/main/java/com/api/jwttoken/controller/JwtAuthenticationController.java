package com.api.jwttoken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.jwttoken.dto.JWTRequest;
import com.api.jwttoken.service.JwtUserDetailsService;
import com.api.jwttoken.util.JwtTokenUtil;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

//	@Autowired
//	private AuthenticationManager authenticationManager ;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthentcationToken(@RequestBody JWTRequest jwtRequest) throws Exception {
				//authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		System.out.println("Inside authenticate api");
		UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(token);
	}
}
