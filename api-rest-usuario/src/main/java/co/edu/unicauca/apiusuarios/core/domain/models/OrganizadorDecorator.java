package co.edu.unicauca.apiusuarios.core.domain.models;

import java.util.List;

public class OrganizadorDecorator extends UsuarioDecoratorAbs {

    public OrganizadorDecorator(IUsuarioEntity usuario) {
        super(usuario);
    }

    @Override
    public List<String> getPermisos() {
        List<String> permisos = super.getPermisos();
        permisos.add("CREAR_CONFERENCIA");
        permisos.add("DELETE_CONFERENCIA");
        return permisos;
    }

}
