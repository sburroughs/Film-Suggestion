package moviesuggestion.suggest.web;


import moviesuggestion.suggest.model.Movie;
import moviesuggestion.suggest.model.Tag;
import moviesuggestion.suggest.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Sburroughs on 9/23/2016.
 */
@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/search")
    @ResponseBody
    public List<Movie> search(List<Tag> tags) {

        List<Movie> results = searchService.search(tags);
        return results;

    }


}
