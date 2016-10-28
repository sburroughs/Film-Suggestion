package moviesuggestion.databank.web;

import moviesuggestion.databank.io.pipeline.MovieCreationManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sburroughs on 10/23/2016.
 */
@Controller
@RequestMapping("/movie")
public class MovieCreationController {

    @Autowired
    MovieCreationManager manager;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody String title, @RequestParam(defaultValue = "OMDB") String source) {
        manager.create(title, source);
    }

}
