package com.example.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.model.dto.PicturesDto;
import com.example.service.picture.PictureService;

import java.util.ArrayList;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PicturesController.class})
@ExtendWith(SpringExtension.class)
class PicturesControllerTest {
    @MockBean
    private PictureService pictureService;

    @Autowired
    private PicturesController picturesController;

    /**
     * Method under test: {@link PicturesController#acceptPictureByAdmin(UUID)}
     */
    @Test
    void testAcceptPictureByAdmin() throws Exception {
        doNothing().when(pictureService).removePictureByAdmin(any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/accept_picture/{pictureID}",
                UUID.randomUUID());
        MockMvcBuilders.standaloneSetup(picturesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link PicturesController#listAllAcceptedPicturesAPI()}
     */
    @Test
    void testListAllAcceptedPicturesAPI() throws Exception {
        when(pictureService.listAllAcceptedPictures()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accepted_pictures");
        MockMvcBuilders.standaloneSetup(picturesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PicturesController#listUnprocessedPicturesAPI()}
     */
    @Test
    void testListUnprocessedPicturesAPI() throws Exception {
        when(pictureService.listUnprocessedPictures()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/unprocessed_pictures");
        MockMvcBuilders.standaloneSetup(picturesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PicturesController#removePictureByAdminAPI(UUID)}
     */
    @Test
    void testRemovePictureByAdminAPI() throws Exception {
        doNothing().when(pictureService).removePictureByAdmin(any());
        MockHttpServletRequestBuilder patchResult = MockMvcRequestBuilders.patch("/remove_picture");
        MockHttpServletRequestBuilder requestBuilder = patchResult.param("pictureID", String.valueOf(UUID.randomUUID()));
        MockMvcBuilders.standaloneSetup(picturesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link PicturesController#uploadPictureByUserAPI(PicturesDto.UploadPicture)}
     */
    @Test
    void testUploadPictureByUserAPI() throws Exception {
        doNothing().when(pictureService).uploadPictureByUser(any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/upload_picture");
        MockMvcBuilders.standaloneSetup(picturesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

