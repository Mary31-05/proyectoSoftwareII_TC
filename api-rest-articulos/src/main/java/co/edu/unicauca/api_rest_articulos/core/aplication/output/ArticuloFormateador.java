package co.edu.unicauca.api_rest_articulos.core.aplication.output;

import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Articulo;

public interface ArticuloFormateador {
    public Articulo prepararRespuestaFallida(String error);
}
