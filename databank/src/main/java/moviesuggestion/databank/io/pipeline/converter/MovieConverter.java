package moviesuggestion.databank.io.pipeline.converter;

import moviesuggestion.databank.model.MovieContent;
import moviesuggestion.databank.model.movie.Movie;

/**
 * Created by Sburroughs on 9/15/2016.
 */
public interface MovieConverter<T extends MovieContent> {

    Movie convert(T update, Movie source);

}
