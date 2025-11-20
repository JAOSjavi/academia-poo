package academia.academia_poo.infraestructure.crud;

import academia.academia_poo.infraestructure.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteCrudRepository extends JpaRepository<Estudiante, Long> {
}