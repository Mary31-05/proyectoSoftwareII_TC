package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.repositorios;

import java.util.List;

import co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.entidades.ArticuloEntity;

public interface ArticuloRepositoryInt {

	public List<ArticuloEntity> findAll();

	public ArticuloEntity exist(Integer id);

	public ArticuloEntity save(ArticuloEntity objArticulo);
	/**
     * Actualiza la información de un artículo existente.
     * 
     * @param id Identificador del artículo a actualizar.
     * @param articulo Objeto `ArticuloDTO` que contiene la nueva información del artículo.
     * @return El objeto `ArticuloDTO` que representa el artículo actualizado.
     */
	public ArticuloEntity update(Integer id, ArticuloEntity articulo);
	/**
     * Elimina un artículo del sistema.
     * 
     * @param id Identificador del artículo a eliminar.
     * @return true si el artículo fue eliminado exitosamente, false en caso contrario.
     */
	public boolean delete(Integer id);

     public ArticuloEntity findById(Integer id);
}
