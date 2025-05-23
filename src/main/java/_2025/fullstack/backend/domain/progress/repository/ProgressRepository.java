package _2025.fullstack.backend.domain.progress.repository;

import _2025.fullstack.backend.domain.landmark.entity.Landmark;
import _2025.fullstack.backend.domain.progress.entity.Progress;
import _2025.fullstack.backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findAllByUserOrderByLandmarkId(User user);
    long countByUserAndClearedTrue(User user);

    boolean existsByUserAndLandmark(User user, Landmark landmark);

    Progress findByUserAndLandmark(User user, Landmark landmark);
}
