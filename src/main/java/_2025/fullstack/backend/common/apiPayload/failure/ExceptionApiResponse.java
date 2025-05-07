package _2025.fullstack.backend.common.apiPayload.failure;

import _2025.fullstack.backend.common.apiPayload.BaseApiResponse;
import lombok.Getter;

@Getter
public class ExceptionApiResponse extends BaseApiResponse {

    public ExceptionApiResponse(Boolean isSuccess, String code, String message) {
        super(isSuccess, code, message);
    }

}