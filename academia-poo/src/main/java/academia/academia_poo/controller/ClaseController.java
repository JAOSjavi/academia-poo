package academia.academia_poo.controller;

import academia.academia_poo.domain.dto.ClaseDto;
import academia.academia_poo.domain.service.ClaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {
    private final ClaseService service;

    public ClaseController(ClaseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClaseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseDto> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClaseDto> create(@RequestBody ClaseDto dto) {
        ClaseDto created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/clases/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseDto> update(@PathVariable Long id, @RequestBody ClaseDto dto) {
        return service.update(id, dto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}