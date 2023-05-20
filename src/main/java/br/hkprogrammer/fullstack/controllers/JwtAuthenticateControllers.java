package br.hkprogrammer.fullstack.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.hkprogrammer.fullstack.entities.Users;
import br.hkprogrammer.fullstack.repositories.UsersRepository;
import br.hkprogrammer.fullstack.security.JwtUserDetailsService;

@CrossOrigin
@RestController
public class JwtAuthenticateControllers {

	private List<Users> usuarios = new ArrayList<>();

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@CrossOrigin
	@PostMapping("/login")
	public String createAuthenticateToken(@RequestBody Users authenticateRequest) {

		usuarios = repository.findAll();
		String username = authenticateRequest.getUsername();
		String password = authenticateRequest.getPassword();
		for (Users usuario : usuarios) {

			if (usuario.getUsername().equals(username) && encoder.matches(password, usuario.getPassword())) {
				
				final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
				
				System.out.println(userDetails);
				
				return usuario.getUsername();
			}
		}

		return "Error";
	}

}
