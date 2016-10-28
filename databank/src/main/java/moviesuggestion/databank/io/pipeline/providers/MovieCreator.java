package moviesuggestion.databank.io.pipeline.providers;

import moviesuggestion.databank.model.MovieContent;
import moviesuggestion.databank.model.movie.Movie;

/**
 * Created by Sburroughs on 9/15/2016.
 */
public interface MovieCreator<T extends MovieContent> {

    /**
     * Converts the source T movie object to the master movie object
     * @param source
     * @return
     */
    Movie create(T source);

}
