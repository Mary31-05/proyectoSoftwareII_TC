package co.edu.unicauca.api_rest_articulos.core.aplication.output;

import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Revision;

public interface RevisionFormateador {

    public Revision prepararRespuestaFallida(String error);
}
