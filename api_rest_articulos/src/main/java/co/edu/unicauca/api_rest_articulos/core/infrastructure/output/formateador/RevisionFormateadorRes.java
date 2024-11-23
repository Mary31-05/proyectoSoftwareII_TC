package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.formateador;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unicauca.api_rest_articulos.core.aplication.output.RevisionFormateador;
import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Revision;

@Service
public class RevisionFormateadorRes implements RevisionFormateador {
    @Override
    public Revision prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
