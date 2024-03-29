package model;

import network.ShowInfoGetter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public abstract class Content {

    protected String title;
    protected String release;
    protected boolean watched;
    protected int rating = -1;

    public int getRating() {
        return rating;
    }

    protected List<Genre> genreList = new ArrayList<>();

    public boolean isWatched() {
        return watched;
    }

    //EFFECTS: returns the title of the content
    public String getTitle() {
        return this.title;
    }

    //MODIFIES: this
    //EFFECTS: sets title of content
    public void setTitle(String title) {
        this.title = title;
    }


    public void toggleWatched() {
        watched = !watched;
    }

    //MODIFIES: this
    //EFFECTS: rates the show if given rating is in appropriate range, prints "invalid rating" otherwise
    public void rate(int rating) {
        if (rating <= 10 && rating >= 0) {
            this.rating = rating;
        } else {
            System.out.println("Invalid Rating");
        }

    }

    //MODIFIES: this, genre
    //EFFECTS: adds genre to content and content to genre
    public void addGenre(Genre genre) {
        if (!genreList.contains(genre)) {
            genreList.add(genre);
            genre.addContent(this);
        }
    }


    //MODIFIES: this, genre
    //EFFECTS: removes genre from content and content from genre
    public void removeGenre(Genre genre) {
        if (genreList.contains(genre)) {
            genreList.remove(genre);
            genre.removeContent(this);
        }
    }

    public List<Genre> getGenres() {
        return genreList;
    }


}
