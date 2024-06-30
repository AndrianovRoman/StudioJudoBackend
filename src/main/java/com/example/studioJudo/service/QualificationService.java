package com.example.studioJudo.service;

import com.example.studioJudo.models.Qualification;

import java.util.List;
import java.util.Optional;

public interface QualificationService {
    List<Qualification> findAllQualification();
    Optional<Qualification> findById(Integer id);
}
