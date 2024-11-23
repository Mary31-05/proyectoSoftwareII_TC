package co.edu.unicauca.api_rest_articulos.core.infrastructure.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RevisionMapper {
    @Bean
    @Qualifier("crearRevisionMapper")
    public ModelMapper crearRevisionMapper() {
        return new ModelMapper();
    }
}
