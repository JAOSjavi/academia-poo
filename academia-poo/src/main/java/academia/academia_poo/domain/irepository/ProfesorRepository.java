package academia.academia_poo.domain.irepository;

import academia.academia_poo.domain.dto.ProfesorDto;

import java.util.List;
import java.util.Optional;

public interface ProfesorRepository {
    List<ProfesorDto> findAll();
    Optional<ProfesorDto> findById(Long id);
    ProfesorDto save(ProfesorDto dto);
    Optional<ProfesorDto> update(Long id, ProfesorDto dto);
    void deleteById(Long id);
}