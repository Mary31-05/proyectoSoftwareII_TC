/**
 * Controlador REST para gestionar operaciones CRUD sobre usuarios.
 * Define endpoints para obtener, crear, actualizar, eliminar y verificar el rol de usuarios.
 * Utiliza el servicio IUsuarioService para realizar las operaciones necesarias.
 */
package co.edu.unicauca.apiusuarios.core.interfaces;

import co.edu.unicauca.apiusuarios.core.aplication.DTO.CRUDUsuariosDTO.UsuarioDTO;
import co.edu.unicauca.apiusuarios.core.aplication.DTO.UsuariosConConferenciasDTO.ConferenciaDTO;
import co.edu.unicauca.apiusuarios.core.aplication.services.IUsuarioService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/permisos")
    public String obtenerPermisos(@RequestParam Integer id) {
        return usuarioService.obtenerPermisosDeUsuario(id).toString();
    }

    @GetMapping("/{id}/permisos")
    public ResponseEntity<List<String>> obtenerPermisos2(@PathVariable Integer id) {
        List<String> permisos = usuarioService.obtenerPermisosDeUsuario(id);
        if (permisos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(permisos);
    }

    @GetMapping("/{id}/rol")
    public ResponseEntity<String> obtenerRol(@PathVariable Integer id) {
        String rol = usuarioService.obtenerRolPorId(id);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }


    /**
     * Crea un nuevo usuario.
     *
     * @param usuario Objeto UsuarioDTO a ser creado.
     * @return Objeto UsuarioDTO del usuario creado.
     */

    /*@PostMapping
    public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO objUsuario = null;
        try {
            objUsuario = usuarioService.save(usuario);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return objUsuario;
    }

    /**
     * Obtiene todos los usuarios.
     * @return Lista de usuarios (UsuarioDTO).
     */
    /*@GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.findAll();
    }

    /**
     * Lista las conferencias asociadas a un usuario.
     * @param idUsuario Identificador único del usuario.
     * @return Lista de conferencias (ConferenciaDTO) del usuario.
     */
    /*@GetMapping("/conferencias/{idUsuario}")
    public List<ConferenciaDTO> listarUsuarioConSusConferencias(@PathVariable Integer idUsuario) {
        return usuarioService.ListarConferenciasDeUsuario(idUsuario);
    }
    /**
     * Consulta un usuario por su ID.
     * @param id Identificador único del usuario.
     * @return Objeto UsuarioDTO si se encuentra el usuario, o null si no existe.
     */
    /*@GetMapping("/{id}")
    public UsuarioDTO consultarUsuario(@PathVariable Integer id) {
        UsuarioDTO objUsuario = null;
        objUsuario = usuarioService.findById(id);
        return objUsuario;
    }

    /**
     * Actualiza un usuario existente.
     * @param id Identificador del usuario a actualizar.
     * @param usuario Objeto UsuarioDTO con los nuevos datos.
     * @return El usuario actualizado, o null si no se encontró el usuario.
     */
    /*@PutMapping("/{id}")
    public UsuarioDTO actualizarUsuario(@RequestBody UsuarioDTO usuario, @PathVariable Integer id){
        UsuarioDTO objUsuario = null;
        UsuarioDTO usuarioActual = usuarioService.findById(id);
        if (usuarioActual != null)
            objUsuario = usuarioService.update(id, usuario);
        return objUsuario;
    }

    /**
     * Elimina un usuario por su ID.
     * @param id Identificador del usuario a eliminar.
     * @return true si el usuario fue eliminado, false si no se encontró el usuario.
     */
    /*@DeleteMapping("/{id}")
    public Boolean eliminarUsuario(@PathVariable Integer id) {
        Boolean bandera = false;
        UsuarioDTO usuarioActual = usuarioService.findById(id);
        if (usuarioActual != null)
            bandera = usuarioService.delete(id);
        return bandera;
    }

    /**
     * Valida si el usuario tiene un rol específico.
     * @param idUsuario Identificador único del usuario.
     * @param rol Nombre del rol a validar.
     * @return ResponseEntity con true si el usuario tiene el rol, false en caso contrario.
     */
    /*@GetMapping("/{idUsuario}/validarRol")
    public ResponseEntity<Boolean> validarRol(@PathVariable Integer idUsuario, @RequestParam String rol) {
        boolean validarRol = usuarioService.validarRol(idUsuario, rol);
        return ResponseEntity.ok(validarRol);
    }*/
}
