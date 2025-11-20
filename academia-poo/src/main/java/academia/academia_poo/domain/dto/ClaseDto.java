package academia.academia_poo.domain.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class ClaseDto {
    private Long id;
    @NotBlank
    private String nombre;
    private String descripcion;
    private Long profesorId;
    private List<Long> estudiantesIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public List<Long> getEstudiantesIds() {
        return estudiantesIds;
    }

    public void setEstudiantesIds(List<Long> estudiantesIds) {
        this.estudiantesIds = estudiantesIds;
    }
}