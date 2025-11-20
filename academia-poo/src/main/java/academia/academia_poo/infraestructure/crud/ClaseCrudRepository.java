package academia.academia_poo.infraestructure.crud;

import academia.academia_poo.infraestructure.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseCrudRepository extends JpaRepository<Clase, Long> {
}