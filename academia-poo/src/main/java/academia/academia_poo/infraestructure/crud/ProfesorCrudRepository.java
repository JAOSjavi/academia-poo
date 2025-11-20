package academia.academia_poo.infraestructure.crud;

import academia.academia_poo.infraestructure.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorCrudRepository extends JpaRepository<Profesor, Long> {
}