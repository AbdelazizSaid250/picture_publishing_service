package com.example.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Entity
@ToString
@Table(name = "picture")
public class Picture {
    @Id
    @Getter
    @Setter
    @ToString.Exclude
    @Column(name = "id", nullable = false)
    private UUID id;

    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @Getter
    @Setter
    @Column(name = "category", nullable = false)
    private String category;

    @Getter
    @Setter
    @Column(name = "url", nullable = false)
    private String url;

    @Getter
    @Setter
    @Column(name = "state", nullable = false)
    private String state;

    public Picture() {
    }

    public Picture(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return Objects.equals(state, picture.state)
                && id.equals(picture.id)
                && description.equals(picture.description)
                && category.equals(picture.category)
                && url.equals(picture.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, category, url, state);
    }
}