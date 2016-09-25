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
        String queryString = buildQueryString(likes);

        SolrQuery query = new SolrQuery();
        query.setQuery(queryString);

        List<Movie> results = movieRepository.findByTitle(queryString);

        return results;

    }

    private String buildQueryString(List<String> likes) {

//        StringBuilder builder = new StringBuilder();
//        for(Tag tag : tags){
//            builder.append(tag.getSearchKeyword())
//        }

        return likes.get(0);


    }


}
