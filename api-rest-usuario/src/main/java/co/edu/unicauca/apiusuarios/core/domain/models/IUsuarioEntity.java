/**
 * Representa la entidad de un usuario en el sistema, la cual contiene información
 * relevante para la autenticación y autorización del usuario.
 * Incluye detalles como su nombre, apellido, correo electrónico, contraseña y el rol asociado.
 */
package co.edu.unicauca.apiusuarios.core.domain.models;

import java.util.List;
/**
 * Clase UsuarioEntity
 * Define la estructura de datos para un usuario.
 * 
 * Atributos:
 * - id: Identificador único del usuario.
 * - nombre: Nombre del usuario.
 * - apellido: Apellido del usuario.
 * - correo: Correo electrónico del usuario.
 * - password: Contraseña del usuario.
 * - rol: Rol asignado al usuario en el sistema (asociación con RolEntity).
 * 
 * Constructor:
 * - UsuarioEntity(): Constructor por defecto.
 */

public interface IUsuarioEntity {
    String getId();
    String getNombre();
    String getUser();
    String getCorreo();
    String getRol();
    List<String> getPermisos();

}
