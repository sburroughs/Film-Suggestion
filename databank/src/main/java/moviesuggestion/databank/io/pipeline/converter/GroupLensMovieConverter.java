package moviesuggestion.databank.io.pipeline.converter;

import moviesuggestion.databank.model.grouplens.GroupLensMovie;
import moviesuggestion.databank.model.movie.Movie;

/**
 * Created by Sburroughs on 9/19/2016.
 */
public class GroupLensMovieConverter implements MovieConverter<GroupLensMovie> {

    @Override
    public Movie convert(GroupLensMovie update, Movie source) {

        source.setTitle(update.getTitle());
        source.setReleaseDate(update.getReleaseDate());

        return source;
    }

}
