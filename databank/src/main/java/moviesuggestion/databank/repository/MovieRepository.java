package moviesuggestion.databank.repository;

import moviesuggestion.databank.model.movie.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findByTitle(String title);

    List<Movie> findAll();
}
