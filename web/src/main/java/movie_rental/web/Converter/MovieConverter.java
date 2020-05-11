package movie_rental.web.Converter;

import movie_rental.core.Model.Movie;
import movie_rental.web.Dto.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter extends BaseConverter<Movie, MovieDto> {
    @Override
    public Movie convertDtoToModel(MovieDto dto) {
        Movie movie = Movie.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
        movie.setId(dto.getId());
        return movie;
    }

    @Override
    public MovieDto convertModelToDto(Movie movie) {
        MovieDto movieDto = MovieDto.builder()
                .title(movie.getTitle())
                .description(movie.getDescription())
                .build();
        movieDto.setId(movie.getId());
        return movieDto;
    }
}
