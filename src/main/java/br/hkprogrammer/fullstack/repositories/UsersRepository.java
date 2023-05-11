package br.hkprogrammer.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.hkprogrammer.fullstack.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
