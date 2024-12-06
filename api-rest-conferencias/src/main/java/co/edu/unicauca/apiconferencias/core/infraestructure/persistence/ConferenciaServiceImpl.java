package co.edu.unicauca.apiconferencias.core.infraestructure.persistence;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiconferencias.core.aplication.DTO.ConferenciaDTO;
import co.edu.unicauca.apiconferencias.core.aplication.services.IConferenciaService;
import co.edu.unicauca.apiconferencias.core.aplication.services.UsuariosService;
import co.edu.unicauca.apiconferencias.core.domain.models.ConferenciaEntity;
import co.edu.unicauca.apiconferencias.core.domain.repositories.ConferenciaRepository;

@Service
public class ConferenciaServiceImpl implements IConferenciaService {

    @Autowired
    private ConferenciaRepository servicioAccesoBaseDatos;

    @Autowired
    private UsuariosService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ConferenciaDTO> findAll() {
        List<ConferenciaEntity> ConferenciaEntity = this.servicioAccesoBaseDatos.findAll();
        List<ConferenciaDTO> conferenciaDTO = this.modelMapper.map(ConferenciaEntity, new TypeToken<List<ConferenciaDTO>>() {
        }.getType());
        return conferenciaDTO;
    }

    @Override
    public ConferenciaDTO findById(Integer id) {
        ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.findById(id);
        ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
        return conferenciaDTO;
    }

    @Override
    public ConferenciaDTO save(ConferenciaDTO conferencia, Integer idUsuario) {
        // Validar rol del usuario
        if (!usuarioService.validarPermisoCrearConferencia(idUsuario)) {
            throw new RuntimeException("El usuario no tiene permisos para crear conferencias");
        }
        ConferenciaEntity conferenciaEntity = this.modelMapper.map(conferencia, ConferenciaEntity.class);
		ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.save(conferenciaEntity);
		ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
		return conferenciaDTO;
    }

    @Override
    public ConferenciaDTO update(Integer id, ConferenciaDTO conferencia) {
        ConferenciaEntity objConferenciaEntity = this.modelMapper.map(conferencia, ConferenciaEntity.class);
        objConferenciaEntity = this.servicioAccesoBaseDatos.update(id, objConferenciaEntity);
        ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
        return conferenciaDTO;
    }

    @Override
    public ConferenciaDTO agregarArticulo(Integer id, Integer idArticulo) {
        ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.agregarArticulo(id, idArticulo);
        ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
        return conferenciaDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
}
