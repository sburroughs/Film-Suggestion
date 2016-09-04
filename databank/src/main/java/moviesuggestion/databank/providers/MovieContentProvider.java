package moviesuggestion.databank.providers;

import moviesuggestion.common.model.movie.Movie;

import java.util.List;

/**
 * Created by Sburroughs on 9/3/2016.
 */
public interface MovieContentProvider {

    List<Movie> getAll();

    Movie updateOne(Movie outdated);


}
