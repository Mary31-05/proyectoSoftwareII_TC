package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.repositorios;

import java.util.List;

import co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.entidades.RevisionEntity;

public interface RevisionRepositoryInt {
    public List<RevisionEntity> findAll();

	public RevisionEntity save(RevisionEntity objRevision, Integer idUsuario);

	public RevisionEntity update(Integer id, RevisionEntity objRevision);

	public boolean delete(Integer id);

	public RevisionEntity agregarComentario(Integer idRevision, Integer idEvaluador, String comentario);

	public RevisionEntity actualizarEstado(Integer idRevision, String estado);

    public RevisionEntity findById(Integer idRevision);
}
