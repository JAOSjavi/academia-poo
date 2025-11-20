package academia.academia_poo.domain.service;

import academia.academia_poo.domain.dto.EstudianteDto;
import academia.academia_poo.domain.irepository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<EstudianteDto> getAll() {
        return repository.findAll();
    }

    public Optional<EstudianteDto> getById(Long id) {
        return repository.findById(id);
    }

    public EstudianteDto create(EstudianteDto dto) {
        return repository.save(dto);
    }

    public Optional<EstudianteDto> update(Long id, EstudianteDto dto) {
        return repository.update(id, dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}