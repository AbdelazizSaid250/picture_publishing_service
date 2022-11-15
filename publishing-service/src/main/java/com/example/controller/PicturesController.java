package com.example.controller;

import com.example.model.dto.PicturesDto;
import com.example.model.entity.Picture;
import com.example.service.picture.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("image")
public class PicturesController {

    private final PictureService pictureService;

    @Autowired
    public PicturesController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping("upload_picture")
    void uploadPictureByUserAPI(PicturesDto.UploadPicture uploadPicture) {
        pictureService.uploadPictureByUser(uploadPicture);
    }

    @GetMapping("accepted_pictures")
    List<Picture> listAllAcceptedPicturesAPI() {
        return pictureService.listAllAcceptedPictures();
    }

    @GetMapping("unprocessed_pictures")
    List<Picture> listUnprocessedPicturesAPI() {
        return pictureService.listUnprocessedPictures();
    }

    @PatchMapping("remove_picture")
    void removePictureByAdminAPI(@RequestParam UUID pictureID) {
        pictureService.removePictureByAdmin(pictureID);
    }

    @PatchMapping("accept_picture/{pictureID}")
    void acceptPictureByAdmin(@PathVariable UUID pictureID) {
        pictureService.removePictureByAdmin(pictureID);
    }

}
