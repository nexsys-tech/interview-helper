package com.nexsystech.interview.helper.repository;

import com.nexsystech.interview.helper.entity.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends MongoRepository<Session,String> {
    Optional<Session> findByJwtToken(String jwtToken);
    Optional<Session> findByUserId(String userId);

    void deleteByJwtToken(String jwtToken);
}
