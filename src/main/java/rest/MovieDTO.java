/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.Movie;

/**
 *
 * @author phill
 */
public class MovieDTO {
    
    private long id;
    private String title;
    private String genre;
    private String director;
    private int releaseYear;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.genre = movie.getGenre();
        this.director = movie.getDirector();
        this.releaseYear = movie.getReleaseYear();
        

    }

}
