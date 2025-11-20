package academia.academia_poo.domain.service;

import academia.academia_poo.domain.dto.ProfesorDto;
import academia.academia_poo.domain.irepository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    private final ProfesorRepository repository;

    public ProfesorService(ProfesorRepository repository) {
        this.repository = repository;
    }

    public List<ProfesorDto> getAll() {
        return repository.findAll();
    }

    public Optional<ProfesorDto> getById(Long id) {
        return repository.findById(id);
    }

    public ProfesorDto create(ProfesorDto dto) {
        return repository.save(dto);
    }

    public Optional<ProfesorDto> update(Long id, ProfesorDto dto) {
        return repository.update(id, dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}