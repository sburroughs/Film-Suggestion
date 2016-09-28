package moviesuggestion.databank.configuration;

import moviesuggestion.databank.io.pipeline.providers.UpdateImportProvider;
import moviesuggestion.databank.io.pipeline.providers.omdb.OmdbContentProvider;
import moviesuggestion.databank.model.omdb.OmdbMovie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Sburroughs on 9/28/2016.
 */
@Configuration
public class MovieUpdateConfig {

    @Bean
    public UpdateImportProvider defaultUpdateImportProvider(RestTemplate restTemplate) {
        UpdateImportProvider<OmdbMovie> provider = new OmdbContentProvider(restTemplate);
        return provider;
    }



}
