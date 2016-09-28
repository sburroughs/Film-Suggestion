package moviesuggestion.databank.io.pipeline;

import moviesuggestion.databank.io.pipeline.converter.MovieConverter;
import moviesuggestion.databank.io.pipeline.providers.UpdateImportProvider;
import moviesuggestion.databank.model.MovieContent;
import moviesuggestion.databank.model.movie.Movie;
import moviesuggestion.databank.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Sburroughs on 9/5/2016.
 */
@Component
public class MovieUpdatePipeline<T extends MovieContent> {

    private final static Logger log = LoggerFactory.getLogger(MovieUpdatePipeline.class);

    private MovieRepository movieRepository;
    private UpdateImportProvider<T> provider;
    private MovieConverter<T> converter;

    @Autowired
    public MovieUpdatePipeline(MovieRepository movieRepository,
                               UpdateImportProvider<T> provider,
                               MovieConverter<T> converter) {
        this.provider = provider;
        this.movieRepository = movieRepository;
        this.converter = converter;
    }

    public void run() {

        log.info("Update Pipeline Start: {}", Calendar.getInstance().getTime());

        Pageable limit = new PageRequest(0, 50);
        Slice<Movie> sliceUpdateList = movieRepository.findAll(limit);

        List<Movie> movies = sliceUpdateList.getContent();

        log.info("Titles: {}", movies.size());

        for (Movie currentMovie : movies) {

            String title = currentMovie.getTitle();

            T update = provider.update(currentMovie);
            if (update == null || update.getTitle() == null || update.getReleaseDate() == null) {
                log.error("Unable to Update {}: Upstream Update Missing required values", title);
                continue;
            }

            Movie converted = converter.convert(update, currentMovie);

            log.info("Updating: {}", title);
            movieRepository.save(converted);

        }

    }


}
















