package neflis.neflisdemo.persistance;

import neflis.neflisdemo.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenidoRepository extends JpaRepository<Contenido, String> {}

