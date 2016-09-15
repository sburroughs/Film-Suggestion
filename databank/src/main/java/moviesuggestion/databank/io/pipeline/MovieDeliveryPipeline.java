package moviesuggestion.databank.io.pipeline;

import moviesuggestion.databank.model.MovieContent;
import moviesuggestion.databank.model.movie.Movie;
import moviesuggestion.databank.io.providers.MovieContentProvider;
import moviesuggestion.databank.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by Sburroughs on 9/5/2016.
 */
public class MovieDeliveryPipeline {

    private final static Logger log = LoggerFactory.getLogger(MovieDeliveryPipeline.class);

    private MovieContentProvider contentProvider;
    private MovieRepository movieRepository;
    private MovieConverter converter;

    public MovieDeliveryPipeline() {
    }

    @Autowired
    public MovieDeliveryPipeline(MovieRepository movieRepository,
                                 MovieContentProvider contentProvider,
                                 MovieConverter converter) {
        this.contentProvider = contentProvider;
        this.movieRepository = movieRepository;
        this.converter = converter;
    }

    public void run() throws OhGodWhyException {

        List<MovieContent> movies = contentProvider.getAll();

        for (MovieContent source : movies) {

            long id = getId(source);
            Movie movie = converter.convert(id, source);
            movieRepository.save(movie);

        }

    }

    /**
     * Matches incoming content with
     * @param source
     * @return
     */
    private long getId(MovieContent source) {

        String title = source.getTitle();
        Date releaseDate = source.getReleaseDate();

        List<Movie> results = movieRepository.findByTitle(title);
        if (results.size() != 1) {

            if (results.size() != 0) {
                throw new IllegalArgumentException("Duplicate titles found. Unable to determine paired id.");
            }

            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setReleaseDate(releaseDate);

            Movie saved = movieRepository.save(movie);
            results.add(saved);

        }
        long id = results.get(0).getId();

        return id;

    }


}
















