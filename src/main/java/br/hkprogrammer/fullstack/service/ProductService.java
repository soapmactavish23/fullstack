package br.hkprogrammer.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hkprogrammer.fullstack.entities.Product;
import br.hkprogrammer.fullstack.exceptions.ResourceNotFoundException;
import br.hkprogrammer.fullstack.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Product obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return obj;
	}
	
	public Product save(Product obj) {
		return repository.save(obj);
	}
	
	public Product update(Product obj, Long id) {
		obj.setId(id);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
