package moviesuggestion.databank.io.pipeline.providers.grouplens;

import moviesuggestion.databank.io.pipeline.providers.MovieCreator;
import moviesuggestion.databank.model.grouplens.GroupLensMovie;
import moviesuggestion.databank.model.movie.Movie;

/**
 * Created by Sburroughs on 9/19/2016.
 */
public class GroupLensMovieCreator implements MovieCreator<GroupLensMovie> {

    @Override
    public Movie create(GroupLensMovie update) {

        Movie source = new Movie();

        source.setTitle(update.getTitle());
        source.setReleaseDate(update.getReleaseDate());

        return source;
    }

}
