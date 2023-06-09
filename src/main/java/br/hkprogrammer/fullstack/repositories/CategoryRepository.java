package br.hkprogrammer.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.hkprogrammer.fullstack.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
