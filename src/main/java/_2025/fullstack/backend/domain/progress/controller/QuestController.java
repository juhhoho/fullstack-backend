package _2025.fullstack.backend.domain.progress.controller;

import _2025.fullstack.backend.common.apiPayload.success.SuccessApiResponse;
import _2025.fullstack.backend.domain.progress.dto.request.QuestSubmitRequest;
import _2025.fullstack.backend.domain.progress.dto.response.QuestSubmitResponse;
import _2025.fullstack.backend.domain.progress.service.ProgressApplicationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuestController {

    private final ProgressApplicationService progressApplicationService;

    // 퀘스트 제출
    @PostMapping("/landmarks/{landmarkName}/quest")
    public SuccessApiResponse<QuestSubmitResponse> questSubmit(
            @PathVariable(name = "landmarkName") String landmarkName,
            @RequestBody QuestSubmitRequest request,
            HttpServletRequest httpServletRequest)
    {
        log.info("[QuestController - questSubmit]");

        return SuccessApiResponse.QuestSubmit(progressApplicationService.questSubmit(landmarkName, request.getStdUrl(), request.getClientUrl(), httpServletRequest));
    }

}
