package _2025.fullstack.backend.domain.progress.dto.brief;

import _2025.fullstack.backend.domain.progress.entity.Grade;
import _2025.fullstack.backend.domain.progress.entity.Progress;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProgressBriefDto {
    private String landmarkName;
    private boolean cleared;
    private int score;
    private Grade grade;

    @Builder
    public ProgressBriefDto(Progress progress) {
        this.landmarkName = progress.getLandmark().getName();
        this.cleared = progress.isCleared();
        this.score = progress.getScore();
        this.grade = progress.getGrade();
    }
}
