package co.edu.unicauca.apiconferencias.core.aplication.services;


import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



/**
 * Servicio que se encarga de realizar operaciones relacionadas con los usuarios.
 * Esta clase interactúa con un microservicio de usuarios a través de llamadas HTTP.
 */
@Service
public class UsuariosService {
    
    private final String USUARIOS_API_URL = "http://localhost:8050/api/usuarios/";
    private final RestTemplate restTemplate;

    public UsuariosService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public boolean validarPermisoCrearConferencia(Integer idUsuario) {
        String url = USUARIOS_API_URL + idUsuario + "/permisos";

        try {
            ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                List<String> permisos = response.getBody();
                return permisos.contains("CREAR_CONFERENCIA");
            }
        } catch (HttpClientErrorException e) {
            // Manejar el caso donde el usuario no existe o no tiene permisos
            System.out.println("Error al obtener permisos: " + e.getMessage());
        }

        return false;
    }
}
