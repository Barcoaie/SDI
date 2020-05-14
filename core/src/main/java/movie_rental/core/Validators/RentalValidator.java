package movie_rental.core.Validators;

import movie_rental.core.Model.Rental;

import java.util.Optional;

public class RentalValidator implements Validator<Rental> {
    @Override
    public void validate(Rental entity) throws ValidatorException {

        Optional.of(entity.getDate()).filter(i -> !i.isEmpty())
                .orElseThrow(() -> new ValidatorException("Rental date must not be empty!"));
        Optional.of(entity.getDate().length()).filter(i -> i == 10)
                .orElseThrow(() -> new ValidatorException("Date string must of length 10!"));
        Optional.of(Integer.parseInt(entity.getDate().substring(0,2))).filter(i -> i > 0 && i < 31)
                .orElseThrow(() -> new ValidatorException("Day must be between 1 and 30!"));
        Optional.of(Integer.parseInt(entity.getDate().substring(3,5))).filter(i -> i > 0 && i < 13)
                .orElseThrow(() -> new ValidatorException("Month must be between 1 and 12!"));
        Optional.of(Integer.parseInt(entity.getDate().substring(6))).filter(i -> i > 1974)
                .orElseThrow(() -> new ValidatorException("Year must be after 1974!"));
        Optional.of(entity.getDate().substring(6).length()).filter(i -> i == 4)
                .orElseThrow(() -> new ValidatorException("Year must be made of 4 digits"));

    }
}
