package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.gateway;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.api_rest_articulos.core.aplication.output.GestionarArticulo;
import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Articulo;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.entidades.ArticuloEntity;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.repositorios.ArticuloRepository;

@Service
public class GestionarArticuloGateway implements GestionarArticulo{

    private final ArticuloRepository objArticuloRepository;
    private final ModelMapper articuloModelMapper;

    public GestionarArticuloGateway(ArticuloRepository objArticuloRepository, @Qualifier("crearArticuloMapper") ModelMapper articuloModelMapper) {
        this.objArticuloRepository = objArticuloRepository;
        this.articuloModelMapper = articuloModelMapper;
    }
    @Override
    public List<Articulo> findAll() {
        List<ArticuloEntity> lista = this.objArticuloRepository.findAll();
        List<Articulo> listaObtenida = this.articuloModelMapper.map(lista, new TypeToken<List<Articulo>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public Articulo save(Articulo articulo, Integer idUsuario) {
        ArticuloEntity objArticuloEntity = this.articuloModelMapper.map(articulo, ArticuloEntity.class);
        ArticuloEntity objArticuloEntityRegistrado = this.objArticuloRepository.save(objArticuloEntity, idUsuario);
        return this.articuloModelMapper.map(objArticuloEntityRegistrado, Articulo.class);
    }
    

    @Override
    public Articulo update(Integer id, Articulo articulo) {
        ArticuloEntity objArticuloEntity = this.articuloModelMapper.map(articulo, ArticuloEntity.class);
        ArticuloEntity objArticuloEntityActualizado = this.objArticuloRepository.save(objArticuloEntity, id);
        return this.articuloModelMapper.map(objArticuloEntityActualizado, Articulo.class);
    }

    @Override
    public boolean delete(Integer id) {
        if (this.objArticuloRepository.existeArticulo(id)){

            this.objArticuloRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Articulo exist(Integer id) {
        ArticuloEntity objArticuloEntity = this.objArticuloRepository.exist(id);
        return this.articuloModelMapper.map(objArticuloEntity, Articulo.class);
    }
    @Override
    public Articulo findById(Integer id) {
        ArticuloEntity objArticuloEntity = this.objArticuloRepository.findById(id);
        return this.articuloModelMapper.map(objArticuloEntity, Articulo.class);
    }
}
