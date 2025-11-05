package com.socialmedia.media_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long postId;

    private String mediaType;
    private String fileName;
    private String fileUrl;
    private String contentType;
    private LocalDateTime uploadedAt;
    private String category;

}
