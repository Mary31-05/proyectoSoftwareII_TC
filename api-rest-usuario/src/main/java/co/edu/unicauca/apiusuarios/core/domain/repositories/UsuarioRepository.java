/**
 * Repositorio de usuarios que permite realizar operaciones CRUD sobre una lista
 * de usuarios almacenados en memoria. Simula el comportamiento de un repositorio 
 * persistente al almacenar usuarios en una lista de tipo ArrayList.
 * 
 * Este repositorio es administrado por Spring y utiliza la anotación @Repository.
 */
package co.edu.unicauca.apiusuarios.core.domain.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiusuarios.core.domain.models.UsuarioBaseImpl;
import co.edu.unicauca.apiusuarios.core.domain.models.IUsuarioEntity;

@Repository
public class UsuarioRepository {

    private ArrayList<IUsuarioEntity> listaDeUsuarios;
    /**
     * Constructor de UsuarioRepository.
     * Inicializa la lista de usuarios y carga usuarios predeterminados.
     */
    public UsuarioRepository(){
        this.listaDeUsuarios = new ArrayList<IUsuarioEntity>();
        cargarUsuarios();
    }
    /**
     * Obtiene todos los usuarios almacenados en el repositorio.
     * 
     * @return Lista de usuarios de tipo UsuarioEntity.
     */
    public List<IUsuarioEntity> findAll(){
        System.out.println("Invocando a listarusuarios");
        return this.listaDeUsuarios;
    }
    /**
     * Almacena un nuevo usuario en el repositorio.
     * 
     * @param usuario Objeto UsuarioEntity a almacenar.
     * @return El usuario almacenado, o null si no se pudo agregar.
     */
    public IUsuarioEntity save(IUsuarioEntity usuario){
        System.out.println("Invocando a almacenar usuario");
        IUsuarioEntity objUsuario = null;
        if (this.listaDeUsuarios.add(usuario))
            objUsuario = usuario;
        return objUsuario;
    }
    /**
     * Busca un usuario en el repositorio por su ID.
     * 
     * @param id Identificador único del usuario.
     * @return Objeto UsuarioEntity si se encuentra el usuario, o null si no existe.
     */
    // Método para buscar un usuario por ID
    public Optional<IUsuarioEntity> findById(Integer id) {
        return listaDeUsuarios.stream()
                .filter(Iusuario -> Iusuario.getId().equals(id)) // Compara por ID
                .findFirst();
    }
    /**
     * Actualiza un usuario existente en el repositorio.
     * 
     * @param id      Identificador del usuario a actualizar.
     * @param usuario Objeto UsuarioEntity con la información actualizada.
     * @return El usuario actualizado, o null si el usuario no se encontró.
     */
    public IUsuarioEntity update(Integer id, IUsuarioEntity usuario){
        System.out.println("Invocando a actualizar un usuario");
        IUsuarioEntity objUsuario = null;

        for (int i = 0; i < this.listaDeUsuarios.size(); i++){
            if (this.listaDeUsuarios.get(i).getId() == id){
                this.listaDeUsuarios.set(i, usuario);
                objUsuario = usuario;
                break;
            }
        }
        return objUsuario;
    }
    /**
     * Elimina un usuario del repositorio por su ID.
     * 
     * @param id Identificador del usuario a eliminar.
     * @return true si el usuario fue eliminado, false si no se encontró.
     */

    public boolean delete(Integer id){
        System.out.println("Invocando a eliminar un usuario");
        boolean bandera = false;

        for (int i = 0; i < listaDeUsuarios.size(); i++){
            if (this.listaDeUsuarios.get(i).getId() == id){
                this.listaDeUsuarios.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    /**
     * Carga una lista de usuarios predeterminados en el repositorio.
     * Este método es llamado durante la inicialización para simular datos iniciales en el sistema.
     */

    private void cargarUsuarios() {

        listaDeUsuarios.add(new UsuarioBaseImpl(1, "Juan", "Pérez", "juan.perez@example.com", "1234", "ORGANIZADOR"));

        listaDeUsuarios.add(new UsuarioBaseImpl(2, "Ana", "Gómez", "ana.gomez@example.com", "1234", "AUTOR"));

        listaDeUsuarios.add(new UsuarioBaseImpl(3, "Luis", "Martínez", "luis.martinez@example.com", "1234", "EVALUADOR"));

        /*IUsuarioEntity usuario1 = new IUsuarioEntity(1, "Juan", "Pérez", "juan.perez@example.com", "contraseña1", new RolEntity(1, "ORGANIZADOR"));
        this.listaDeUsuarios.add(usuario1);

        IUsuarioEntity usuario2 = new IUsuarioEntity(2, "Ana", "Gómez", "ana.gomez@example.com", "contraseña2", new RolEntity(2, "EVALUADOR"));
        this.listaDeUsuarios.add(usuario2);

        IUsuarioEntity usuario3 = new IUsuarioEntity(3, "Luis", "Martínez", "luis.martinez@example.com", "contraseña3", new RolEntity(3, "AUTOR"));
        this.listaDeUsuarios.add(usuario3);

        IUsuarioEntity usuario4 = new IUsuarioEntity(4, "María", "Hernández", "maria.hernandez@example.com", "contraseña4", new RolEntity(4, "PARTICIPANTE"));
        this.listaDeUsuarios.add(usuario4);    */   
    }
}