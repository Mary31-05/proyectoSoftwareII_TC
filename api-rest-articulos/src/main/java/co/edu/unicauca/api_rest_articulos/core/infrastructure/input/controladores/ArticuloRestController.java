package co.edu.unicauca.api_rest_articulos.core.infrastructure.input.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.api_rest_articulos.core.aplication.input.IArticuloService;
import co.edu.unicauca.api_rest_articulos.core.domain.modelos.Articulo;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.DTO.ArticuloDTO;
import co.edu.unicauca.api_rest_articulos.core.infrastructure.input.mappers.ArticuloMapper_Dom;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping ("/api")

public class ArticuloRestController {
    private final IArticuloService articuloService;
    private final ArticuloMapper_Dom articuloMapper;

    public ArticuloRestController(IArticuloService articuloService, ArticuloMapper_Dom articuloMapper) {
        this.articuloService = articuloService;
        this.articuloMapper = articuloMapper;
    }

	@GetMapping("/")
    public String home() {
        return "Bienvenido a la API de Artículos!";
    }
     /**
     * Lista todos los artículos disponibles.
     * @return Lista de `ArticuloDTO` que representa todos los artículos.
     */
	
    @GetMapping("/articulos")
    public List<Articulo> listarArticulos() {
        return articuloMapper.mappearDeArticulosARespuesta(this.articuloService.findAll());
    }

    @GetMapping("/articulos/{id}")
    public ResponseEntity<ArticuloDTO> consultarArticulo(@PathVariable Integer id) {
        Articulo articulo = articuloService.findById(id);
        if (articulo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(articuloMapper.mappearDeArticuloARespuesta(articulo));
    }

    @PostMapping("/articulos")
    public Articulo crearArticulo(@RequestBody ArticuloDTO articuloDTO, @RequestHeader("Authorization") String authorizationHeader) {
        // Extraer el Bearer Token del encabezado Authorization
        String token = authorizationHeader.replace("Bearer ", "");

        
        Articulo articulo = articuloMapper.mappearDePeticion_Articulo(articuloDTO);
        Articulo articuloCreado = articuloService.save(articulo, token);
        
        return articuloCreado;
    }
     /**
     * Actualiza la información de un artículo existente.
     * @param id Identificador único del artículo.
     * @param articulo Objeto `ArticuloDTO` con la nueva información.
     * @return `ResponseEntity` con el artículo actualizado o `NOT_FOUND` si el artículo no existe.
     */
    @PutMapping("/articulos/{id}")
    public ResponseEntity<ArticuloDTO> actualizarArticulo(@PathVariable Integer id, @RequestBody ArticuloDTO articuloDTO) {
        Articulo articulo = articuloMapper.mappearDePeticion_Articulo(articuloDTO);
        Articulo articuloActualizado = articuloService.update(id, articulo);
        if (articuloActualizado != null) {
            return ResponseEntity.ok(articuloMapper.mappearDeArticuloARespuesta(articuloActualizado));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
  
     @DeleteMapping("/articulos/{id}")
     public ResponseEntity<Boolean> eliminarArticulo(@PathVariable Integer id) {
         boolean eliminado = articuloService.delete(id);
         if (eliminado) {
             return ResponseEntity.ok(true);
         } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
         }
     }
    @GetMapping("/articulos/exist/{id}")
    public Boolean existeArticulo(@PathVariable Integer id) {
        return articuloService.exist(id) != null;
    }
}
