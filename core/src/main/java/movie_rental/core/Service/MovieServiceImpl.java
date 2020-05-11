package movie_rental.core.Service;

import movie_rental.core.Model.Movie;
import movie_rental.core.Repository.MovieRepository;
import movie_rental.core.Validators.MovieValidator;
import movie_rental.core.Validators.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    public static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final Validator<Movie> validator = new MovieValidator();

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies(int op1, String key) {
        log.trace("getAllMovies - method entered");
        List<Movie> movieList = null;
        if (op1 == 1) {
            movieList = movieRepository.findAll(Sort.by(Sort.Direction.ASC, key));
        }
        if (op1 == -1) {
            movieList = movieRepository.findAll(Sort.by(Sort.Direction.DESC, key));
        }
        log.trace("getAllMovies - method finished");
        return movieList;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        log.trace("saveMovie - method entered: movie = {}", movie);
        validator.validate(movie);
        Movie result = movieRepository.save(movie);
        log.trace("saveClient - method finished");
        return result;
    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteById - method entered: id = {}", id);
        log.debug("deleteById - movie deleted: movie = {}", this.movieRepository.findById(id));
        movieRepository.deleteById(id);
        log.trace("deleteById - method finished");
    }

    @Override
    @Transactional
    public Movie updateMovie(Long id, Movie movie) {
        log.trace("updateMovie - method entered: movie = {}", movie);
        Movie update = movieRepository.findById(id).orElse(movie);
        update.setTitle(movie.getTitle());
        update.setDescription(movie.getDescription());
        log.trace("updateMovie - method finished");
        return update;
    }

    @Override
    public List<Movie> filterMoviesByID(long id) {
        return this.movieRepository.findAll().stream().filter(movie -> movie.getId().equals(id)).collect(Collectors.toList());
    }

    @Override
    public List<Movie> filterMoviesByTitle(String title) {
        return this.movieRepository.findAll().stream().filter(movie -> movie.getTitle().contains(title)).collect(Collectors.toList());
    }

    @Override
    public List<Movie> filterMoviesByDesc(String desc) {
        return this.movieRepository.findAll().stream().filter(movie -> movie.getDescription().contains(desc)).collect(Collectors.toList());
    }
}
