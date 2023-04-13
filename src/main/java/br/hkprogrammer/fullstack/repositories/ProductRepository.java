package br.hkprogrammer.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.hkprogrammer.fullstack.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
