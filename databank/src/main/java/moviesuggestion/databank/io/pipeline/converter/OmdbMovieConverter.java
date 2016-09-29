package moviesuggestion.databank.io.pipeline.converter;

import moviesuggestion.databank.model.movie.*;
import moviesuggestion.databank.model.omdb.OmdbMovie;

import java.util.HashSet;
import java.util.Set;


public final class OmdbMovieConverter implements MovieConverter<OmdbMovie> {

    @Override
    public Movie convert(OmdbMovie update, Movie source) {

        Long id = source.getId();

        source.setTitle(update.getTitle());
        source.setReleaseDate(update.getReleaseDate());
        source.setRated(parseRating(update.getRated()));
        source.setRuntime(parseRuntime(update.getRuntime()));
        source.setPlot(update.getPlot());
        source.setGenres(parseGenre(source, update.getGenre()));
        source.setFilmCrew(parseFilmCrew(source, update.getActors(), update.getDirector(), update.getWriter()));

        return source;

    }

    private Set<FilmCrewMember> parseFilmCrew(Movie source, String actorString, String directorString, String writer) {

        Set<FilmCrewMember> filmCrew = new HashSet<>();

        String[] actorNames = actorString.split(",");
        for (String name : actorNames) {

            String[] namePair = name.trim().split(" ");
            if (namePair.length == 2) {

                String firstName = namePair[0];
                String lastName = namePair[1];

                FilmCrewMember currentMember = new FilmCrewMember();
                currentMember.setRole(FilmCrewMemberRole.ACTOR.name());
                currentMember.setFirstName(firstName);
                currentMember.setLastName(lastName);

                filmCrew.add(currentMember);

            }
        }

        String[] directorNames = directorString.split(",");
        for (String name : directorNames) {

            String[] namePair = name.trim().split(" ");
            if (namePair.length == 2) {

                String firstName = namePair[0];
                String lastName = namePair[1];

                FilmCrewMember currentMember = new FilmCrewMember();
                currentMember.setRole(FilmCrewMemberRole.DIRECTOR.name());
                currentMember.setFirstName(firstName);
                currentMember.setLastName(lastName);

                filmCrew.add(currentMember);

            }
        }

        return filmCrew;
    }

    /**
     * @param runtime
     * @return
     */
    private int parseRuntime(String runtime) {
        return Integer.parseInt(runtime.replaceAll("[^\\d]", ""));
    }

    /**
     * @param rating
     * @return
     */
    private MPAA parseRating(String rating) {

        if (rating.equalsIgnoreCase("N/A")) {
            return null;
        }

        String formattedRating = rating.replaceAll("-", "");
        return MPAA.valueOf(formattedRating);

    }

    /**
     * @param movie
     * @param original
     * @return
     */
    private Set<Genre> parseGenre(Movie movie, String original) {

        Set<Genre> genres = new HashSet<>();

        String formatted = original.replaceAll("\\s+", "");

        String[] genreParsed = formatted.split(",");
        for (String name : genreParsed) {

            Genre genre = new Genre();
            genre.setName(name);

            genres.add(genre);

        }

        return genres;

    }

}
