package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.repositorios;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.DTO.ConferenciaDTO;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.entidades.ArticuloEntity;


@Repository
public class ArticuloRepository implements ArticuloRepositoryInt {

    private ArrayList<ArticuloEntity> listaDeArticulos;

    public ArticuloRepository() {
        this.listaDeArticulos = new ArrayList<ArticuloEntity>();
        CargarArticulos();
    }
    /**
     * Obtiene la lista de todos los artículos.
     * @return Lista de ArticuloEntity.
     */

    @Override
    public List<ArticuloEntity> findAll() {
        System.out.println("Invocando a listar productos");
        return this.listaDeArticulos;
    }
    /**
     * Busca un artículo por su ID.
     * @param id Identificador del artículo.
     * @return ArticuloEntity si es encontrado, de lo contrario null.
     */
    @Override
    public ArticuloEntity findById(Integer id) {
        System.out.println("Invocando a consultar un Articulo");
        ArticuloEntity objArticulo = null;

        for (ArticuloEntity articulo : listaDeArticulos) {
            if (articulo.getId() == id) {
                objArticulo = articulo;
                break;
            }
        }

        return objArticulo;
    }
    /**
     * Verifica si existe un artículo en la lista por su ID.
     * @param id Identificador del artículo.
     * @return true si el artículo existe, false en caso contrario.
     */

    public boolean existeArticulo(Integer id) {
        for (ArticuloEntity articulo : listaDeArticulos) {
            if (articulo.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public ArticuloEntity exist(Integer id) {
        System.out.println("Invocando a consultar un Articulo");

        ArticuloEntity objArticulo = null;

        if (existeArticulo(id)) {
            for (ArticuloEntity articulo : listaDeArticulos) {
                if (articulo.getId().equals(id)) {
                    objArticulo = articulo;
                    break;
                }
            }
        } else {
            System.out.println("El artículo con ID " + id + " no fue encontrado.");
        }

        return objArticulo;
    }
    /**
     * Guarda un nuevo artículo en la lista.
     * @param articulo ArticuloEntity a ser guardado.
     * @return El artículo guardado si se agrega exitosamente, de lo contrario null.
     */

    @Override
    public ArticuloEntity save(ArticuloEntity articulo, Integer idUsuario) {
        System.out.println("Invocando a almacenar un articulo");
        ArticuloEntity objArticulo = null;
        if (this.listaDeArticulos.add(articulo)) {
            objArticulo = articulo;
        }

        return objArticulo;
    }
    /**
     * Actualiza un artículo existente en la lista.
     * @param id ID del artículo a actualizar.
     * @param articulo ArticuloEntity con los nuevos datos.
     * @return ArticuloEntity actualizado, o null si no se encontró el artículo.
     */
    @Override
    public ArticuloEntity update(Integer id, ArticuloEntity objArticulo) {
        System.out.println("Invocando a actualizar un producto");
        ArticuloEntity objArticuloR = null;

        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if (this.listaDeArticulos.get(i).getId() == id) {
                this.listaDeArticulos.set(i, objArticulo);
                objArticuloR = objArticulo;
                break;
            }
        }

        return objArticuloR;
        }

    /**
     * Elimina un artículo de la lista por su ID.
     * @param id Identificador del artículo a eliminar.
     * @return true si el artículo fue eliminado exitosamente, false si no se encontró.
     */

    @Override
    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar un articulo");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if (this.listaDeArticulos.get(i).getId() == id) {
                this.listaDeArticulos.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    /**
     * Método privado que carga algunos artículos de ejemplo.
     */
    private void CargarArticulos() {
        ArticuloEntity objArticulo1 = new ArticuloEntity(1, "IA en la actualidad", "Resumen del artículo sobre IA", "IA, Tecnología, Futuro", new ArrayList<>(), new ConferenciaDTO(1));
        this.listaDeArticulos.add(objArticulo1);

        ArticuloEntity objArticulo2 = new ArticuloEntity(2, "Ingeniería de software", "Resumen del artículo sobre ingeniería de software", "Software, Ingeniería, Desarrollo", new ArrayList<>(), new ConferenciaDTO(2));
        this.listaDeArticulos.add(objArticulo2);

        ArticuloEntity objArticulo3 = new ArticuloEntity(3, "Tecnología", "Resumen del artículo sobre tecnología", "Tecnología, Innovación", new ArrayList<>(), new ConferenciaDTO(3));
        this.listaDeArticulos.add(objArticulo3);
    }


}
