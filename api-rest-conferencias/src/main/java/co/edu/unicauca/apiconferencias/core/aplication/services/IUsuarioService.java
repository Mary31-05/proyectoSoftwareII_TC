package co.edu.unicauca.apiconferencias.core.aplication.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(
        name = "usuario-service",
        url = "http://localhost:8050/api/usuarios"
)
public interface IUsuarioService {

    @GetMapping("/{idUsuario}/validarRol")
    Optional<Boolean> validarRol(@PathVariable("idUsuario") Integer idUsuario, @RequestParam String rol);
}
