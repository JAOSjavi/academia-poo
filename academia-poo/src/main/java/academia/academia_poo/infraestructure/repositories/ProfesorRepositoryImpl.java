package academia.academia_poo.infraestructure.repositories;

import academia.academia_poo.domain.dto.ProfesorDto;
import academia.academia_poo.domain.irepository.ProfesorRepository;
import academia.academia_poo.infraestructure.crud.ProfesorCrudRepository;
import academia.academia_poo.infraestructure.mapper.ProfesorMapper;
import academia.academia_poo.infraestructure.model.Profesor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfesorRepositoryImpl implements ProfesorRepository {
    private final ProfesorCrudRepository crud;
    private final ProfesorMapper mapper;

    public ProfesorRepositoryImpl(ProfesorCrudRepository crud, ProfesorMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public List<ProfesorDto> findAll() {
        return mapper.toDtoList(crud.findAll());
    }

    @Override
    public Optional<ProfesorDto> findById(Long id) {
        return crud.findById(id).map(mapper::toDto);
    }

    @Override
    public ProfesorDto save(ProfesorDto dto) {
        Profesor entity = mapper.toEntity(dto);
        return mapper.toDto(crud.save(entity));
    }

    @Override
    public Optional<ProfesorDto> update(Long id, ProfesorDto dto) {
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