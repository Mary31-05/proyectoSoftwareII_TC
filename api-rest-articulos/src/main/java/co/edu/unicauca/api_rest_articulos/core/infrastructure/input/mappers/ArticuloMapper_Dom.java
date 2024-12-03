package co.edu.unicauca.api_rest_articulos.core.infrastructure.input.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Articulo;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.DTO.ArticuloDTO;
@Mapper(componentModel = "spring")
public interface ArticuloMapper_Dom {
    ArticuloMapper_Dom INSTANCE = Mappers.getMapper(ArticuloMapper_Dom.class);
    Articulo mappearDePeticion_Articulo(ArticuloDTO peticion);

    ArticuloDTO mappearDeArticuloARespuesta(Articulo objArticulo);

    List<Articulo> mappearDeArticulosARespuesta(List<Articulo> articulos);
}
