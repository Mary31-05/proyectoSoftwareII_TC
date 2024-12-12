package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.services;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Servicio para la gestión de usuarios en el sistema.
 * 
 * La clase `UsuarioService` proporciona métodos para interactuar con el
 * servicio de usuarios, especialmente para la validación de roles de los
 * usuarios a través de una API externa.
 */
@Service
public class UsuarioService {

    private final String USUARIOS_API_URL = "http://api-rest-usuario:8050/api/usuarios/";
    private final RestTemplate restTemplate;

    public UsuarioService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public boolean validarPermisoCrearArticulo(Integer idUsuario) {
        String url = USUARIOS_API_URL + idUsuario + "/permisos";

        try {
            ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                List<String> permisos = response.getBody();
                return permisos.contains("CREAR_ARTICULO");
            }
        } catch (HttpClientErrorException e) {
            // Manejar el caso donde el usuario no existe o no tiene permisos
            System.out.println("Error al obtener permisos: " + e.getMessage());
        }

        return false;
    }
}
