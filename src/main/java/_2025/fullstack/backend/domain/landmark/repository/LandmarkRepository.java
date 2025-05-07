package _2025.fullstack.backend.domain.landmark.repository;

import _2025.fullstack.backend.domain.landmark.entity.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark, Long> {
    Optional<Landmark> findByName(String landmarkName);
}
