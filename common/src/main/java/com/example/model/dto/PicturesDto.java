package com.example.model.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class PicturesDto implements Serializable {

    private PicturesDto() {
    }

    /**
     * A DTO for the {@link com.example.model.entity.Picture} entity
     */
    @Data
    public static class UploadPicture implements Serializable {
        private String description;
        private String category;
        private String url;
    }

    /**
     * A DTO for the {@link com.example.model.entity.Picture} entity
     */
    @Data
    public static class PictureDto implements Serializable {
        private String id;
        private String description;
        private String category;
        private String url;
        private String state;
    }
}
