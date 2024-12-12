package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.services;

import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

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

    public boolean validarPermisoCrearArticulo(String token) {
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
            if (permisos != null && permisos.contains("CREAR_ARTICULO")) {
                return true; // El usuario tiene permiso
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al validar permisos: " + e.getMessage());
        }

        return false; // No tiene permiso
    }

}
