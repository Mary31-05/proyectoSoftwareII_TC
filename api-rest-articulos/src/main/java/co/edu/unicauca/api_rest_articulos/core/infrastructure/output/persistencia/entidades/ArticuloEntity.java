package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.entidades;
import java.util.List;

import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.DTO.ConferenciaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Entidad que representa un artículo en el sistema.
 * Esta clase modela los datos de un artículo, incluyendo su título, resumen, palabras clave,
 * lista de IDs de autores, y la conferencia en la que fue o será presentado.
 */
@Getter @Setter @AllArgsConstructor
public class ArticuloEntity {
    private Integer id;
    private String titulo;
    private String resumen;
    private String palabrasClave;
    /**
     * Lista de identificadores de los autores del artículo.
     * Cada autor está representado por su ID.
     */
    private List<String> autores;
    /**
     * Objeto que representa la conferencia en la que se presentó o se presentará el artículo.
     */
    private ConferenciaDTO conferencia;

    public ArticuloEntity() {
    }

}
