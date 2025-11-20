package academia.academia_poo.domain.irepository;

import academia.academia_poo.domain.dto.EstudianteDto;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepository {
    List<EstudianteDto> findAll();
    Optional<EstudianteDto> findById(Long id);
    EstudianteDto save(EstudianteDto dto);
    Optional<EstudianteDto> update(Long id, EstudianteDto dto);
    void deleteById(Long id);
}