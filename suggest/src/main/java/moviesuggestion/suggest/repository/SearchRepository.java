package moviesuggestion.suggest.repository;

import moviesuggestion.suggest.model.movie.MPAA;
import moviesuggestion.suggest.model.movie.Movie;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SearchRepository extends SolrCrudRepository<Movie, String> {

    List<Movie> findByGenresAndRated(String genre, MPAA rated);

    List<Movie> findByTitleIn(List<String> likes);
}

