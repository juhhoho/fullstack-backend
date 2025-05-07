package _2025.fullstack.backend.domain.progress.dto.response;

import _2025.fullstack.backend.domain.user.dto.RankDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GetRankingsResponse {
    String myNickName;
    int myTotalScore;

    List<RankDto> rankings;

}
