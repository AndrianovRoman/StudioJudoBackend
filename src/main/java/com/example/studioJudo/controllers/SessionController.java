package com.example.studioJudo.controllers;

import com.example.studioJudo.models.Session;
import com.example.studioJudo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/sessions")
    public List<Session> findAllSession() {
        return sessionService.findAllSession();
    }

    @PostMapping("/sessions")
    public Session saveSession(@RequestBody Session session) {
        return sessionService.saveSession(session);
    }

    @GetMapping("/sessions/{id}")
    public Optional<Session> findSessionById(@PathVariable("id") Integer id) {
        return sessionService.findById(id);
    }

    @PutMapping("/sessions/{id}")
    public Session updateSession(@PathVariable("id") Integer id, @RequestBody Session session) {
        return sessionService.updateSession(session);
    }

    @DeleteMapping("/sessions/{id}")
    public void deleteSession(@PathVariable("id") Integer id) {
        sessionService.deleteSession(id);
    }

}
