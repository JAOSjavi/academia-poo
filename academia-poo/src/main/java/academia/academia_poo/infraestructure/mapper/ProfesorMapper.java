package academia.academia_poo.infraestructure.mapper;

import academia.academia_poo.domain.dto.ProfesorDto;
import academia.academia_poo.infraestructure.model.Profesor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {
    ProfesorDto toDto(Profesor profesor);
    Profesor toEntity(ProfesorDto dto);
    List<ProfesorDto> toDtoList(List<Profesor> profesores);
}