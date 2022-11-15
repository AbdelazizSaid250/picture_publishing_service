package com.example.service.picture;

import com.example.dao.PictureRepository;
import com.example.model.dto.PicturesDto;
import com.example.model.entity.Picture;
import com.example.util.Utils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log
@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public void uploadPictureByUser(PicturesDto.UploadPicture uploadPicture) {

        Picture savedPicture = new Picture(UUID.randomUUID());
        savedPicture.setDescription(uploadPicture.getDescription());
        savedPicture.setCategory(uploadPicture.getCategory());
        savedPicture.setUrl(uploadPicture.getUrl());
        savedPicture.setState(Utils.PictureState.UNPROCESSED.toString());

        pictureRepository.save(savedPicture);

        // I may add the user_id in the picture table but, I didn't implement it because there is no API
        // which require to find fetch the pictures uploaded by the users.
        log.info("Successfully Uploaded the picture by the the Account owner");
    }

    @Override
    public List<Picture> listAllAcceptedPictures() {
        List<Picture> acceptedPictures = pictureRepository.listAllAcceptedPictures();
        log.info("Successfully Fetched the Accepted Pictures by the Admin");
        return acceptedPictures;
    }

    @Override
    public List<Picture> listUnprocessedPictures() {
        List<Picture> unprocessedPictures = pictureRepository.listUnprocessedPictures();
        log.info("Successfully Fetched all Pictures for normal users");
        return unprocessedPictures;
    }

    @Override
    public void removePictureByAdmin(UUID pictureId) {
        pictureRepository.removePictureByAdmin(pictureId);

        log.info("Successfully removed the User by picture by the Admin");
    }

    @Override
    public void acceptPictureByAdmin(UUID pictureId) {
        pictureRepository.acceptPictureByAdmin(pictureId);

        log.info("The picture has been successfully accepted by the admin");
    }
}
