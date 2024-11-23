package co.edu.unicauca.api_rest_articulos.core.aplication.output;

import java.util.List;

import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Articulo;

public interface GestionarArticulo {
/**
     * Obtiene todos los artículos disponibles.
     * 
     * @return Lista de objetos `ArticuloDTO` que representan todos los artículos.
     */
	public List<Articulo> findAll();
	/**
     * Busca un artículo por su identificador.
     * 
     * @param id Identificador del artículo a buscar.
     * @return El objeto `ArticuloDTO` correspondiente al artículo encontrado, o null si no se encuentra.
     */
	/**
     * Verifica si un artículo existe por su identificador.
     * 
     * @param id Identificador del artículo a verificar.
     * @return El objeto `ArticuloDTO` correspondiente al artículo encontrado, o null si no se encuentra.
     */
	public Articulo exist(Integer id);
	 /**
     * Guarda un nuevo artículo en el sistema.
     * 
     * @param articulo Objeto `ArticuloDTO` que contiene la información del artículo a guardar.
     * @param idUsuario Identificador del usuario que está guardando el artículo.
     * @return El objeto `ArticuloDTO` que representa el artículo guardado, incluyendo su identificador.
     */
	public Articulo save(Articulo articulo, Integer idUsuario);
	/**
     * Actualiza la información de un artículo existente.
     * 
     * @param id Identificador del artículo a actualizar.
     * @param articulo Objeto `ArticuloDTO` que contiene la nueva información del artículo.
     * @return El objeto `ArticuloDTO` que representa el artículo actualizado.
     */
	public Articulo update(Integer id, Articulo articulo);
	/**
     * Elimina un artículo del sistema.
     * 
     * @param id Identificador del artículo a eliminar.
     * @return true si el artículo fue eliminado exitosamente, false en caso contrario.
     */
	public boolean delete(Integer id);

     public Articulo findById(Integer id);

}
