package movie_rental.core.Service;

import javafx.util.Pair;
import movie_rental.core.Model.Movie;
import movie_rental.core.Model.Rental;
import movie_rental.core.Repository.RentalRepository;

import java.util.Set;

public interface RentalServ {
    Rental rent(long cid, long mid, String date);
    void deleteRent(long id);
    Rental updateRent(long id, Rental rental);
    Set<Rental> getAllRentals();
    Pair<Movie,Long> mostRentedMovie();
    RentalRepository getRentalRepository();
}
