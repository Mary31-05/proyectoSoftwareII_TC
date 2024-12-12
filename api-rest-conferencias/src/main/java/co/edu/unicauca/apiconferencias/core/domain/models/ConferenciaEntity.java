package co.edu.unicauca.apiconferencias.core.domain.models;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConferenciaEntity {
    @Getter
    private Integer id;
    @Getter
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;
    @Getter
    private List<Integer> articulos;

    public ConferenciaEntity() {
    }

    private ConferenciaEntity(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.fechaInicio = builder.fechaInicio;
        this.fechaFin = builder.fechaFin;
        this.ubicacion = builder.ubicacion;
        this.articulos = builder.articulos;
    }



    // Builder estático
    public static class Builder {
        private Integer id;
        private String nombre;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;
        private String ubicacion;
        private List<Integer> articulos = new ArrayList<>();

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder withFechaInicio(LocalDate fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        public Builder withFechaFin(LocalDate fechaFin) {
            this.fechaFin = fechaFin;
            return this;
        }

        public Builder withUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
            return this;
        }

        public Builder withArticulos(List<Integer> articulos) {
            this.articulos = articulos;
            return this;
        }

        public ConferenciaEntity build() {
            return new ConferenciaEntity(this);
        }
    }
}
