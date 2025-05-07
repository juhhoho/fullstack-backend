package _2025.fullstack.backend.domain.progress.controller;

import _2025.fullstack.backend.common.apiPayload.success.SuccessApiResponse;
import _2025.fullstack.backend.domain.progress.dto.response.GetPresignedUrlResponse;
import _2025.fullstack.backend.domain.progress.service.ProgressApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class ImageController {
    private final ProgressApplicationService progressApplicationService;

    @GetMapping("/presignedUrl/upload")
    public SuccessApiResponse<GetPresignedUrlResponse> getPresignedUrl(
            @RequestParam(name = "imageName") String imageName)
    {
        log.info("[ImageController - getPresignedUrl] imageName = {}", imageName);

        return SuccessApiResponse.GetPresignedUrl(progressApplicationService.getPresignedUrl(imageName));
    }
}
