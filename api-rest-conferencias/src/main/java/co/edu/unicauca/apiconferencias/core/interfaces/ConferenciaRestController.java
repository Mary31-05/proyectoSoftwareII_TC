package co.edu.unicauca.apiconferencias.core.interfaces;

import co.edu.unicauca.apiconferencias.core.aplication.DTO.ConferenciaDTO;
import co.edu.unicauca.apiconferencias.core.aplication.services.IConferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar conferencias.
 * Permite realizar operaciones CRUD sobre conferencias a través de una API REST.
 */
@RestController
@RequestMapping("/api/conferencias")
@RequiredArgsConstructor
public class ConferenciaRestController {

    @Autowired
	private IConferenciaService ConferenciaService;
    /**
     * Endpoint para listar todas las conferencias.
     *
     * @return Lista de objetos ConferenciaDTO que representan todas las conferencias.
     */
    @GetMapping
    public List<ConferenciaDTO> listarConferencias() {
		return ConferenciaService.findAll();
    }

    /**
     * Endpoint para consultar una conferencia específica por su ID.
     *
     * @param id Identificador de la conferencia a consultar.
     * @return Objeto ConferenciaDTO que representa la conferencia encontrada.
     */
    @GetMapping("/{id}")
	public ConferenciaDTO consultarConferencia(@PathVariable Integer id) {
		ConferenciaDTO objConferencia = null;
		objConferencia = ConferenciaService.findById(id);
		return objConferencia;
	}

    /**
     * Endpoint para crear una nueva conferencia.
     *
     * @param conferencia Objeto ConferenciaDTO con los datos de la conferencia a crear
     * @return Objeto ConferenciaDTO que representa la conferencia creada.
     */
    @PostMapping
    public ConferenciaDTO crearConferencia(@RequestBody ConferenciaDTO conferencia, @RequestHeader("Authorization") String authorizationHeader) {
        // Extraer el Bearer Token del encabezado Authorization
        String token = authorizationHeader.replace("Bearer ", "");

        // Ahora pasa el token al servicio
        ConferenciaDTO objConferencia = ConferenciaService.save(conferencia, token);

        return objConferencia;
    }

    /**
     * Endpoint para actualizar una conferencia existente.
     *
     * @param id Identificador de la conferencia a actualizar.
     * @param conferencia Objeto ConferenciaDTO con los datos actualizados de la conferencia.
     * @return Respuesta HTTP con el objeto ConferenciaDTO actualizado y estado OK, o NOT_FOUND si la conferencia no existe.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ConferenciaDTO> actualizarConferencia(@PathVariable Integer id, @RequestBody ConferenciaDTO conferencia) {
        ConferenciaDTO actualizado = ConferenciaService.update(id, conferencia);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Endpoint para agregar un artículo a una conferencia específica.
     *
     * @param idConferencia Identificador de la conferencia.
     * @param idArticulo Identificador del artículo a agregar.
     * @return Respuesta HTTP con el objeto ConferenciaDTO actualizado y estado OK, o NOT_FOUND si la conferencia no existe.
     */
    @PutMapping("/{idConferencia}/articulo")
    public ResponseEntity<ConferenciaDTO> agregarArticulo(@PathVariable Integer idConferencia, @RequestBody Integer idArticulo) {
        ConferenciaDTO actualizado = ConferenciaService.agregarArticulo(idConferencia, idArticulo);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Endpoint para eliminar una conferencia.
     *
     * @param id Identificador de la conferencia a eliminar.
     * @return Respuesta HTTP con true si se eliminó con éxito y estado OK, o false y NOT_FOUND si la conferencia no existe.
     */  
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarConferencia(@PathVariable Integer id) {
        ConferenciaDTO ConferenciaActual = ConferenciaService.findById(id);
        if (ConferenciaActual != null) {
            Boolean eliminado = ConferenciaService.delete(id);
            return ResponseEntity.ok(eliminado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}


