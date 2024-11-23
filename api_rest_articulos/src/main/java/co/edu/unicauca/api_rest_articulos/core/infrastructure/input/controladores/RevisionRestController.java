package co.edu.unicauca.api_rest_articulos.core.infrastructure.input.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.api_rest_articulos.core.aplication.input.IRevisionService;
import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Revision;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.DTO.RevisionDTO;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.mappers.RevisionMapper_Dom;

@RestController
@RequestMapping ("/api")
public class RevisionRestController {
    
    private final IRevisionService revisionService;
    private final RevisionMapper_Dom revisionMapper;
    public RevisionRestController(IRevisionService revisionService, RevisionMapper_Dom revisionMapper) {
        this.revisionService = revisionService;
        this.revisionMapper = revisionMapper;
    }

    @GetMapping("/revisiones")
    public List<Revision> listarRevisiones() {
        return revisionMapper.mappearDeRevisionARespuesta(this.revisionService.findAll());
    }

    @GetMapping("/revisiones/{id}")
    public ResponseEntity<RevisionDTO> consultarRevision(@PathVariable Integer id) {
        Revision revision = revisionService.findById(id);
        if (revision == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(revisionMapper.mappearDeRevisionARespuesta(revision));
    }

    @PostMapping("/revisiones")
    public ResponseEntity<RevisionDTO> crearRevision(@RequestBody RevisionDTO revisionDTO, @RequestParam Integer idUsuario) {
        Revision revision = revisionMapper.mappearDePeticion_Revision(revisionDTO);
        Revision revisionCreada = revisionService.save(revision, idUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(revisionMapper.mappearDeRevisionARespuesta(revisionCreada));
    }
    @PutMapping("/revisiones/{id}")
    public ResponseEntity<RevisionDTO> actualizarRevision(@PathVariable Integer id, @RequestBody RevisionDTO revisionDTO) {
        Revision revision = revisionMapper.mappearDePeticion_Revision(revisionDTO);
        Revision revisionActualizada = revisionService.update(id, revision);
        if (revisionActualizada != null) {
            return ResponseEntity.ok(revisionMapper.mappearDeRevisionARespuesta(revisionActualizada));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    /**
     * Elimina una revisión por ID.
     * @param id Identificador único de la revisión.
     * @return `true` si la revisión se eliminó, `false` si no se encontró.
     */
    @DeleteMapping("/revisiones/{id}")
    public ResponseEntity<Boolean> eliminarRevision(@PathVariable Integer id) {
        boolean eliminado = revisionService.delete(id);
        if (eliminado) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
    /**
     * Agrega un comentario a una revisión específica.
     * @param idRevision ID de la revisión.
     * @param comentario Comentario a agregar.
     * @param idUsuario ID del usuario que agrega el comentario.
     * @return `ResponseEntity` con la revisión actualizada o `NOT_FOUND` si la revisión no existe.
     */
    @PutMapping("revisiones/{idRevision}/comentario")
    public ResponseEntity<RevisionDTO> agregarComentario(@PathVariable Integer idRevision, @RequestBody String comentario, @RequestParam Integer idUsuario) {
        Revision revisionConComentario = revisionService.agregarComentario(idRevision, idUsuario, comentario);
        if (revisionConComentario != null) {
            return ResponseEntity.ok(revisionMapper.mappearDeRevisionARespuesta(revisionConComentario));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Actualiza el estado de una revisión específica.
     * @param idRevision ID de la revisión.
     * @param estado Nuevo estado a asignar.
     * @return `ResponseEntity` con la revisión actualizada o `NOT_FOUND` si la revisión no existe.
     */

    @PutMapping("revisiones/{id}/estado")
    public ResponseEntity<RevisionDTO> actualizarEstado(@PathVariable Integer id, @RequestBody String estado) {
        Revision revisionActualizada = revisionService.actualizarEstado(id, estado);
        if (revisionActualizada != null) {
            return ResponseEntity.ok(revisionMapper.mappearDeRevisionARespuesta(revisionActualizada));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
