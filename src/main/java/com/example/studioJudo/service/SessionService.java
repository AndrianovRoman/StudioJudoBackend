package com.example.studioJudo.service;

import com.example.studioJudo.models.Session;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    List<Session> findAllSession();
    Optional<Session> findById(Integer id);
    Session saveSession(Session session);
    Session updateSession(Session session);
    void deleteSession(Integer id);
}
