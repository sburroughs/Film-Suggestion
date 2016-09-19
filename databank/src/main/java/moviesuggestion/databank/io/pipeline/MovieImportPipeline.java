package moviesuggestion.databank.io.pipeline;

import moviesuggestion.databank.exception.OhGodWhyException;
import moviesuggestion.databank.io.pipeline.converter.MovieConverter;
import moviesuggestion.databank.io.pipeline.providers.SourceImportProvider;
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
public class MovieImportPipeline<T extends MovieContent> {

    private final static Logger log = LoggerFactory.getLogger(MovieImportPipeline.class);

    private SourceImportProvider<T> contentProvider;
    private MovieConverter<T> converter;
    private MovieRepository movieRepository;
    private MovieMatcher movieMatcher;

    @Autowired
    public MovieImportPipeline(MovieRepository movieRepository,
                               SourceImportProvider contentProvider,
                               MovieConverter converter,
                               MovieMatcher movieMatcher) {
        this.contentProvider = contentProvider;
        this.movieRepository = movieRepository;
        this.converter = converter;
        this.movieMatcher = movieMatcher;
    }

    public void run() throws OhGodWhyException {

    List<T> movies = contentProvider.getAll();

        for (T source : movies) {

            long id = movieMatcher.getId(source);
            Movie movie = converter.convert(id, source);
            movieRepository.save(movie);

        }

    }




}
















