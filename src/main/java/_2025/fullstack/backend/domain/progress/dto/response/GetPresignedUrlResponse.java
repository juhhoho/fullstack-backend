package _2025.fullstack.backend.domain.progress.dto.response;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetPresignedUrlResponse {
    public String presignedUrl;
}
