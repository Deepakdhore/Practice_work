package com.socialmedia.media_service.repositorys;

import com.socialmedia.media_service.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Media,Long> {
    Media findByUserId(Long userId);
    Media findByPostId(Long postId);

    Optional<Media> findFirstByUserIdOrderByUploadedAtDesc(Long userId);
   // List<Media> findMediaByCatagoryOrderByUploadedAtDesc(String catagory);
    List<Media> findAllByCategoryOrderByUploadedAtDesc(String category);

}
