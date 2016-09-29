package moviesuggestion.databank.io.pipeline.providers;

import moviesuggestion.databank.model.MovieContent;
import moviesuggestion.databank.model.movie.Movie;

import java.util.List;

/**
 * Created by Sburroughs on 9/16/2016.
 */
public interface UpdateImportProvider<T extends MovieContent> extends MovieContentProvider<T>{

    T update(Movie original);

}
