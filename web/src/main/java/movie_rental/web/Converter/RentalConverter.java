package movie_rental.web.Converter;

import movie_rental.core.Model.Rental;
import movie_rental.web.Dto.RentalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentalConverter extends BaseConverter<Rental, RentalDto> {

    @Autowired
    private ClientConverter clientConverter;
    @Autowired
    private MovieConverter movieConverter;

    @Override
    public Rental convertDtoToModel(RentalDto dto) {
        Rental rental = Rental.builder()
                .client(clientConverter.convertDtoToModel(dto.getClient()))
                .movie(movieConverter.convertDtoToModel(dto.getMovie()))
                .date(dto.getDate())
                .build();
        rental.setId(dto.getId());
        return rental;
    }

    @Override
    public RentalDto convertModelToDto(Rental rental) {
        RentalDto dto = RentalDto.builder()
                .client(clientConverter.convertModelToDto(rental.getClient()))
                .movie(movieConverter.convertModelToDto(rental.getMovie()))
                .date(rental.getDate())
                .build();
        dto.setId(rental.getId());
        return dto;
    }
}
