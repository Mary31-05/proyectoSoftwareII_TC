package co.edu.unicauca.apiconferencias.core.aplication.services;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Servicio que se encarga de realizar operaciones relacionadas con los
 * usuarios.
 * Esta clase interactúa con un microservicio de usuarios a través de llamadas
 * HTTP.
 */
@Service
public class UsuariosService {

    private final String USUARIOS_API_URL = "http://api-rest-usuario:8050/api/usuarios/";
    private final RestTemplate restTemplate;

    public UsuariosService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public boolean validarPermisoCrearConferencia(String token) {
        // Configurar el encabezado Authorization con el Bearer token
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        // Crear la entidad HTTP con los encabezados
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            // Realizar la llamada GET al endpoint /permisos
            ResponseEntity<List> response = restTemplate.exchange(
                    USUARIOS_API_URL + "/permisos", // URL de tu API
                    HttpMethod.GET,
                    entity,
                    List.class);

            // Verificar la respuesta
            List<String> permisos = response.getBody();
            if (permisos != null && permisos.contains("LISTAR_CONFERENCIA")) {
                return true; // El usuario tiene permiso
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al validar permisos: " + e.getMessage());
        }

        return false; // No tiene permiso
    }
}
