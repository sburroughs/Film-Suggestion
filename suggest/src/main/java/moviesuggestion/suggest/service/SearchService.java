package moviesuggestion.suggest.service;


import moviesuggestion.suggest.model.Movie;
import moviesuggestion.suggest.model.Tag;
import moviesuggestion.suggest.repository.MovieRepository;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sburroughs on 9/23/2016.
 */
@Service
public class SearchService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> search(SearchRequest searchRequest){

        List<String> likes = searchRequest.getLikes();

        List<Movie> results = movieRepository.findByTitleIn(likes);

        return results;

    }

}
