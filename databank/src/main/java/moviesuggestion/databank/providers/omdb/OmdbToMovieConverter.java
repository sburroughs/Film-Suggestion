package moviesuggestion.databank.providers.omdb;

import moviesuggestion.common.model.movie.Movie;
import org.springframework.core.convert.converter.Converter;

public final class OmdbToMovieConverter implements Converter<OmdbMovie, Movie> {

    public Movie convert(OmdbMovie source) {

        Movie movie = new Movie();
        movie.setTitle("THIS IS A STATIC MOVIE. TODO");

        return movie;
    }

}
