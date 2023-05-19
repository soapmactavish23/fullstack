package br.hkprogrammer.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.hkprogrammer.fullstack.entities.Users;
import br.hkprogrammer.fullstack.repositories.UsersRepository;

@Service
public class UsersServices {

	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping
	public List<Users> findAll() {
		return repository.findAll();
	}

	public ResponseEntity<Users> findById(@PathVariable long id) {
		return repository.findById(id).map(response -> ResponseEntity.ok().body(response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Users create(@RequestBody Users users) {
		String newPass = encoder.encode(users.getPassword());
		users.setPassword(newPass);
		return repository.save(users);
	}
	
	@PutMapping("/{id}")
	public Users update(@RequestBody Users users, @PathVariable long id) {
		users.setId(id);
		return repository.save(users);
	}
	
	
	public ResponseEntity<?> delete(@PathVariable long id) {
		repository.deleteById(id);
		return null;
	}

}
