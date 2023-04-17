package br.hkprogrammer.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hkprogrammer.fullstack.entities.Category;
import br.hkprogrammer.fullstack.exceptions.ResourceNotFoundException;
import br.hkprogrammer.fullstack.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Category obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return obj;
	}
	
	public Category save(Category obj) {
		return repository.save(obj);
	}
	
	public Category update(Category obj, Long id) {
		obj.setId(id);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
