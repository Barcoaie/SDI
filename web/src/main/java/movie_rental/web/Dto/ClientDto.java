package movie_rental.web.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@Builder
public class ClientDto extends BaseDto {
    private String name;
    private long cnp;
}
