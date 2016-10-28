package moviesuggestion.databank.io.pipeline.providers.omdb;

import moviesuggestion.databank.io.pipeline.providers.MovieUpdateProvider;
import moviesuggestion.databank.model.movie.Movie;
import moviesuggestion.databank.model.omdb.OmdbMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;


/**
 * Created by Sburroughs on 9/3/2016.
 */
public class OmdbContentProvider implements MovieUpdateProvider<OmdbMovie> {

    private final String BASE_URL = "http://www.omdbapi.com/";

    private final RestTemplate restTemplate;
    private final OmdbMovieCreator omdbMovieCreator;

    @Autowired
    public OmdbContentProvider(RestTemplate restTemplate, OmdbMovieCreator omdbMovieCreator) {
        this.restTemplate = restTemplate;
        this.omdbMovieCreator = omdbMovieCreator;
    }

    @Override
    public void update(Movie original) {

        String title = original.getTitle();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("t", title)
                .queryParam("plot", "full")
                .queryParam("r", "json");

        OmdbMovie source = restTemplate.getForObject(builder.build().encode().toUri(), OmdbMovie.class);

        omdbMovieCreator.create(source);



    }

}
