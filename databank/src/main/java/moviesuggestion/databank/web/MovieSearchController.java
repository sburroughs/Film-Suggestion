package moviesuggestion.databank.web;

import moviesuggestion.databank.model.movie.Movie;
import moviesuggestion.databank.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Sburroughs on 10/23/2016.
 */
@Controller
public class MovieSearchController {

    @Autowired
    MovieRepository repository;

    @RequestMapping("/search")
    @ResponseBody
    public List<Movie> update(@RequestParam String title) {
        return repository.findByTitle(title);
    }

}
