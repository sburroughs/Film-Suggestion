package moviesuggestion.suggest.model.search;

import java.util.List;

/**
 * Created by Sburroughs on 9/25/2016.
 */
public class SearchRequest {

    private final List<String> likes;

    public SearchRequest(List<String> likes) {
        this.likes = likes;
    }

    public List<String> getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "likes=" + likes +
                '}';
    }
}



