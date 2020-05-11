package movie_rental.core.Model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Rental extends BaseEntity<Long> {
    private Movie movie;
    private Client client;
    private String date;
}
