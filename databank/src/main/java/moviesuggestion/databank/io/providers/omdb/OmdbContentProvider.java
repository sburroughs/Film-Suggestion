package moviesuggestion.databank.io.providers.omdb;

import moviesuggestion.databank.model.MovieContent;
import moviesuggestion.databank.model.omdb.OmdbMovie;
import moviesuggestion.databank.io.providers.MovieContentProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sburroughs on 9/3/2016.
 */
@Service
public class OmdbContentProvider implements MovieContentProvider {

    private String URL = "http://www.omdbapi.com/?t=frozen&y=&plot=full&r=json";

    @Autowired
    private RestTemplate restTemplate;

    public List<MovieContent> getAll() {

        OmdbMovie source = restTemplate.getForObject(URL, OmdbMovie.class);
        List<MovieContent> movies = new ArrayList<>();
        movies.add(source);

        return movies;

    }

}
