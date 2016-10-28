package moviesuggestion.databank.io.pipeline;

import moviesuggestion.databank.io.pipeline.providers.MovieUpdateProvider;
import moviesuggestion.databank.io.pipeline.providers.grouplens.GroupLensMovieCreator;
import moviesuggestion.databank.io.pipeline.providers.omdb.OmdbContentProvider;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sburroughs on 10/25/2016.
 */
public class MovieUpdateProviderFactory {

    @Autowired
    private OmdbContentProvider omdbProvider;

    public MovieUpdateProvider getProvider(String source) {

        MovieUpdateProvider provider = null;

        switch (sanitize(source)) {

            case "OMDB":
                provider = omdbProvider;
                break;

            default:
                provider = omdbProvider;
                break;
        }

        if (provider == null) {
            throw new UnsupportedOperationException("Unsupported Movie Update Provider of: " + source);
        }

        return provider;

    }

    private String sanitize(String source) {
        return source.trim().toUpperCase();
    }

}
