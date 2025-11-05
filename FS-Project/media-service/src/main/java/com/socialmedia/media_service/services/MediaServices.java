package com.socialmedia.media_service.services;

import com.socialmedia.media_service.dto.MediaDto;
import com.socialmedia.media_service.entities.Media;
import com.socialmedia.media_service.repositorys.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MediaServices {

    private final Path uploadPath;

    public MediaServices(@Value("${media.upload-dir}") String uploadDir) {
        this.uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.uploadPath);
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory: " + this.uploadPath, e);
        }
    }
    @Autowired
    private MediaRepository mediaRepository;

    public Media uploadMedia(MultipartFile file,Long userId,Long postId,String mediaType,String category) throws IOException {
    Files.createDirectories(uploadPath);
        try {
            String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
            Path destination = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

            Media media = new Media();
                    media.setUserId(userId);
                    media.setPostId(postId);
                    media.setFileName(fileName);
                    media.setFileUrl("/media/file/" + fileName);
                    media.setMediaType(mediaType.toUpperCase());
                    media.setContentType(file.getContentType());
                    media.setCategory(category);
                    media.setUploadedAt(LocalDateTime.now());

            return mediaRepository.save(media);

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    public Resource loadMediaByFilename(String filename) {
        try {
            Path file = uploadPath.resolve(filename).normalize();
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()) {
                return resource;
            }
            throw new FileNotFoundException("File not found: " + filename);
        } catch (MalformedURLException | FileNotFoundException e) {
            throw new RuntimeException("Error reading file: " + filename, e);
        }
    }

    public List<Media> getMediaByCategory(String catagory) {
        List<Media> mediaList=mediaRepository.findAllByCategoryOrderByUploadedAtDesc(catagory);
        return mediaList;
    }

    public Media uploadProfileMedia(MultipartFile file, Long userId, String mediaType) throws IOException{
        Files.createDirectories(uploadPath);
        try {
            String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
            Path destination = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

            Media media = new Media();
            media.setUserId(userId);
            media.setFileName(fileName);
            media.setFileUrl("/media/file/" + fileName);
            media.setMediaType(mediaType.toUpperCase());
            media.setContentType(file.getContentType());
            media.setUploadedAt(LocalDateTime.now());

            return mediaRepository.save(media);

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }
}
