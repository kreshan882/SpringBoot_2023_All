package com.kre.tknjwtoauth.repository;

import com.kre.tknjwtoauth.entity.Userk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Userk,Long> {
    Userk findByEmail(String email);
}
