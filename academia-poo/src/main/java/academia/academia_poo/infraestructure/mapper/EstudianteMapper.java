package academia.academia_poo.infraestructure.mapper;

import academia.academia_poo.domain.dto.EstudianteDto;
import academia.academia_poo.infraestructure.model.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {
    EstudianteDto toDto(Estudiante estudiante);
    @Mapping(target = "clases", ignore = true)
    Estudiante toEntity(EstudianteDto dto);
    List<EstudianteDto> toDtoList(List<Estudiante> estudiantes);
}