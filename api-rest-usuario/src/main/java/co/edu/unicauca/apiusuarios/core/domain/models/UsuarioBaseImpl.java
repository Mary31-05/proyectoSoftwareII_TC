package co.edu.unicauca.apiusuarios.core.domain.models;

import java.util.ArrayList;
import java.util.List;

public class UsuarioBaseImpl implements IUsuarioEntity {

    private String id;
    private String nombre;
    private String user;
    private String correo;
    private String rol;

    public UsuarioBaseImpl(){

    }

    public UsuarioBaseImpl(String id, String nombre,String user,String correo,String rol) {
        this.id = id;
        this.nombre = nombre;
        this.user = user;
        this.correo = correo;
        this.rol = rol;
    }

    @Override
    public String getId() {
        return id;
    }


    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getCorreo() {
        return correo;
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
