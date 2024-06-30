package com.example.studioJudo.service.impl;

import com.example.studioJudo.models.Qualification;
import com.example.studioJudo.repositories.QualificationRepository;
import com.example.studioJudo.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;

    @Override
    public List<Qualification> findAllQualification() {
        return qualificationRepository.findAll();
    }

    @Override
    public Optional<Qualification> findById(Integer id) {
        return qualificationRepository.findById(id);
    }
}
