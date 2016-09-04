package moviesuggestion.suggest.controller;

import moviesuggestion.suggest.model.Movie;
import moviesuggestion.common.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/")
    public Movie search(String keyword) {


        Movie movie = new Movie();

        return movie;
    }

}
