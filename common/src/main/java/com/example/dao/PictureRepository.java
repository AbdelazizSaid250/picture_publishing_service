package com.example.dao;

import com.example.model.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "pictures")
public interface PictureRepository extends JpaRepository<Picture, UUID> {

    @Query(value = "SELECT * FROM picture_publishing.picture where state = 'accepted';", nativeQuery = true)
    List<Picture> listAllAcceptedPictures();

    @Query(value = "SELECT * FROM picture_publishing.picture where state = 'unprocessed';", nativeQuery = true)
    List<Picture> listUnprocessedPictures();

    @Modifying
    @Query(value = "UPDATE picture_publishing.picture SET state = 'rejected' where id = :pictureId;", nativeQuery = true)
    void removePictureByAdmin(@Param("pictureId") UUID pictureId);

    @Modifying
    @Query(value = "UPDATE picture_publishing.picture SET state = 'accepted' where id = :pictureId;", nativeQuery = true)
    void acceptPictureByAdmin(@Param("pictureId") UUID pictureId);
}
