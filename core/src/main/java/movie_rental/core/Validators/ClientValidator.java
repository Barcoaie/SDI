package movie_rental.core.Validators;

import movie_rental.core.Model.Client;

import java.util.Optional;

public class ClientValidator implements Validator<Client> {
    @Override
    public void validate(Client entity) throws ValidatorException {
        /*if (entity == null) {
            throw new NullPointerException();
        }*/

        Optional.ofNullable(entity)
                .orElseThrow(() -> new ValidatorException("Client cannot be null!;"));
        Optional.of(entity.getId()).filter(i -> i instanceof Long)
                .orElseThrow(() -> new ValidatorException("ID must be long!;"));
        Optional.of(entity.getName()).filter((e) -> e.matches(".*[,>/.;:!0-9].*"))
                .ifPresent(i -> {
            throw new ValidatorException("Client name must not contain symbols!");
        });
        Optional.of(entity.getName()).filter(i -> !i.isEmpty())
                .orElseThrow(() -> new ValidatorException("Client name must not be empty!"));
        Optional.of(entity.getCnp()).filter(i -> i >= Long.parseLong("1000000000000") && i <= Long.parseLong("9999999999999"))
                .orElseThrow(() -> new ValidatorException("Invalid CNP!"));
        /*
        if (!(entity.getID() instanceof Long)) {
            _errors += "ID must be Long; ";
        }

        if (entity.getName().isEmpty()) {
            _errors += "Empty name; ";
        }
        */

        /*
        if (entity.getCnp() < Long.parseLong("1000000000000") || entity.getCnp() > Long.parseLong("9999999999999")) {
            _errors += "Invalid CNP";
        }

        if (!_errors.isEmpty()) {
            throw new ValidatorException(_errors);
        }
         */
    }
}
