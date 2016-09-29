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
public class OmdbContentProvider implements UpdateImportProvider<OmdbMovie> {

    private final String BASE_URL = "http://www.omdbapi.com/";

    private final RestTemplate restTemplate;

    @Autowired
    public OmdbContentProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public OmdbMovie update(Movie original) {

        String title = original.getTitle();
        String year = new SimpleDateFormat("yyyy").format(original.getReleaseDate());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("t", title)
                .queryParam("y", year)
                .queryParam("plot", "full")
                .queryParam("r", "json");

        OmdbMovie source = restTemplate.getForObject(builder.build().encode().toUri(), OmdbMovie.class);

        return source;

    }

}
