package academia.academia_poo.domain.irepository;

import academia.academia_poo.domain.dto.ClaseDto;

import java.util.List;
import java.util.Optional;

public interface ClaseRepository {
    List<ClaseDto> findAll();
    Optional<ClaseDto> findById(Long id);
    ClaseDto save(ClaseDto dto);
    Optional<ClaseDto> update(Long id, ClaseDto dto);
    void deleteById(Long id);
}