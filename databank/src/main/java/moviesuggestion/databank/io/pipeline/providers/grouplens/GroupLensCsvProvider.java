package moviesuggestion.databank.io.pipeline.providers.grouplens;

/**
 * Created by Sburroughs on 9/18/2016.
 */

import moviesuggestion.databank.io.pipeline.MovieUpdatePipeline;
import moviesuggestion.databank.exception.OhGodWhyException;
import moviesuggestion.databank.io.pipeline.providers.SourceImportProvider;
import moviesuggestion.databank.model.grouplens.GroupLensMovie;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Created by Sburroughs on 9/14/2016.
 */
public class GroupLensCsvProvider implements SourceImportProvider<GroupLensMovie> {

    private final static Logger log = LoggerFactory.getLogger(MovieUpdatePipeline.class);

    //TODO: broken regex. Fix and use
    private final String DATE_REGEX = "/\\((\\d{4})\\)$/g";

    private final Reader reader;

    /**
     * @param reader - required for accessing csv data. not null
     */
    public GroupLensCsvProvider(Reader reader) {
        this.reader = reader;
    }

    @Override
    public List<GroupLensMovie> getAll() throws OhGodWhyException {

        List<GroupLensMovie> contents = new ArrayList<>();

        try {

            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record : records) {

                try {

                    String titleDateValue = record.get(Header.title);
                    String genreValue = record.get(Header.genres);

                    String title = parseTitle(titleDateValue);
                    Date releaseDate = parseRelease(titleDateValue);
                    List<String> genres = parseGenre(genreValue);

                    GroupLensMovie movie = new GroupLensMovie();
                    movie.setTitle(title);
                    movie.setReleaseDate(releaseDate);
                    movie.setGenres(genres);

                    contents.add(movie);

                } catch(Exception e){
                    log.error("Unable to parse record", e);
                }

            }

        } catch (IOException e) {
            throw new OhGodWhyException(e.getMessage());
        }

        return contents;

    }

    /**
     * Parses Title from format. e.g:
     * Toy Story 2 (1998)
     *
     * @param titleDateString
     * @return
     */
    private String parseTitle(String titleDateString) {
//        String title = titleDateString.substring(0, titleDateString.indexOf(DATE_REGEX));
        String title = titleDateString.substring(0, titleDateString.length()-7);
        return title;
    }

    /**
     * Parses Title from format. e.g:
     * Action|Adventure|Suspense
     *
     * @param genreValues
     * @return
     */
    private List<String> parseGenre(String genreValues) {
        String[] genres = genreValues.split("\\s|");
        return Arrays.asList(genres);
    }

    /**
     * Parses Release Date from format. e.g:
     * Toy Story 2 (1998)
     *
     * @param original
     * @return
     */
    private Date parseRelease(String original) {
//        String dateString = original.substring(original.indexOf(DATE_REGEX));
        String formatted = original.trim();
        int length = formatted.length();

        int year = Integer.parseInt(formatted.substring(length-5, length-1));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

}

enum Header {
    title,
    genres
}
