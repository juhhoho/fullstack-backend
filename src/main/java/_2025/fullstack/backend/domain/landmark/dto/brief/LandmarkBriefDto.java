package _2025.fullstack.backend.domain.landmark.dto.brief;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LandmarkBriefDto {
    private String landmarkName;
    private boolean nearby;
}
