package moviesuggestion.databank.io.pipeline.providers.omdb;

import moviesuggestion.databank.io.pipeline.providers.MovieCreator;
import moviesuggestion.databank.model.movie.*;
import moviesuggestion.databank.model.omdb.OmdbMovie;

import java.util.HashSet;
import java.util.Set;


public final class OmdbMovieCreator implements MovieCreator<OmdbMovie> {

    @Override
    public Movie create(OmdbMovie update) {

        Movie source = new Movie();

        source.setTitle(update.getTitle());
        source.setReleaseDate(update.getReleaseDate());
        source.setRated(parseRating(update.getRated()));
        source.setRuntime(parseRuntime(update.getRuntime()));
        source.setPlot(update.getPlot());
        source.setGenres(parseGenre(update.getGenre()));
        source.setFilmCrew(parseFilmCrew( update.getActors(), update.getDirector(), update.getWriter()));

        return source;

    }

    private Set<FilmCrewMember> parseFilmCrew(String actorString, String directorString, String writer) {

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
     * @param original
     * @return
     */
    private Set<Genre> parseGenre(String original) {

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
