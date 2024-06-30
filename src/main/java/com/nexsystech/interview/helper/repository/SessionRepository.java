package com.nexsystech.interview.helper.repository;

import com.nexsystech.interview.helper.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session,String> {
    Optional<Session> findByJwtToken(String jwtToken);
    Optional<Session> findByUserId(String userId);

    void deleteByJwtToken(String jwtToken);
}
