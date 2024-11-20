package co.edu.unicauca.apiconferencias.core.aplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * DTO para representar la entidad Usuario en transferencias de datos.
 * Incluye el ID de usuario y un objeto RolDTO que define su rol en el sistema.
 */
@Getter @Setter @AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private RolDTO rol;
    /**
     * Constructor sin argumentos requerido para serialización/deserialización.
     */
    public UsuarioDTO() {

    }
}
