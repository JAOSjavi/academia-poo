package academia.academia_poo.infraestructure.repositories;

import academia.academia_poo.domain.dto.ClaseDto;
import academia.academia_poo.domain.irepository.ClaseRepository;
import academia.academia_poo.infraestructure.crud.ClaseCrudRepository;
import academia.academia_poo.infraestructure.crud.EstudianteCrudRepository;
import academia.academia_poo.infraestructure.crud.ProfesorCrudRepository;
import academia.academia_poo.infraestructure.mapper.ClaseMapper;
import academia.academia_poo.infraestructure.model.Clase;
import academia.academia_poo.infraestructure.model.Estudiante;
import academia.academia_poo.infraestructure.model.Profesor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClaseRepositoryImpl implements ClaseRepository {
    private final ClaseCrudRepository claseCrud;
    private final ProfesorCrudRepository profesorCrud;
    private final EstudianteCrudRepository estudianteCrud;
    private final ClaseMapper mapper;

    public ClaseRepositoryImpl(ClaseCrudRepository claseCrud, ProfesorCrudRepository profesorCrud, EstudianteCrudRepository estudianteCrud, ClaseMapper mapper) {
        this.claseCrud = claseCrud;
        this.profesorCrud = profesorCrud;
        this.estudianteCrud = estudianteCrud;
        this.mapper = mapper;
    }

    @Override
    public List<ClaseDto> findAll() {
        return mapper.toDtoList(claseCrud.findAll());
    }

    @Override
    public Optional<ClaseDto> findById(Long id) {
        return claseCrud.findById(id).map(mapper::toDto);
    }

    @Override
    public ClaseDto save(ClaseDto dto) {
        Clase entity = mapper.toEntity(dto);
        if (dto.getProfesorId() != null) {
            Optional<Profesor> p = profesorCrud.findById(dto.getProfesorId());
            p.ifPresent(entity::setProfesor);
        }
        if (dto.getEstudiantesIds() != null && !dto.getEstudiantesIds().isEmpty()) {
            List<Estudiante> estudiantes = estudianteCrud.findAllById(dto.getEstudiantesIds());
            entity.setEstudiantes(estudiantes);
        }
        return mapper.toDto(claseCrud.save(entity));
    }

    @Override
    public Optional<ClaseDto> update(Long id, ClaseDto dto) {
        return claseCrud.findById(id).map(existing -> {
            existing.setNombre(dto.getNombre());
            existing.setDescripcion(dto.getDescripcion());
            if (dto.getProfesorId() != null) {
                profesorCrud.findById(dto.getProfesorId()).ifPresent(existing::setProfesor);
            }
            if (dto.getEstudiantesIds() != null) {
                List<Estudiante> estudiantes = estudianteCrud.findAllById(dto.getEstudiantesIds());
                existing.setEstudiantes(estudiantes);
            }
            return mapper.toDto(claseCrud.save(existing));
        });
    }

    @Override
    public void deleteById(Long id) {
        claseCrud.deleteById(id);
    }
}