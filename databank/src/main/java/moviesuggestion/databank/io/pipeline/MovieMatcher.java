package moviesuggestion.databank.io.pipeline;

import moviesuggestion.databank.model.MovieContent;
import moviesuggestion.databank.model.movie.Movie;
import moviesuggestion.databank.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by Sburroughs on 9/18/2016.
 */
public class MovieMatcher {

    private MovieRepository movieRepository;

    @Autowired
    public MovieMatcher(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Matches Content to existing content in db. Creates new Movie entry otherwise.
     *
     * @param title
     * @return
     */
    public Movie match(String title) {

        List<Movie> results = movieRepository.findByTitle(title);
        if (results.size() != 1) {

            if (results.size() != 0) {
                throw new IllegalArgumentException("Duplicate titles found. Unable to determine paired id.");
            }

            Movie movie = new Movie();
            movie.setTitle(title);

            Movie saved = movieRepository.save(movie);
            results.add(saved);

        }
        return results.get(0);

    }


}
