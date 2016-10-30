package moviesuggestion.suggest.service;


import moviesuggestion.suggest.model.movie.Genre;
import moviesuggestion.suggest.model.movie.MPAA;
import moviesuggestion.suggest.model.movie.Movie;
import moviesuggestion.suggest.model.search.SearchRequest;
import moviesuggestion.suggest.repository.MovieRepository;
import moviesuggestion.suggest.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sburroughs on 9/23/2016.
 */
@Service
public class SearchService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SearchRepository searchRepository;


    public List<Movie> search(SearchRequest searchRequest) {

        List<String> likes = searchRequest.getLikes();
        List<Movie> results = searchRepository.findByTitleIn(likes);

        return results;

    }

}
