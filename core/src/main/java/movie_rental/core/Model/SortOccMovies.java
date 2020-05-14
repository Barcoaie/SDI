package movie_rental.core.Model;

import java.util.Comparator;
import java.util.List;

public class SortOccMovies implements Comparator<Movie> {
    private List<Rental> rentals;
    public SortOccMovies(List<Rental> rentals){
        this.rentals = rentals;
    }
    @Override
    public int compare(Movie movie1, Movie movie2) {
        long a1 = rentals.stream().filter(rental -> rental.getMovie().equals(movie1)).count();
        long a2 = rentals.stream().filter(rental -> rental.getMovie().equals(movie2)).count();
        return (int)(a2-a1);
    }
}
