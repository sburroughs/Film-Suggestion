package moviesuggestion.suggest.repository;

import moviesuggestion.suggest.model.movie.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findAll();

    List<Movie> findByTitle(String title);

    List<Movie> findByTitleIn(List<String> titles);
}
