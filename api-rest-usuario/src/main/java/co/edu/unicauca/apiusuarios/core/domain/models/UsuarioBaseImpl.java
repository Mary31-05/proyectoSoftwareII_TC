package co.edu.unicauca.apiusuarios.core.domain.models;

import java.util.ArrayList;
import java.util.List;

public class UsuarioBaseImpl implements IUsuarioEntity {

    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String rol;

    public UsuarioBaseImpl(Integer id,String nombre,String apellido,String correo, String password,String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    @Override
    public Integer getId() {
       return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getRol() {
        return rol;
    }

    @Override
    public List<String> getPermisos() {
        return new ArrayList<>();
    }
    
}
