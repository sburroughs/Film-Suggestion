package moviesuggestion.databank.providers.runtime;

import moviesuggestion.common.model.movie.Movie;
import moviesuggestion.databank.providers.omdb.OmdbContentProvider;
import moviesuggestion.common.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Sburroughs on 9/3/2016.
 */
public class Demo {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private OmdbContentProvider provider;

    @Bean
    public CommandLineRunner samplePopulateRepository() {
        return (args) -> {
            List<Movie> movies = provider.getAll();
            movieRepository.save(movies);
        };
    }


}
