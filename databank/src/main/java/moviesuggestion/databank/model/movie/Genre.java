package moviesuggestion.databank.model.movie;

import javax.persistence.*;

/**
 * Created by Sburroughs on 9/5/2016.
 */
@Entity
public class Genre {

    private long id;
    private String name;
    private Movie movie;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "movie_id")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
