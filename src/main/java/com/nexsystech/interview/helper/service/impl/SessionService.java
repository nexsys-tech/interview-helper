package com.nexsystech.interview.helper.service.impl;

import com.nexsystech.interview.helper.entity.Session;
import com.nexsystech.interview.helper.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public Session createSession(String userId, String jwtToken) {
        Session session = new Session();
        session.setUserId(userId);
        session.setJwtToken(jwtToken);
        session.setCreatedAt(LocalDateTime.now());
        session.setLastAccessedAt(LocalDateTime.now());
        return sessionRepository.save(session);
    }

    public Optional<Session> getSessionByToken(String jwtToken) {
        return sessionRepository.findByJwtToken(jwtToken);
    }

    public Optional<Session> getSessionByUserId(String userId) {
        return sessionRepository.findByUserId(userId);
    }

    public void updateLastAccessedTime(String jwtToken) {
        Optional<Session> sessionOptional = sessionRepository.findByJwtToken(jwtToken);
        sessionOptional.ifPresent(session -> {
            session.setLastAccessedAt(LocalDateTime.now());
            sessionRepository.save(session);
        });
    }

    public void terminateSession(String jwtToken) {
        sessionRepository.deleteByJwtToken(jwtToken);
    }
}
