package co.edu.unicauca.apiusuarios.core.domain.models;

import java.util.List;

public class AutorDecorator extends UsuarioDecoratorAbs {

    public AutorDecorator(IUsuarioEntity usuario) {
        super(usuario);
    }

    @Override
    public List<String> getPermisos() {
        List<String> permisos = super.getPermisos();
        permisos.add("CREAR_ARTICULO");
        permisos.add("DELETE_ARTICULO");
        return permisos;
    }
    
}
