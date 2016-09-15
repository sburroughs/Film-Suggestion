package moviesuggestion.databank.io.providers;

import moviesuggestion.databank.io.pipeline.OhGodWhyException;
import moviesuggestion.databank.model.MovieContent;

import java.util.List;

/**
 * Created by Sburroughs on 9/3/2016.
 */
public interface MovieContentProvider{

    List<MovieContent> getAll() throws OhGodWhyException;

}
