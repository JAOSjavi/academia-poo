package academia.academia_poo.domain.service;

import academia.academia_poo.domain.dto.ClaseDto;
import academia.academia_poo.domain.irepository.ClaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {
    private final ClaseRepository repository;

    public ClaseService(ClaseRepository repository) {
        this.repository = repository;
    }

    public List<ClaseDto> getAll() {
        return repository.findAll();
    }

    public Optional<ClaseDto> getById(Long id) {
        return repository.findById(id);
    }

    public ClaseDto create(ClaseDto dto) {
        return repository.save(dto);
    }

    public Optional<ClaseDto> update(Long id, ClaseDto dto) {
        return repository.update(id, dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}