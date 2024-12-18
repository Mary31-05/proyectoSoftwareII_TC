package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.entidades;
import java.util.List;

import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.DTO.ArticuloRevisionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Entidad que representa una revisión en el sistema.
 * Esta clase modela los datos de una revisión de artículo, incluyendo el artículo asociado,
 * los evaluadores asignados, los comentarios generados durante la revisión y el estado de la misma.
 */

@Getter @Setter @AllArgsConstructor
public class RevisionEntity {
    private Integer id;
    private ArticuloRevisionDTO articulo;
    /**
     * Lista de identificadores de los evaluadores asignados a la revisión del artículo.
     */
    private List<Integer> evaluadores;
    /**
     * Lista de comentarios de los evaluadores acerca del artículo revisado.
     */
    private List<String> comentarios;
    /**
     * Estado de la revisión, indicando el progreso o conclusión de la misma.
     * Valor predeterminado: "Pendiente".
     */
    private String estado = "Pendiente";

    public RevisionEntity() {
        // Constructor vacío requerido por ModelMapper
    }
}
