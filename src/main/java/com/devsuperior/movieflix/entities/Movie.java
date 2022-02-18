package com.devsuperior.movieflix.entities;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Review;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;


    @OneToMany(mappedBy = "movie")
    private List<Review> reviews = new ArrayList<>();

    public Movie(){
    }

    public Movie(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis, Genre genre) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.year = year;
        this.imgUrl = imgUrl;
        this.synopsis = synopsis;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(subTitle, movie.subTitle) && Objects.equals(year, movie.year) && Objects.equals(imgUrl, movie.imgUrl) && Objects.equals(synopsis, movie.synopsis) && Objects.equals(genre, movie.genre) && Objects.equals(reviews, movie.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, subTitle, year, imgUrl, synopsis, genre, reviews);
    }
}
