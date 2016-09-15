package moviesuggestion.databank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Sburroughs on 9/6/2016.
 */
@Configuration
public class RestConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setPrettyPrint(true);

        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        converters.add(mappingJackson2HttpMessageConverter);

        restTemplate.setMessageConverters(converters);

        return restTemplate;
    }
}
