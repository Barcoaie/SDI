package movie_rental.core.Service;

import javafx.util.Pair;
import movie_rental.core.Model.Client;
import movie_rental.core.Model.Movie;
import movie_rental.core.Model.Rental;
import movie_rental.core.Model.SortOccMovies;
import movie_rental.core.Repository.ClientRepository;
import movie_rental.core.Repository.MovieRepository;
import movie_rental.core.Repository.RentalRepository;
import movie_rental.core.Validators.ValidatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RentalServImpl implements RentalServ {
    public static final Logger log = LoggerFactory.getLogger(RentalServImpl.class);
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private RentalRepository rentalRepository;

    public Rental rent(long cid, long mid, String date){
        log.trace("rent - method entered: cid = {}, mid = {}, date = {}", cid, mid, date);
        Optional.of(clientRepository.findById(cid)).orElseThrow(() -> new ValidatorException("Invalid client"));
        Optional.of(movieRepository.findById(mid)).orElseThrow(() -> new ValidatorException("Invalid movie"));
        Client client = this.clientRepository.findById(cid).get();
        Movie movie = this.movieRepository.findById(mid).get();
        Rental result = this.rentalRepository.save(new Rental(movie,client,date));
        log.trace("rent - method finished");
        return result;
    }

    @Override
    public void deleteRent(long id) {
        log.trace("deleteRent - method entered");
        rentalRepository.deleteById(id);
        log.trace("deleteRent - method finished");
    }

    @Override
    @Transactional
    public Rental updateRent(long id, Rental rental) {
        log.trace("update rental - method entered");
        Rental update = rentalRepository.findById(id).orElse(rental);
        update.setClient(rental.getClient());
        update.setMovie(rental.getMovie());
        update.setDate(rental.getDate());
        log.trace("update rental - method finished");
        return update;
    }

    public Set<Rental> getAllRentals() {
        Iterable<Rental> rentals = rentalRepository.findAll();
        return StreamSupport.stream(rentals.spliterator(), false).collect(Collectors.toSet());
    }

    public Pair<Movie,Long> mostRentedMovie(){
        log.trace("mostRentedMovie - method entered");
        Iterable<Movie> moviesIt = movieRepository.findAll();
        List<Movie> movies = StreamSupport.stream(moviesIt.spliterator(), false).collect(Collectors.toList());
        List<Rental> rentals = new ArrayList<>(this.getAllRentals());
        movies.sort(new SortOccMovies(rentals));
        long count = rentals.stream().filter(rental -> rental.getMovie().equals(movies.get(0))).count();
        log.trace("mostRentedMovie - method finished");
        return new Pair<>(movies.get(0),count);
    }

    @Override
    public RentalRepository getRentalRepository() {
        return rentalRepository;
    }
}
