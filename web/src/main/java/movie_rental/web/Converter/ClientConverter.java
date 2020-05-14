package movie_rental.web.Converter;

import movie_rental.core.Model.Client;
import movie_rental.web.Dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter extends BaseConverter<Client, ClientDto> {
    @Override
    public Client convertDtoToModel(ClientDto dto) {
        Client client = Client.builder()
                .name(dto.getName())
                .cnp(dto.getCnp())
                .build();
        client.setId(dto.getId());
        return client;
    }

    @Override
    public ClientDto convertModelToDto(Client client) {
        ClientDto dto = ClientDto.builder()
                .name(client.getName())
                .cnp(client.getCnp())
                .build();
        dto.setId(client.getId());
        return dto;
    }
}
