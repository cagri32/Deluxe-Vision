package com.backend.deluxevision.repo;

import com.backend.deluxevision.model.Glasses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GlassesRepo extends JpaRepository<Glasses, Long> {
    void deleteGlassesById(Long id);
    Optional<Glasses> findGlassesById(Long id);
}
