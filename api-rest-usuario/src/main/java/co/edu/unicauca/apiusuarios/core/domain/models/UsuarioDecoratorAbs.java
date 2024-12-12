package co.edu.unicauca.apiusuarios.core.domain.models;

import java.util.List;

public abstract class UsuarioDecoratorAbs implements IUsuarioEntity {

    protected IUsuarioEntity usuario;

    public UsuarioDecoratorAbs(IUsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public String getId() {
        return usuario.getId();
    }

    @Override
    public String getNombre() {
        return usuario.getNombre();
    }

    @Override
    public String getUser() {
        return usuario.getUser();
    }

    @Override
    public String getCorreo() {
        return usuario.getCorreo();
    }

    @Override
    public List<String> getPermisos() {
        return usuario.getPermisos();
    }

    @Override
    public String getRol() {
        return usuario.getRol();
    }


}
