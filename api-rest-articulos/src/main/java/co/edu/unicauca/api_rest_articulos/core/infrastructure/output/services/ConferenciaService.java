package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.api_rest_articulos.core.aplication.output.ConsultaUsuarioInt;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.DTO.UsuarioDTO;


/**
 * Servicio para gestionar operaciones relacionadas con conferencias.
 * 
 * La clase `ConferenciaService` proporciona métodos para validar roles de usuario mediante
 * comunicación con un servicio externo a través de `WebClient`. Esta clase permite verificar si
 * un usuario tiene un rol específico necesario para realizar acciones en el contexto de conferencias.
 */

 // se implementa la interfaz
@Service
public class ConferenciaService implements ConsultaUsuarioInt{
    @Autowired
    private WebClient.Builder webClientBuilder;

    public boolean validarRol(Integer idUsuario, String rol) {
        String url = "http://localhost:8080/api/usuarios/" + idUsuario;

        UsuarioDTO usuarioDTO = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(UsuarioDTO.class)
                .block();

        return usuarioDTO != null && usuarioDTO.getRol().getNombre().equals(rol);
    }
}
