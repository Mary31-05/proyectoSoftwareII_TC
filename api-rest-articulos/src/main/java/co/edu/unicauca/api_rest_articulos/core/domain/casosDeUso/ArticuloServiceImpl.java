package co.edu.unicauca.api_rest_articulos.core.domain.casosDeUso;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.unicauca.api_rest_articulos.core.aplication.input.IArticuloService;
import co.edu.unicauca.api_rest_articulos.core.aplication.output.ArticuloFormateador;
import co.edu.unicauca.api_rest_articulos.core.aplication.output.GestionarArticulo;
import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Articulo;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.output.services.UsuarioService;

@Service
@Primary
public class ArticuloServiceImpl implements IArticuloService {

    private final GestionarArticulo objGestionarArticulo;
    private final ArticuloFormateador objArticuloFormateador;
    private final UsuarioService objUsuarioService;

    public ArticuloServiceImpl(GestionarArticulo objRegistrarArticuloGateway,
        ArticuloFormateador objArticuloFormateador, UsuarioService objUsuarioService) {
        this.objGestionarArticulo = objRegistrarArticuloGateway;
        this.objArticuloFormateador = objArticuloFormateador;
        this.objUsuarioService = objUsuarioService;
    }

    @Override
    public List<Articulo> findAll() {
        List<Articulo> listaObtenida = objGestionarArticulo.findAll();
        return listaObtenida;
    }

    @Override
    public Articulo findById(Integer id) {
        Articulo articulo = objGestionarArticulo.findById(id);
        if (articulo == null) {
            return objArticuloFormateador.prepararRespuestaFallida("Artículo no encontrado");
        }
        return articulo;
    }

    @Override
    public Articulo exist(Integer id) {
        return objGestionarArticulo.exist(id);
    }

    @Override
    public Articulo save(Articulo articulo, Integer idUsuario) {
        if (!objUsuarioService.validarRol(idUsuario, "AUTOR")) {
            throw new RuntimeException("El usuario no tiene permisos para subir artículos");
        }
        
        Articulo guardado = objGestionarArticulo.save(articulo, idUsuario);
        if (guardado == null) {
            return objArticuloFormateador.prepararRespuestaFallida("Error al guardar el artículo");
        }
        return guardado;
    }

    @Override
    public Articulo update(Integer id, Articulo articulo) {
        Articulo actualizado = objGestionarArticulo.update(id, articulo);
        if (actualizado == null) {
            return objArticuloFormateador.prepararRespuestaFallida("Error al actualizar el artículo");
        }
        return actualizado;
    }

    @Override
    public boolean delete(Integer id) {
        return objGestionarArticulo.delete(id);
    }
}
