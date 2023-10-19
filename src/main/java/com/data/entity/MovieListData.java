package com.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "movielist")
@NoArgsConstructor
@AllArgsConstructor
public class MovieListData
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;
    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_type")
    private String movieType;

    @Column(name = "movie_language")
    private String movieLanguage;

    @Column(name = "movie_duration")
    private String movieDuration;

    @Column(name = "movie_release")
    private String relaseDate;

    @Column(name = "movie_clip")
    private Byte movieClip;

    @Column(name = "movie_uri")
    private String movieUri;
}
