package moviesuggestion.databank.configuration;

import moviesuggestion.databank.io.pipeline.MovieMatcher;
import moviesuggestion.databank.io.pipeline.MovieUpdateProviderFactory;
import moviesuggestion.databank.io.pipeline.providers.omdb.OmdbContentProvider;
import moviesuggestion.databank.repository.MovieRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sburroughs on 10/27/2016.
 */
@Configuration
public class MovieHandlerConfiguration {

    @Bean
    public MovieMatcher defaultMovieMatcher(MovieRepository movieRepository) {
        return new MovieMatcher(movieRepository);
    }

    @Bean
    public MovieUpdateProviderFactory movieUpdateProviderFactory(){
        return new MovieUpdateProviderFactory();
    }
}
