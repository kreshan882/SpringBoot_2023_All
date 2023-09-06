package com.kre.tknjwtoauth.repository;

import org.springframework.stereotype.Repository;
import com.kre.tknjwtoauth.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    
	VerificationToken findByToken(String token);
}
