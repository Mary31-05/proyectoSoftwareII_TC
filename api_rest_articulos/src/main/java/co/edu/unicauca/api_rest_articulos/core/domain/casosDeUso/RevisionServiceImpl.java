package co.edu.unicauca.api_rest_articulos.core.domain.casosDeUso;

import java.util.List;


import co.edu.unicauca.api_rest_articulos.core.aplication.input.IRevisionService;
import co.edu.unicauca.api_rest_articulos.core.aplication.output.GestionarRevision;
import co.edu.unicauca.api_rest_articulos.core.aplication.output.RevisionFormateador;
import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Revision;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.output.services.UsuarioService;

/**
 * Implementación del servicio para la gestión de revisiones de artículos.
 * 
 * La clase `RevisionServiceImpl` proporciona la lógica de negocio para la
 * manipulación de las revisiones de artículos, implementando la interfaz
 * `IRevisionService`. Utiliza un repositorio para acceder a los datos
 * de las revisiones y un `ModelMapper` para convertir entre entidades y DTOs.
 */

public class RevisionServiceImpl implements IRevisionService{
    
    private final GestionarRevision objGestionarRevision;
    private final RevisionFormateador objRevisionFormateador;
    private final UsuarioService objUsuarioService;

    //ocurre una inyección porque este adaptador necesita usar dos puertos de salida a través de este constructor
    public RevisionServiceImpl(GestionarRevision objRegistrarRevisionGateway,
        RevisionFormateador objRevisionFormateador, UsuarioService objUsuarioService) {
        this.objGestionarRevision = objRegistrarRevisionGateway;
        this.objRevisionFormateador = objRevisionFormateador;
        this.objUsuarioService= objUsuarioService;
    }

    @Override
    public List<Revision> findAll() {
        List<Revision> listaObtenida = objGestionarRevision.findAll();
        return listaObtenida;
    }

    @Override
    public Revision findById(Integer idRevision) {
        Revision revision = objGestionarRevision.findById(idRevision);
        if (revision == null) {
            return objRevisionFormateador.prepararRespuestaFallida("Artículo no encontrado");
        }
        return revision;
    }

    @Override
    public Revision save(Revision revision, Integer idUsuario) {
        if (!objUsuarioService.validarRol(idUsuario, "ORGANIZADOR")) {
            throw new RuntimeException("El usuario no tiene permisos para crear una revisión");
        }

        for (Integer idEvaluador : revision.getEvaluadores()) {
            if (!objUsuarioService.validarRol(idEvaluador, "EVALUADOR")) {
                throw new RuntimeException("El evaluador con ID " + idEvaluador + " no puede ser asignado ya que no es un EVALUADOR");
            }
        }

        Revision guardado = objGestionarRevision.save(revision, idUsuario);
        if (guardado == null) {
            return objRevisionFormateador.prepararRespuestaFallida("Error al guardar la revisión");
        }
        return guardado;
    }

    @Override
    public Revision update(Integer id, Revision Revision) {
        Revision actualizado = objGestionarRevision.update(id, Revision);
        if (actualizado == null) {
            return objRevisionFormateador.prepararRespuestaFallida("Error al actualizar la revision");
        }
        return actualizado;
    }
    

    @Override
    public boolean delete(Integer id) {
        return objGestionarRevision.delete(id);
    }
// hacer peticion sincrona de la peticion de los roles al microservicio de usuarios
    @Override
    public Revision agregarComentario(Integer idRevision, Integer idEvaluador, String comentario) {
                // Validar rol del evaluador
                if (!objUsuarioService.validarRol(idEvaluador, "EVALUADOR")) {
                    throw new RuntimeException("El usuario no tiene permisos para evaluar el artículo");
                }
        
                return objGestionarRevision.agregarComentario(idRevision, idEvaluador, comentario);
    }

    @Override
    public Revision actualizarEstado(Integer idRevision, String estado) {
        return objGestionarRevision.actualizarEstado(idRevision, estado);
    }
   
}
