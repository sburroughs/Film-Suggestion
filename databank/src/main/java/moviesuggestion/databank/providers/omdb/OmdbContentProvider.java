package moviesuggestion.databank.providers.omdb;

import moviesuggestion.common.model.movie.Movie;
import moviesuggestion.databank.providers.MovieContentProvider;
import moviesuggestion.databank.providers.omdb.OmdbMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sburroughs on 9/3/2016.
 */
public class OmdbContentProvider implements MovieContentProvider {

    private String URI = "http://www.omdbapi.com/?t=frozen&y=&plot=full&r=json";

    private RestTemplate restTemplate;
    private OmdbToMovieConverter converter;

    public OmdbContentProvider() {
        this.restTemplate = new RestTemplate();
        this.converter = new OmdbToMovieConverter();
    }

    public List<Movie> getAll() {

        OmdbMovie source = restTemplate.getForObject(URI, OmdbMovie.class);
        Movie movie = converter.convert(source);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        return movies;

    }

    public Movie updateOne(Movie outdated) {
        return null;
    }
}
