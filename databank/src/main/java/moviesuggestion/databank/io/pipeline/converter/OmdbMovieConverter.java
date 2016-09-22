package moviesuggestion.databank.io.pipeline.converter;

import moviesuggestion.databank.model.movie.Genre;
import moviesuggestion.databank.model.movie.MPAA;
import moviesuggestion.databank.model.movie.Movie;
import moviesuggestion.databank.model.omdb.OmdbMovie;

import java.util.ArrayList;
import java.util.List;

public final class OmdbMovieConverter implements MovieConverter<OmdbMovie> {

    @Override
    public Movie convert(OmdbMovie update, Movie source) {

        source.setTitle(source.getTitle());
        source.setReleaseDate(source.getReleaseDate());
        source.setRated(MPAA.valueOf(update.getRated()));
        source.setRuntime(parseRuntime(update.getRuntime()));
        source.setPlot(source.getPlot());
//        movie.setGenres(parseGenre(id, movie, source.getGenre()));

        return source;

    }

    private int parseRuntime(String runtime) {
        return Integer.parseInt(runtime.replaceAll("[^\\d]", ""));
    }

    private List<Genre> parseGenre(long id, Movie movie, String original) {
        List<Genre> genres = new ArrayList<>();

        String[] genreParsed = original.split(",");
        for (String name : genreParsed) {
            Genre genre = new Genre();
            genre.setId(id);
            genre.setName(name);
            genre.setMovie(movie);
            genres.add(genre);
        }

        return genres;
    }


}
