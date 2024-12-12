package co.edu.unicauca.api_rest_articulos.core.domain.modelos;
import java.util.List;

import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.DTO.ConferenciaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Articulo {
    private Integer id;
    /**
     * Título descriptivo del artículo.
     */
    private String titulo;
    /**
     * Resumen breve del contenido del artículo.
     */
    private String resumen;
    /**
     * Palabras clave que describen los temas del artículo, utilizadas para facilitar la búsqueda.
     */
    private String palabrasClave;
    /**
     * Lista de identificadores de los autores que contribuyeron al artículo.
     */
    private List<String> autores;
    /**
     * Objeto `ConferenciaDTO` que representa la conferencia a la cual se presenta el artículo.
     */
    private ConferenciaDTO conferencia;

    /**
     * Constructor sin argumentos.
     */
    public Articulo() {
        
    } 
}
