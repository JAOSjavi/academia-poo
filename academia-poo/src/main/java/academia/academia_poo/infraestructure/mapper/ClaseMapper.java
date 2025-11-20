package academia.academia_poo.infraestructure.mapper;

import academia.academia_poo.domain.dto.ClaseDto;
import academia.academia_poo.infraestructure.model.Clase;
import academia.academia_poo.infraestructure.model.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClaseMapper {
    @Mapping(target = "profesorId", source = "profesor.id")
    @Mapping(target = "estudiantesIds", source = "estudiantes", qualifiedByName = "toIds")
    ClaseDto toDto(Clase clase);

    @Mapping(target = "profesor", ignore = true)
    @Mapping(target = "estudiantes", ignore = true)
    Clase toEntity(ClaseDto dto);

    List<ClaseDto> toDtoList(List<Clase> clases);

    @Named("toIds")
    default List<Long> toIds(List<Estudiante> estudiantes) {
        if (estudiantes == null) return null;
        return estudiantes.stream().map(Estudiante::getId).collect(Collectors.toList());
    }
}