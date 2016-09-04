package moviesuggestion.common.repository;

import moviesuggestion.common.model.movie.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findBy(String lastName);

    List<Movie> findByTag();

}
