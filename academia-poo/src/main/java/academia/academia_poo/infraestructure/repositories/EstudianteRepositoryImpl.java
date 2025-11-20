package academia.academia_poo.infraestructure.repositories;

import academia.academia_poo.domain.dto.EstudianteDto;
import academia.academia_poo.domain.irepository.EstudianteRepository;
import academia.academia_poo.infraestructure.crud.EstudianteCrudRepository;
import academia.academia_poo.infraestructure.mapper.EstudianteMapper;
import academia.academia_poo.infraestructure.model.Estudiante;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EstudianteRepositoryImpl implements EstudianteRepository {
    private final EstudianteCrudRepository crud;
    private final EstudianteMapper mapper;

    public EstudianteRepositoryImpl(EstudianteCrudRepository crud, EstudianteMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public List<EstudianteDto> findAll() {
        return mapper.toDtoList(crud.findAll());
    }

    @Override
    public Optional<EstudianteDto> findById(Long id) {
        return crud.findById(id).map(mapper::toDto);
    }

    @Override
    public EstudianteDto save(EstudianteDto dto) {
        Estudiante entity = mapper.toEntity(dto);
        return mapper.toDto(crud.save(entity));
    }

    @Override
    public Optional<EstudianteDto> update(Long id, EstudianteDto dto) {
        return crud.findById(id).map(existing -> {
            existing.setNombre(dto.getNombre());
            existing.setEmail(dto.getEmail());
            return mapper.toDto(crud.save(existing));
        });
    }

    @Override
    public void deleteById(Long id) {
        crud.deleteById(id);
    }
}