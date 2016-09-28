package moviesuggestion.databank.configuration;

import moviesuggestion.databank.io.pipeline.MovieMatcher;
import moviesuggestion.databank.io.pipeline.converter.GroupLensMovieConverter;
import moviesuggestion.databank.io.pipeline.converter.MovieConverter;
import moviesuggestion.databank.io.pipeline.converter.OmdbMovieConverter;
import moviesuggestion.databank.io.pipeline.providers.SourceImportProvider;
import moviesuggestion.databank.io.pipeline.providers.grouplens.GroupLensCsvProvider;
import moviesuggestion.databank.model.grouplens.GroupLensMovie;
import moviesuggestion.databank.model.omdb.OmdbMovie;
import moviesuggestion.databank.repository.MovieRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * Created by Sburroughs on 9/28/2016.
 */
@Configuration
public class MovieSourceConfig {


    @Bean
    public MovieConverter defaultMovieConverter() {

        MovieConverter<OmdbMovie> converter = new OmdbMovieConverter();

        return converter;
    }

    @Bean
    public SourceImportProvider defaultSourceImportProvider() {
        SourceImportProvider<GroupLensMovie> provider = new GroupLensCsvProvider(defaultCsvContentProviderReader());

        return provider;
    }


    @Bean
    public MovieMatcher defaultMovieMatcher(MovieRepository movieRepository) {
        MovieMatcher matcher = new MovieMatcher(movieRepository);
        return matcher;
    }


    private Reader defaultCsvContentProviderReader() {
        String location = "C:\\Users\\shanu\\Desktop\\ml-latest\\movies.csv";
        Reader reader = null;
        try {
            reader = new FileReader(location);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return reader;
    }



}
