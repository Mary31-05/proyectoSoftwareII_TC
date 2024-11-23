package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.api_rest_articulos.core.aplication.output.GestionarRevision;
import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Revision;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.entidades.RevisionEntity;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.repositorios.RevisionRepository;

@Service
public class GestionarRevisionGateway implements GestionarRevision {

    private final RevisionRepository objRevisionRepository;
    private final ModelMapper revisionModelMapper;

    public GestionarRevisionGateway(RevisionRepository objRevisionRepository, @Qualifier("crearRevisionMapper") ModelMapper revisionModelMapper) {
        this.objRevisionRepository = objRevisionRepository;
        this.revisionModelMapper = revisionModelMapper;
    }

    @Override
    public List<Revision> findAll() {
        List<RevisionEntity> lista = this.objRevisionRepository.findAll();
        return this.revisionModelMapper.map(lista, new TypeToken<List<Revision>>() {}.getType());
    }

    @Override
    public Revision save(Revision revision, Integer idUsuario) {
        RevisionEntity objRevisionEntity = this.revisionModelMapper.map(revision, RevisionEntity.class);
        RevisionEntity objRevisionEntityRegistrado = this.objRevisionRepository.save(objRevisionEntity, idUsuario);
        return this.revisionModelMapper.map(objRevisionEntityRegistrado, Revision.class);
    }

    @Override
    public Revision update(Integer id, Revision Revision) {
        RevisionEntity revisionEntity = this.revisionModelMapper.map(Revision, RevisionEntity.class);
        RevisionEntity revisionEntityUpdated = this.objRevisionRepository.update(id, revisionEntity);
        return this.revisionModelMapper.map(revisionEntityUpdated, Revision.class);
    }

    @Override
    public boolean delete(Integer id) {
        return this.objRevisionRepository.delete(id);
    }

    @Override
    public Revision agregarComentario(Integer idRevision, Integer idEvaluador, String comentario) {
        RevisionEntity revisionEntity = this.objRevisionRepository.agregarComentario(idRevision, idEvaluador, comentario);
        if (revisionEntity != null) {
            return this.revisionModelMapper.map(revisionEntity, Revision.class);
        }
        return null;
    }

    @Override
    public Revision actualizarEstado(Integer idRevision, String estado) {
        RevisionEntity revisionEntity = this.objRevisionRepository.actualizarEstado(idRevision, estado);
        if (revisionEntity != null) {
            return this.revisionModelMapper.map(revisionEntity, Revision.class);
        }
        return null;
    }
    

    @Override
    public Revision findById(Integer idRevision) {
        RevisionEntity revisionEntity = this.objRevisionRepository.findById(idRevision);
        if (revisionEntity != null) {
            return this.revisionModelMapper.map(revisionEntity, Revision.class);
        }
        return null;
    }   

}
