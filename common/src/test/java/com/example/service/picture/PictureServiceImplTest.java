package com.example.service.picture;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.dao.PictureRepository;
import com.example.model.dto.PicturesDto;
import com.example.model.entity.Picture;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PictureServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PictureServiceImplTest {
    @MockBean
    private PictureRepository pictureRepository;

    @Autowired
    private PictureServiceImpl pictureServiceImpl;

    /**
     * Method under test: {@link PictureServiceImpl#uploadPictureByUser(PicturesDto.UploadPicture)}
     */
    @Test
    void testUploadPictureByUser() {
        Picture picture = new Picture();
        picture.setCategory("Category");
        picture.setDescription("The characteristics of someone or something");
        picture.setId(UUID.randomUUID());
        picture.setState("MD");
        picture.setUrl("https://example.org/example");
        when(pictureRepository.save(any())).thenReturn(picture);

        PicturesDto.UploadPicture uploadPicture = new PicturesDto.UploadPicture();
        uploadPicture.setCategory("Category");
        uploadPicture.setDescription("The characteristics of someone or something");
        uploadPicture.setUrl("https://example.org/example");
        pictureServiceImpl.uploadPictureByUser(uploadPicture);
        verify(pictureRepository).save(any());
    }

    /**
     * Method under test: {@link PictureServiceImpl#uploadPictureByUser(PicturesDto.UploadPicture)}
     */
    @Test
    void testUploadPictureByUser2() {
        Picture picture = new Picture();
        picture.setCategory("Category");
        picture.setDescription("The characteristics of someone or something");
        picture.setId(UUID.randomUUID());
        picture.setState("MD");
        picture.setUrl("https://example.org/example");
        when(pictureRepository.save((Picture) any())).thenReturn(picture);

        PicturesDto.UploadPicture uploadPicture = new PicturesDto.UploadPicture();
        uploadPicture.setCategory("Category");
        uploadPicture.setDescription("The characteristics of someone or something");
        uploadPicture.setUrl("https://example.org/example");
        pictureServiceImpl.uploadPictureByUser(uploadPicture);
        verify(pictureRepository).save((Picture) any());
    }

    /**
     * Method under test: {@link PictureServiceImpl#listAllAcceptedPictures()}
     */
    @Test
    void testListAllAcceptedPictures() {
        ArrayList<Picture> pictureList = new ArrayList<>();
        when(pictureRepository.listAllAcceptedPictures()).thenReturn(pictureList);
        List<Picture> actualListAllAcceptedPicturesResult = pictureServiceImpl.listAllAcceptedPictures();
        assertSame(pictureList, actualListAllAcceptedPicturesResult);
        assertTrue(actualListAllAcceptedPicturesResult.isEmpty());
        verify(pictureRepository).listAllAcceptedPictures();
    }

    /**
     * Method under test: {@link PictureServiceImpl#listUnprocessedPictures()}
     */
    @Test
    void testListUnprocessedPictures() {
        ArrayList<Picture> pictureList = new ArrayList<>();
        when(pictureRepository.listUnprocessedPictures()).thenReturn(pictureList);
        List<Picture> actualListUnprocessedPicturesResult = pictureServiceImpl.listUnprocessedPictures();
        assertSame(pictureList, actualListUnprocessedPicturesResult);
        assertTrue(actualListUnprocessedPicturesResult.isEmpty());
        verify(pictureRepository).listUnprocessedPictures();
    }

    /**
     * Method under test: {@link PictureServiceImpl#removePictureByAdmin(UUID)}
     */
    @Test
    void testRemovePictureByAdmin() {
        doNothing().when(pictureRepository).removePictureByAdmin((UUID) any());
        pictureServiceImpl.removePictureByAdmin(UUID.randomUUID());
        verify(pictureRepository).removePictureByAdmin((UUID) any());
    }

    /**
     * Method under test: {@link PictureServiceImpl#acceptPictureByAdmin(UUID)}
     */
    @Test
    void testAcceptPictureByAdmin() {
        doNothing().when(pictureRepository).acceptPictureByAdmin((UUID) any());
        pictureServiceImpl.acceptPictureByAdmin(UUID.randomUUID());
        verify(pictureRepository).acceptPictureByAdmin((UUID) any());
    }
}

