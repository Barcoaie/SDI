package movie_rental.web.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class RentalDto extends BaseDto {
    private MovieDto movie;
    private ClientDto client;
    private String date;
}
