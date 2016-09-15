package moviesuggestion.databank.model.movie;

import moviesuggestion.databank.model.MovieContent;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Movie implements MovieContent{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Date releaseDate;
    private String plot;
    private MPAA rated;
    private int runtime;
    private String poster;

//    @OneToMany(mappedBy = "movie")
//    private List<Genre> genres;
//    private List<Cast> cast;
//    private List<Review> reviews;
//    private List<Achievement> achievements;
//    private FilmingMetadata metadata;
//    private List<Tag> tags;
//    private List<MediaStream> streams;

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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

//    public List<Genre> getGenres() {
//        return genres;
//    }
//
//    public void setGenres(List<Genre> genres) {
//        this.genres = genres;
//    }
//
//    public List<Cast> getCast() {
//        return cast;
//    }
//
//    public void setCast(List<Cast> cast) {
//        this.cast = cast;
//    }
//
//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }
//
//    public List<Achievement> getAchievements() {
//        return achievements;
//    }
//
//    public void setAchievements(List<Achievement> achievements) {
//        this.achievements = achievements;
//    }
//
//    public FilmingMetadata getMetadata() {
//        return metadata;
//    }
//
//    public void setMetadata(FilmingMetadata metadata) {
//        this.metadata = metadata;
//    }
//
//    public List<Tag> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<Tag> tags) {
//        this.tags = tags;
//    }
//
//    public List<MediaStream> getStreams() {
//        return streams;
//    }
//
//    public void setStreams(List<MediaStream> streams) {
//        this.streams = streams;
//    }
}








