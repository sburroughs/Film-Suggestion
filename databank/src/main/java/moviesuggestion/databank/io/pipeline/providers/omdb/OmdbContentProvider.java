package moviesuggestion.databank.io.pipeline.providers.omdb;

import moviesuggestion.databank.io.pipeline.providers.UpdateImportProvider;
import moviesuggestion.databank.model.movie.Movie;
import moviesuggestion.databank.model.omdb.OmdbMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sburroughs on 9/3/2016.
 */
@Service
public class OmdbContentProvider implements UpdateImportProvider<OmdbMovie> {

    private final String BASE_URL = "http://www.omdbapi.com/";

    private final RestTemplate restTemplate;

    @Autowired
    public OmdbContentProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<OmdbMovie> getAll() {
        throw new UnsupportedOperationException("Not currently implemented");
    }

    @Override
    public List<OmdbMovie> getAll(List<Movie> original) {

        List<OmdbMovie> movies = new ArrayList<>();

        for (Movie movie : original) {

            String title = movie.getTitle();
            String year = new SimpleDateFormat("yyyy").format(movie.getReleaseDate());

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                    .queryParam("t", title)
                    .queryParam("y", year)
                    .queryParam("plot", "full")
                    .queryParam("r", "json");

            OmdbMovie source = restTemplate.getForObject(builder.build().encode().toUri(), OmdbMovie.class);

            movies.add(source);

        }

        return movies;

    }


}
