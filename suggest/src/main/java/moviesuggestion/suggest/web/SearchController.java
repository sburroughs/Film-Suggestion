package moviesuggestion.suggest.web;

import moviesuggestion.suggest.model.Movie;
import moviesuggestion.suggest.service.SearchRequest;
import moviesuggestion.suggest.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sburroughs on 9/23/2016.
 */
@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @CrossOrigin
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> search(@RequestParam List<String> likes) {

        SearchRequest searchRequest = new SearchRequest(likes);

        List<Movie> results = searchService.search(searchRequest);
        return results;

    }
}
