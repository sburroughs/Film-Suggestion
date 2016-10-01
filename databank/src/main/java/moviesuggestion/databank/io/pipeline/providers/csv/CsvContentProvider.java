package moviesuggestion.databank.io.pipeline.providers.csv;

import moviesuggestion.databank.exception.OhGodWhyException;
import moviesuggestion.databank.io.pipeline.providers.SourceImportProvider;
import moviesuggestion.databank.model.MovieContent;
import moviesuggestion.databank.model.movie.MPAA;
import moviesuggestion.databank.model.movie.Movie;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sburroughs on 9/14/2016.
 */
public class CsvContentProvider implements SourceImportProvider {

    private final Reader reader;

    /**
     * @param reader - required for accessing csv data. not null
     */
    public CsvContentProvider(Reader reader) {
        this.reader = reader;
    }

    @Override
    public List<MovieContent> getAll() {

        List<MovieContent> contents = new ArrayList<>();

        try {

            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record : records) {

                String title = record.get(Header.TITLE);
                String released = record.get(Header.RELEASE_DATE);
                String plot = record.get(Header.PLOT);
                String rated = record.get(Header.RATED);
                String runtime = record.get(Header.RUNTIME);

                Movie movie = new Movie();
                movie.setTitle(title);
                movie.setReleaseDate(new Date(released));
                movie.setPlot(plot);
                movie.setRated(MPAA.valueOf(rated));
                movie.setRuntime(Integer.parseInt(runtime));

                contents.add(movie);

            }

        } catch (IOException e) {
            throw new OhGodWhyException(e.getMessage());
        }

        return contents;

    }

}

enum Header {
    TITLE,
    RELEASE_DATE,
    PLOT,
    RATED,
    RUNTIME
}
