package moviesuggestion.databank.io.pipeline;

import moviesuggestion.databank.io.pipeline.converter.MovieConverter;
import moviesuggestion.databank.io.pipeline.providers.UpdateImportProvider;
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
public class MovieUpdatePipeline<T extends MovieContent> {

    private final static Logger log = LoggerFactory.getLogger(MovieUpdatePipeline.class);

    private UpdateImportProvider<T> provider;
    private MovieConverter<T> converter;
    private MovieRepository movieRepository;
    private MovieMatcher movieMatcher;

    @Autowired
    public MovieUpdatePipeline(MovieRepository movieRepository,
                               UpdateImportProvider provider,
                               MovieConverter converter,
                               MovieMatcher movieMatcher) {
        this.provider = provider;
        this.movieRepository = movieRepository;
        this.converter = converter;
        this.movieMatcher = movieMatcher;
    }

    public void run() {

        List<Movie> updateList = movieRepository.findAll();

        List<T> movies = provider.update(updateList);

        for (T source : movies) {

            Movie original = movieMatcher.match(source);
            Movie movie = converter.convert(source, original);
            movieRepository.save(movie);

        }

    }


}
















