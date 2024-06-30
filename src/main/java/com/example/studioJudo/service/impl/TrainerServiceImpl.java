package com.example.studioJudo.service.impl;

import com.example.studioJudo.models.Trainer;
import com.example.studioJudo.repositories.TrainerRepository;
import com.example.studioJudo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<Trainer> findAllTrainer() {
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> findById(Integer id) {
        return trainerRepository.findById(id);
    }

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public Trainer updateTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public void deleteTrainer(Integer id) {
        trainerRepository.deleteById(id);
    }
}
