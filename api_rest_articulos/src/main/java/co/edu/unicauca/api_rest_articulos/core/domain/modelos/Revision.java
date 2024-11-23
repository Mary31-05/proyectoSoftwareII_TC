package co.edu.unicauca.api_rest_articulos.core.domain.modelos;
import java.util.List;

import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.DTO.ArticuloRevisionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Revision {
private Integer id;
    /**
     * Información básica del artículo asociado a la revisión.
     */
    private ArticuloRevisionDTO Articulo;
    /**
     * Lista de identificadores de evaluadores asignados a la revisión.
     */
    private List<Integer> evaluadores;
    /**
     * Lista de comentarios realizados durante el proceso de revisión.
     */
    private List<String> comentarios;
    /**
     * Estado actual de la revisión (e.g., pendiente, en proceso, completado).
     */
    private String estado;
    /**
     * Constructor sin argumentos necesario para la serialización y deserialización de objetos.
     */
    public Revision() {
 
    } 
}
