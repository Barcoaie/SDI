package movie_rental.core.Validators;

import movie_rental.core.Model.Movie;

import java.util.Optional;

public class MovieValidator implements Validator<Movie> {
    @Override
    public void validate(Movie entity) throws ValidatorException {

        Optional.ofNullable(entity)
                .orElseThrow(() -> new ValidatorException("Movie must not be null!"));
        Optional.of(entity.getId()).filter(i -> i instanceof Long)
                .orElseThrow(() -> new ValidatorException("ID must be long!;"));
        Optional.of(entity.getTitle()).filter(i -> !i.isEmpty())
                .orElseThrow(() -> new ValidatorException("Movie title must not be empty!"));
        Optional.of(entity.getDescription()).filter(i -> !i.isEmpty())
                .orElseThrow(() -> new ValidatorException("Movie description must not be empty!"));

    }
}
