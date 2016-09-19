package moviesuggestion.databank.io.pipeline.converter;

import moviesuggestion.databank.model.grouplens.GroupLensMovie;
import moviesuggestion.databank.model.movie.Movie;

/**
 * Created by Sburroughs on 9/19/2016.
 */
public class GroupLensMovieConverter implements MovieConverter<GroupLensMovie> {

    @Override
    public Movie convert(long id, GroupLensMovie sourceMovie) {

        Movie movie = new Movie();
//        movie.setTitle();
        return movie;
    }

}
