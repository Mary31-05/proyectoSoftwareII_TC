package co.edu.unicauca.apiusuarios.core.infrastructure.persistence;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiusuarios.core.aplication.DTO.CRUDUsuariosDTO.UsuarioDTO;
import co.edu.unicauca.apiusuarios.core.aplication.services.IUsuarioService;
import co.edu.unicauca.apiusuarios.core.domain.models.OrganizadorDecorator;
import co.edu.unicauca.apiusuarios.core.domain.models.AutorDecorator;
import co.edu.unicauca.apiusuarios.core.domain.models.EvaluadorDecorator;
import co.edu.unicauca.apiusuarios.core.domain.models.IUsuarioEntity;

import co.edu.unicauca.apiusuarios.core.domain.repositories.UsuarioRepository;
/**
 * Implementación del servicio para la gestión de usuarios.
 * Esta clase proporciona métodos para realizar operaciones CRUD sobre los usuarios
 * y gestionar su relación con los roles y conferencias.
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {
   
    @Autowired
    private UsuarioRepository servicioAccesoBaseDatos;


    //private ConferenciasService servicioConsumirObtencionConferencias;

    @Autowired
    private ModelMapper modelMapper;
    /**
     * Obtiene todos los usuarios en formato DTO.
     *
     * @return Lista de objetos UsuarioDTO que representan los usuarios disponibles.
     */
    @Override
    public List<UsuarioDTO> findAll() {
        List<IUsuarioEntity> usuariosEntity = this.servicioAccesoBaseDatos.findAll();
        List<UsuarioDTO> usuariosDTO = this.modelMapper.map(usuariosEntity, new TypeToken<List<UsuarioDTO>>() {}.getType());
        return usuariosDTO;
    }
    /**
     * Busca un usuario por su ID y devuelve su representación en formato DTO.
     *
     * @param id Identificador del usuario a buscar.
     * @return UsuarioDTO que representa el usuario encontrado.
     */

    @Override
    public UsuarioDTO findById(Integer id) {
        return null;
        /*Optional objUsuarioEntity = this.servicioAccesoBaseDatos.findById(id);
        UsuarioDTO usuarioDTO = this.modelMapper.map(objUsuarioEntity, UsuarioDTO.class);
        return usuarioDTO;*/
    }
    /**
     * Guarda un nuevo usuario y devuelve su representación en formato DTO.
     *
     * @param usuario UsuarioDTO que representa el usuario a guardar.
     * @return UsuarioDTO que representa el usuario guardado.
     * @throws IllegalAccessException si el rol del usuario no es válido.
     */

    @Override
    public UsuarioDTO save(UsuarioDTO usuario) throws IllegalAccessException {
        // Validar si el rol existe}
        /*String rolId = usuario.getRol() != null ? usuario.getRol() : null;
        if (rolId == null)
            throw new IllegalAccessException("El rol no puede ser nulo");
        
        RolEntity rolEntity = this.servicioAccesoDatosRol.findById(rolId);
        if (rolEntity == null)
            throw new IllegalAccessException("El rol con ID " + rolId + " no existe");
        
        IUsuarioEntity usuarioEntity = this.modelMapper.map(usuario, IUsuarioEntity.class);
        usuarioEntity.setRol(rolEntity);
        IUsuarioEntity objUsuarioEntity = this.servicioAccesoBaseDatos.save(usuarioEntity);
        UsuarioDTO usuarioDTO = this.modelMapper.map(objUsuarioEntity, UsuarioDTO.class);
        return usuarioDTO;*/
        return null;
    }
    /**
     * Actualiza un usuario existente y devuelve su nueva representación en formato DTO.
     *
     * @param id Identificador del usuario a actualizar.
     * @param usuario UsuarioDTO que contiene los nuevos datos del usuario.
     * @return UsuarioDTO que representa el usuario actualizado.
     */
    @Override
    public UsuarioDTO update(Integer id, UsuarioDTO usuario) {
        /*IUsuarioEntity usuarioEntity = this.modelMapper.map(usuario, IUsuarioEntity.class);
        IUsuarioEntity objUsuarioEntity = this.servicioAccesoBaseDatos.update(id, usuarioEntity);
        UsuarioDTO usuarioDTO = this.modelMapper.map(objUsuarioEntity, UsuarioDTO.class);
        return usuarioDTO;*/
        return null;
    }
    /**
     * Elimina un usuario por su ID.
     *
     * @param id Identificador del usuario a eliminar.
     * @return true si se eliminó con éxito, false en caso contrario.
     */
    @Override
    public boolean delete(Integer id) {
        return false;//return this.servicioAccesoBaseDatos.delete(id);
    }

    /*@Override
    public List<ConferenciaDTO> ListarConferenciasDeUsuario(Integer idUsuario) {
        List<ConferenciaDTO> listaConferenciasDelUsuario;
        listaConferenciasDelUsuario = this.servicioConsumirObtencionConferencias.obtenerConferenciasDeUsuario(idUsuario);
        return listaConferenciasDelUsuario;
    }*/
    @Override
    public String obtenerRolPorId(Integer id) {
        return null;
        /*return servicioAccesoBaseDatos.findById(id)
                .map(IUsuarioEntity::getRol) // Obtiene el rol del usuario si existe
                .orElse(null);       // Retorna null si el usuario no está en la lista/* */
    }
    @Override
    public List<String> obtenerPermisosDeUsuario(Integer id) {
        return null;
        // Buscar el usuario en el repositorio por su ID
        /*IUsuarioEntity usuarioBase = servicioAccesoBaseDatos.findById(id)
            .map(usuario -> new UsuarioBaseImpl(
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getCorreo(),
                    usuario.getPassword(),
                    usuario.getRol()
            ))
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Decorar según el rol
        IUsuarioEntity usuarioDecorado = switch (usuarioBase.getRol()) {
            case "ORGANIZADOR" -> new OrganizadorDecorator(usuarioBase);
            case "AUTOR" -> new AutorDecorator(usuarioBase);
            case "EVALUADOR" -> new EvaluadorDecorator(usuarioBase);
            default -> usuarioBase; // Usuario básico sin decoradores adicionales
        };

        return usuarioDecorado.getPermisos();*/
    }

    @Override
    public boolean puedeRealizarAccion(IUsuarioEntity usuario, String accion) {
        List<String> permisos = usuario.getPermisos();
        return permisos.contains(accion); // Valida si tiene el permiso específico
    }
    @Override
    public IUsuarioEntity decorarUsuario(IUsuarioEntity usuario) {
        // Obtener el rol del usuario
        String rol = usuario.getRol();

        // Decorar el usuario según el rol
        switch (rol) {
            case "AUTOR":
                return new AutorDecorator(usuario);
            case "ORGANIZADOR":
                return new OrganizadorDecorator(usuario);
            case "EVALUADOR":
                return new EvaluadorDecorator(usuario);
            // Añadir más casos según los roles que necesites
            default:
                return usuario; // Usuario sin decoración, si no coincide con ningún rol
        }
    }
    
    
}
