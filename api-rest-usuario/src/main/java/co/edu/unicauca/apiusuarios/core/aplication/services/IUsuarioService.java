/**
 * Interface que define los métodos para gestionar usuarios y sus conferencias.
 * Proporciona operaciones CRUD y métodos adicionales para el manejo de usuarios.
 */
package co.edu.unicauca.apiusuarios.core.aplication.services;

import java.util.List;

import co.edu.unicauca.apiusuarios.core.aplication.DTO.CRUDUsuariosDTO.UsuarioDTO;
import co.edu.unicauca.apiusuarios.core.aplication.DTO.UsuariosConConferenciasDTO.ConferenciaDTO;
import co.edu.unicauca.apiusuarios.core.domain.models.IUsuarioEntity;

public interface IUsuarioService {
    /**
     * Obtiene todos los usuarios registrados en el sistema.
     *
     * @return Lista de todos los objetos UsuarioDTO.
     */
    public List<UsuarioDTO> findAll();
    /**
     * Busca un usuario por su ID.
     *
     * @param id ID del usuario a buscar.
     * @return Objeto UsuarioDTO si se encuentra, de lo contrario null.
     */
    public UsuarioDTO findById(Integer id);
    /**
     * Almacena un nuevo usuario en el sistema.
     *
     * @param usuario Objeto UsuarioDTO a almacenar.
     * @return Objeto UsuarioDTO guardado.
     * @throws IllegalAccessException si ocurren problemas de acceso durante la operación.
     */
    public UsuarioDTO save(UsuarioDTO usuario) throws IllegalAccessException;
    /**
     * Actualiza un usuario existente identificado por su ID.
     *
     * @param id ID del usuario a actualizar.
     * @param usuario Objeto UsuarioDTO con la información actualizada.
     * @return Objeto UsuarioDTO actualizado.
     */
    public UsuarioDTO update(Integer id, UsuarioDTO usuario);
    /**
     * Elimina un usuario del sistema identificado por su ID.
     *
     * @param id ID del usuario a eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    public boolean delete(Integer id);

    //public List<ConferenciaDTO> ListarConferenciasDeUsuario(Integer idUsuario);
    

    //public boolean validarRol(Integer idUsuario, String rol);

    public String obtenerRolPorId(Integer id);

    public List<String> obtenerPermisosDeUsuario(Integer id);

    public boolean puedeRealizarAccion(IUsuarioEntity usuario, String accion);
    public IUsuarioEntity decorarUsuario(IUsuarioEntity usuario);
    
}

