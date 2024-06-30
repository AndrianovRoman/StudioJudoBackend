package com.example.studioJudo.service.impl;

import com.example.studioJudo.models.Session;
import com.example.studioJudo.repositories.SessionRepository;
import com.example.studioJudo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<Session> findAllSession() {
        return sessionRepository.findAll();
    }

    @Override
    public Optional<Session> findById(Integer id) {
        return sessionRepository.findById(id);
    }

    @Override
    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session updateSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public void deleteSession(Integer id) {
        sessionRepository.deleteById(id);
    }
}
