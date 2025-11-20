package academia.academia_poo.controller;

import academia.academia_poo.domain.dto.ProfesorDto;
import academia.academia_poo.domain.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDto> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProfesorDto> create(@RequestBody ProfesorDto dto) {
        ProfesorDto created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/profesores/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorDto> update(@PathVariable Long id, @RequestBody ProfesorDto dto) {
        return service.update(id, dto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}