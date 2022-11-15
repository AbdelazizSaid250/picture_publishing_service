package com.example.service.picture;

import com.example.model.dto.PicturesDto;
import com.example.model.entity.Picture;

import java.util.List;
import java.util.UUID;

public interface PictureService {

    void uploadPictureByUser(PicturesDto.UploadPicture uploadPicture);

    List<Picture> listAllAcceptedPictures();

    List<Picture> listUnprocessedPictures();

    void removePictureByAdmin(UUID pictureId);

    void acceptPictureByAdmin(UUID pictureId);
}
