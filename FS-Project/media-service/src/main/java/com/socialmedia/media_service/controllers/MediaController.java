package com.socialmedia.media_service.controllers;
import com.socialmedia.media_service.entities.Media;
import com.socialmedia.media_service.repositorys.MediaRepository;
import com.socialmedia.media_service.services.MediaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {
    //upload media,
    //fetch media

    @Autowired
    private MediaServices mediaServices;

    @Autowired
    private MediaRepository mediaRepository;
    @PostMapping()
    public ResponseEntity<String> uploadMedia(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userId") Long userId,
            @RequestParam(value = "postId", required = false) Long postId,
            @RequestParam("mediaType") String mediaType,
            @RequestParam("category") String category) throws IOException{
        System.out.println("incoming file----------\n"+"file: "+file+" userId: "+userId+" mediaType: "+mediaType+" category: "+category);
        Media saved = mediaServices.uploadMedia(file, userId, postId, mediaType,category);
        System.out.println("Saved file----------\n"+"file: "+saved.getFileName()+" userId: "+saved.getUserId()+" mediaType: "+saved.getMediaType()+" category: "+saved.getCategory());

        return ResponseEntity.status(HttpStatus.CREATED).body(saved.getFileUrl());
    }
    @PostMapping("/profile")
    public ResponseEntity<Media> uploadProfileMedia(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userId") Long userId,
            @RequestParam(value = "postId", required = false) Long postId,
            @RequestParam("mediaType") String mediaType) throws IOException{
        System.out.println("incoming file----------\n"+"file: "+file+" userId: "+userId+" mediaType: "+mediaType);
        Media saved = mediaServices.uploadProfileMedia(file, userId, mediaType);
        System.out.println("Saved file----------\n"+"file: "+saved.getFileName()+" userId: "+saved.getUserId()+" mediaType: "+saved.getMediaType()+" category: "+saved.getCategory());

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @GetMapping("/file/{fileName:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String fileName) {
        Resource file = mediaServices.loadMediaByFilename(fileName);
        // Try to auto-detect content type:
        String contentType = "application/octet-stream";
        try {
            contentType = Files.probeContentType(Paths.get("media-uploads").resolve(fileName));
        } catch (IOException e) { /* fallback */ }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(file);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Media>> getMediaByCetagory(@PathVariable String category){
        try{
            List<Media> mediaList = mediaServices.getMediaByCategory(category);

            System.out.println("this is List of Media Associated with "+category+"\n"+mediaList);
        return ResponseEntity.ok(mediaList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
