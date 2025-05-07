package _2025.fullstack.backend.domain.progress.dto.response;

import _2025.fullstack.backend.domain.landmark.dto.brief.LandmarkBriefDto;
import _2025.fullstack.backend.domain.progress.dto.brief.ProgressBriefDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetProgressInfoResponse {
    List<ProgressBriefDto> progressList;
    List<LandmarkBriefDto> landmarkList;
}
