package _2025.fullstack.backend.common.apiPayload.success;


import _2025.fullstack.backend.common.apiPayload.BaseApiResponse;
import _2025.fullstack.backend.domain.progress.dto.response.GetPresignedUrlResponse;
import _2025.fullstack.backend.domain.progress.dto.response.GetProgressInfoResponse;
import _2025.fullstack.backend.domain.progress.dto.response.GetRankingsResponse;
import _2025.fullstack.backend.domain.progress.dto.response.QuestSubmitResponse;
import _2025.fullstack.backend.domain.user.dto.response.LoginResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SuccessApiResponse <T> extends BaseApiResponse {
    private final T response;

    public SuccessApiResponse(Boolean isSuccess, String code, String message, T response) {
        super(isSuccess, code, message);
        this.response = response;
    }

    // [AUTH]
    public static SuccessApiResponse<Void> Register(){
        return new SuccessApiResponse<>(true, HttpStatus.CREATED.toString()
                , "회원가입 성공", null);
    }
    public static SuccessApiResponse<LoginResponse> Login(LoginResponse response){
        return new SuccessApiResponse<>(true, HttpStatus.OK.toString()
                , "로그인 성공", response);
    }
    public static SuccessApiResponse<Void> ReissueToken(){
        return new SuccessApiResponse<>(true, HttpStatus.OK.toString()
                , "토큰 재발급 성공", null);
    }

    // [QUEST]
    public static SuccessApiResponse<QuestSubmitResponse> QuestSubmit(QuestSubmitResponse response){
        return new SuccessApiResponse<>(true, HttpStatus.OK.toString()
                , "퀘스트 제출 성공", response);
    }

    // [PROGRESS]
    public static SuccessApiResponse<GetProgressInfoResponse> GetProgressInfo(GetProgressInfoResponse response){
        return new SuccessApiResponse<>(true, HttpStatus.OK.toString()
                , "진행상황 조회 성공", response);
    }

    // [RANK]
    public static SuccessApiResponse<GetRankingsResponse> GetRankings(GetRankingsResponse response){
        return new SuccessApiResponse<>(true, HttpStatus.OK.toString()
                , "랭킹 조회 성공", response);
    }

    // [IMAGE]
    public static SuccessApiResponse<GetPresignedUrlResponse> GetPresignedUrl(GetPresignedUrlResponse response){
        return new SuccessApiResponse<>(true, HttpStatus.OK.toString()
                , "업로드용 url 발급 성공", response);
    }

}
