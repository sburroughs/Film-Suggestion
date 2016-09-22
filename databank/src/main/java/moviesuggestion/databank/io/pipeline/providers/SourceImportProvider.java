package moviesuggestion.databank.io.pipeline.providers;

import moviesuggestion.databank.exception.OhGodWhyException;
import moviesuggestion.databank.model.MovieContent;
import moviesuggestion.databank.model.movie.Movie;

import java.util.List;

/**
 * Created by Sburroughs on 9/16/2016.
 */
public interface SourceImportProvider<T extends MovieContent> extends MovieContentProvider<T> {

    List<T> getAll() throws OhGodWhyException;

}
