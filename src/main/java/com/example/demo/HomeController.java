package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String loadData(){
        // First let's create an actor
        Actor a = new Actor();
        a.setName("Sandra Bullock");
        a.setRealname("Sandra Mae Bullock");
        actorRepository.save(a);

        // Now let's create a movie
        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYears(2017);
        movie.setDescription("About Emojis...");

        movie.addActor(a);


        movie = new Movie();
        movie.setTitle("Valerian and the City of a Thousand Planets");
        movie.setYears(2017);
        movie.setDescription("About Space...");

        movie.addActor(a);


        movie = new Movie();
        movie.setTitle("Wonder Woman");
        movie.setYears(2017);
        movie.setDescription("About a Super Hero...");

        movie.addActor(a);


        return "redirect to view";



    }
}
