package moviesuggestion.databank.model.grouplens;

import moviesuggestion.databank.model.MovieContent;

import java.util.Date;
import java.util.List;

/**
 * Created by Sburroughs on 9/18/2016.
 */
public class GroupLensMovie implements MovieContent {

    private String title;
    private Date releaseDate;
    private List<String> genres;

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }


    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
