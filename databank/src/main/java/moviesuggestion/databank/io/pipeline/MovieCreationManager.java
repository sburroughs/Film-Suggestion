package moviesuggestion.databank.io.pipeline;

import moviesuggestion.databank.io.pipeline.providers.MovieUpdateProvider;
import moviesuggestion.databank.model.MovieContent;
import moviesuggestion.databank.model.movie.Movie;
import moviesuggestion.databank.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Sburroughs on 9/5/2016.
 */
@Component
public class MovieCreationManager {

    private final static Logger log = LoggerFactory.getLogger(MovieCreationManager.class);

    private MovieMatcher movieMatcher;
    private MovieRepository movieRepository;
    private MovieUpdateProviderFactory providerFactory;

    @Autowired
    public MovieCreationManager(MovieRepository movieRepository,
                                MovieMatcher movieMatcher,
                                MovieUpdateProviderFactory providerFactory) {
        this.movieRepository = movieRepository;
        this.movieMatcher = movieMatcher;
        this.providerFactory = providerFactory;
    }

    public void create(String title, String source) {

        Movie original = movieMatcher.match(title);

        MovieUpdateProvider provider = providerFactory.getProvider(source);
        provider.update(original);

        movieRepository.save(original);

    }

}
















