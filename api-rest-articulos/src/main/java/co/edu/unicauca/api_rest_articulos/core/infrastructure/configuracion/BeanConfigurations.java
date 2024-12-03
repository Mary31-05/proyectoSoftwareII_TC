package co.edu.unicauca.api_rest_articulos.core.infrastructure.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.api_rest_articulos.core.aplication.input.IArticuloService;
import co.edu.unicauca.api_rest_articulos.core.aplication.input.IRevisionService;
import co.edu.unicauca.api_rest_articulos.core.aplication.output.ArticuloFormateador;
import co.edu.unicauca.api_rest_articulos.core.aplication.output.GestionarArticulo;
import co.edu.unicauca.api_rest_articulos.core.aplication.output.GestionarRevision;
import co.edu.unicauca.api_rest_articulos.core.aplication.output.RevisionFormateador;
import co.edu.unicauca.api_rest_articulos.core.domain.casosDeUso.ArticuloServiceImpl;
import co.edu.unicauca.api_rest_articulos.core.domain.casosDeUso.RevisionServiceImpl;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.output.services.UsuarioService;


@Configuration
public class BeanConfigurations {
    @Bean
    public IArticuloService crearArticuloService(
            GestionarArticulo objGestionarArticulo,
            ArticuloFormateador objArticuloFormateador, UsuarioService objUsuarioService) {
        return new ArticuloServiceImpl(objGestionarArticulo, objArticuloFormateador, objUsuarioService);
    }

    @Bean
    public IRevisionService crearRevisionService(
            GestionarRevision objGestionarRevision,
            RevisionFormateador objRevisionFormateador, UsuarioService objUsuarioService) {
        return new RevisionServiceImpl(objGestionarRevision, objRevisionFormateador, objUsuarioService);
    }

}
