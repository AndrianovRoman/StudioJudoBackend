package com.example.studioJudo.controllers;

import com.example.studioJudo.models.Qualification;
import com.example.studioJudo.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;

    @GetMapping("/qualifications")
    public List<Qualification> findAllQualification() {
        return qualificationService.findAllQualification();
    }

    @GetMapping("/qualifications/{id}")
    public Optional<Qualification> findQualificationById(@PathVariable("id") Integer id) {
        return qualificationService.findById(id);
    }

}
