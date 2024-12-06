package co.edu.unicauca.apiusuarios.core.domain.models;

import java.util.List;

public abstract class UsuarioDecoratorAbs implements IUsuarioEntity {

    protected IUsuarioEntity usuario;

    public UsuarioDecoratorAbs(IUsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getNombre() {
        return usuario.getNombre();
    }

    @Override
    public String getApellido() {
        return usuario.getApellido();
    }

    @Override
    public String getCorreo() {
        return usuario.getCorreo();
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public List<String> getPermisos() {
        return usuario.getPermisos();
    }

    @Override
    public String getRol() {
        return usuario.getRol();
    }

    @Override
    public Integer getId() {
        return usuario.getId();
    }
}
