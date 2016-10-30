package moviesuggestion.suggest.model.movie;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @Field
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Field
    private String title;

    @Field
    private Date releaseDate;

    @Field
    private MPAA rated;

    @Field
    private int runtime;

    @Field
    @Column(columnDefinition = "LONGTEXT")
    private String plot;

    @Field
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_genre",
            joinColumns = {@JoinColumn(name = "MOVIE_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "GENRE_ID", nullable = false, updatable = false)})
    private Set<Genre> genres;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_film_crew",
            joinColumns = {@JoinColumn(name = "MOVIE_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "FILM_CREW_ID", nullable = false, updatable = false)})
    private Set<FilmCrewMember> filmCrew;

//    private List<Review> reviews;
//    private List<Achievement> achievements;
//    private FilmingMetadata metadata;
//    private List<FilmMedia> streams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public MPAA getRated() {
        return rated;
    }

    public void setRated(MPAA rated) {
        this.rated = rated;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<FilmCrewMember> getFilmCrew() {
        return filmCrew;
    }

    public void setFilmCrew(Set<FilmCrewMember> filmCrew) {
        this.filmCrew = filmCrew;
    }
}








