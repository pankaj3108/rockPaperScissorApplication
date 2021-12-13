package com.vocera.rock_paper_scissor.repository;

import com.vocera.rock_paper_scissor.models.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationTokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    Optional<AuthenticationToken> findByToken(String token);
}
