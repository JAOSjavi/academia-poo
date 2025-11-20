package academia.academia_poo.controller;

import academia.academia_poo.domain.dto.EstudianteDto;
import academia.academia_poo.domain.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstudianteDto> create(@RequestBody EstudianteDto dto) {
        EstudianteDto created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/estudiantes/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDto> update(@PathVariable Long id, @RequestBody EstudianteDto dto) {
        return service.update(id, dto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}