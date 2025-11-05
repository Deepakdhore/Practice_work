package com.socialmedia.media_service.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MediaDto {
    private Long userId;
    private Long postId;

    private String mediaType;
    private String fileName;
    private String fileUrl;
    private String contentType;
    private LocalDateTime uploadedAt;
    private String category;
}
