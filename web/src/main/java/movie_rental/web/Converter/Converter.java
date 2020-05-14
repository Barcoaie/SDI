package movie_rental.web.Converter;

import movie_rental.core.Model.BaseEntity;
import movie_rental.web.Dto.BaseDto;

public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {
    Model convertDtoToModel(Dto dto);
    Dto convertModelToDto(Model model);
}
