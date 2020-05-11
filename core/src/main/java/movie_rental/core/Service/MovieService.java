package movie_rental.core.Service;

import movie_rental.core.Model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies(int op1, String key);
    Movie saveMovie(Movie movie);
    void deleteById(Long id);
    Movie updateMovie(Long id, Movie movie);

    List<Movie> filterMoviesByID(long id);
    List<Movie> filterMoviesByTitle(String title);
    List<Movie> filterMoviesByDesc(String desc);
}
