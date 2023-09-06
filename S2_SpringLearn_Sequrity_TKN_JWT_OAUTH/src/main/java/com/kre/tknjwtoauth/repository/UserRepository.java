package com.kre.tknjwtoauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kre.tknjwtoauth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	//user define JPA
	User findByEmail(String email);
}
