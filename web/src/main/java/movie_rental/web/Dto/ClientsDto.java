package movie_rental.web.Dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ClientsDto {
    private Set<ClientDto> clients;
}
