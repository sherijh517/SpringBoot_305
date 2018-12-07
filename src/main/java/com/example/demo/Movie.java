package com.example.demo;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private long years;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "MOVIE_ID",
                    referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "Actor_ID",
                    referencedColumnName = "ID"))
    private Set<Actor> cast;

    public void addActor(Actor actor)
    {
        cast.add(actor);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getYears() {
        return years;
    }

    public void setYears(long years) {
        this.years = years;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Actor> getCast() {
        return cast;
    }

    public void setCast(Set<Actor> cast) {
        this.cast = cast;
    }
}
