package co.edu.unicauca.api_rest_articulos.core.infrastructure.input.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Revision;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.DTO.RevisionDTO;

@Mapper(componentModel = "spring")
public interface RevisionMapper_Dom {
    Revision mappearDePeticion_Revision(RevisionDTO peticion);

    RevisionDTO mappearDeRevisionARespuesta(Revision objRevision);

    List<Revision> mappearDeRevisionARespuesta(List<Revision> revisiones);
}
