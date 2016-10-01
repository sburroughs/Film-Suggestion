package moviesuggestion.suggest.web;

import moviesuggestion.suggest.model.movie.Movie;
import moviesuggestion.suggest.model.search.SearchRequest;
import moviesuggestion.suggest.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sburroughs on 9/23/2016.
 */
@Controller
public class SearchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SearchService searchService;


    //TODO: try removing CrossOrigin and // FIXME: 9/28/2016
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> search(@RequestParam List<String> likes) {


        SearchRequest searchRequest = new SearchRequest(likes);

        LOGGER.info("New search request received: {}", searchRequest);

        List<Movie> results = searchService.search(searchRequest);
        return results;

    }
}
