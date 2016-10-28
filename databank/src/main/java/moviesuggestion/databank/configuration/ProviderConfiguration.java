package moviesuggestion.databank.configuration;

import moviesuggestion.databank.io.pipeline.providers.omdb.OmdbContentProvider;
import moviesuggestion.databank.io.pipeline.providers.omdb.OmdbMovieCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Sburroughs on 10/27/2016.
 */
@Configuration
public class ProviderConfiguration {


    @Bean
    public OmdbContentProvider defaultOmdbContentProvider(RestTemplate restTemplate) {
        return new OmdbContentProvider(restTemplate, defaultOmdbMovieCreator());
    }

    private OmdbMovieCreator defaultOmdbMovieCreator(){
        return new OmdbMovieCreator();
    }

}
