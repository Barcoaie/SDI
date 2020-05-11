package movie_rental.web.Controller;

import movie_rental.core.Service.MovieService;
import movie_rental.web.Converter.MovieConverter;
import movie_rental.web.Dto.MovieDto;
import movie_rental.web.Dto.MoviesDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    public static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieConverter movieConverter;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    MoviesDto getAllMovies() {
        log.trace("getAllMovies - method entered");
        MoviesDto allMovies = new MoviesDto(movieConverter.convertModelsToDtos(movieService.getAllMovies(1, "title")));
        log.trace("getAllMovies - moviesDto = {}", allMovies);
        log.trace("getAllMovies - method finished");
        return allMovies;
    }


    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    MovieDto saveMovie(@RequestBody MovieDto movieDto) {
        log.trace("saveMovie - method entered");
        MovieDto result = movieConverter.convertModelToDto(
                movieService.saveMovie(movieConverter.convertDtoToModel(movieDto)));
        log.trace("saveMovie - result = {}", result);
        log.trace("saveMovie - method finished");
        return result;
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
    MovieDto updateMovie(@PathVariable Long id,
                           @RequestBody MovieDto movieDto) {
        log.trace("updateMovie - method entered");
        MovieDto result = movieConverter.convertModelToDto(
                movieService.updateMovie(id, movieConverter.convertDtoToModel(movieDto)));
        log.trace("updateMovie - update = {}", result);
        log.trace("updateMovie - method finished");
        return result;
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        log.trace("deleteMovie - method entered");
        movieService.deleteById(id);
        log.trace("movie deleted - movieID = {}", id);
        log.trace("deleteMovie - method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
