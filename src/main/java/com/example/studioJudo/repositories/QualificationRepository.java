package com.example.studioJudo.repositories;

import com.example.studioJudo.models.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Integer> {
}
