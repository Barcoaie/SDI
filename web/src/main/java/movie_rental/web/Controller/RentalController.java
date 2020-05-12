package movie_rental.web.Controller;

import movie_rental.core.Model.Rental;
import movie_rental.core.Service.RentalServ;
import movie_rental.web.Converter.RentalConverter;
import movie_rental.web.Dto.RentalDto;
import movie_rental.web.Dto.RentalsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RentalController {
    public static final Logger log = LoggerFactory.getLogger(RentalController.class);

    @Autowired
    private RentalServ rentalServ;

    @Autowired
    private RentalConverter rentalConverter;

    @RequestMapping(value = "/rentals", method = RequestMethod.GET)
    public List<RentalDto> getRentals() {
        log.trace("getAllRentals - method entered");
        List<Rental> rentals = new ArrayList<>(rentalServ.getAllRentals());
        log.trace("getAllRentals - rentalDtos = {}", rentals);
        log.trace("getAllRentals - method finished");
        return new ArrayList<>(rentalConverter.convertModelsToDtos(rentals));
    }

    @RequestMapping(value = "/rentals", method = RequestMethod.POST)
    RentalDto rent(@RequestBody RentalDto rentalDto) {
        log.trace("rent - method entered");
        RentalDto result = rentalConverter.convertModelToDto(
                rentalServ.rent(rentalDto.getClient().getId(),rentalDto.getMovie().getId(),rentalDto.getDate()));
        log.trace("rent - result = {}", result);
        log.trace("rent - method finished");
        return result;
    }

    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteRental(@PathVariable long id) {
        log.trace("deleteRental - method entered");
        rentalServ.deleteRent(id);
        log.trace("deleteRental - method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.PUT)
    public RentalDto updateRental(@PathVariable long id, @RequestBody RentalDto rentalDto) {
        log.trace("updateRental - method entered");
        RentalDto result = rentalConverter.convertModelToDto(
                rentalServ.updateRent(id, rentalConverter.convertDtoToModel(rentalDto)));
        log.trace("rental updated - result = {}", result);
        log.trace("updateRental - method finished");
        return result;
    }
}
