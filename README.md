# Proyecto con Docker Compose

Este proyecto contiene un conjunto de microservicios desplegados mediante Docker Compose. A continuación, se presentan las instrucciones para clonar el repositorio, construir las imágenes y ejecutar los servicios.

---

## Documentación y protocolo de sustentación

- **Video del protocolo de sustentación**: [Video en YouTube](<URL_VIDEO>)

---
## Estructura del proyecto

Este proyecto cuenta con dos ramas:

- **Rama `main (principal)`**: Contiene la configuración para ejecutar los servicios utilizando Docker Compose.
- **Rama `test`**: Permite ejecutar los microservicios individualmente sin Docker desde la consola.

---

## Pasos para la ejecución

### En la rama `main`

#### 1. Clonar el repositorio

Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/Mary31-05/proyectoSoftwareII_TC.git
cd proyectoSoftwareII_TC.git
git checkout main
```

#### 2. Construir y ejecutar los servicios con Docker Compose

Ejecuta el siguiente comando para construir las imágenes y levantar los servicios definidos en el archivo `docker-compose.yml`:

```bash
docker-compose up --build
```

#### Nota sobre Keycloak

Actualmente, existen problemas para acceder a Keycloak desde esta configuración en Docker. Este problema está siendo investigado, y se recomienda usar la rama `test` si necesitas ejecutar el sistema sin Docker.

---

### En la rama `test`

#### 1. Cambiar a la rama `test`

```bash
git checkout test
```

#### 2. Ejecutar los servicios manualmente

Sigue el orden especificado para iniciar cada servicio desde la consola:

1. **Iniciar Keycloak**:
   ```bash
   keycloak-26.0.7\bin\kc.bat start-dev
   ```

2. **Ejecutar `api-config-server`**:
   ```bash
   cd api-config-server
   mvn spring-boot:run
   ```

3. **Ejecutar `api-discovery`**:
   ```bash
   cd ../api-discovery
   mvn spring-boot:run
   ```

4. **Ejecutar `api-rest-usuario`**:
   ```bash
   cd ../api-rest-usuario
   mvn spring-boot:run
   ```

5. **Ejecutar `api-rest-conferencias`**:
   ```bash
   cd ../api-rest-conferencias
   mvn spring-boot:run
   ```

6. **Ejecutar `api-rest-articulos`**:
   ```bash
   cd ../api-rest-articulos
   mvn spring-boot:run
   ```

7. **Ejecutar `api-gateway`**:
   ```bash
   cd ../api-gateway
   mvn spring-boot:run
   ```

---

## Servicios disponibles

Una vez que los servicios estén en ejecución, estarán disponibles en las siguientes direcciones:

- **API Config Server**: [http://localhost:8888](http://localhost:8888)
- **API Discovery**: [http://localhost:8761](http://localhost:8761)
- **API Gateway**: [http://localhost:8222](http://localhost:8222)
- **API Rest Usuario**: [http://localhost:8050](http://localhost:8050)
- **API Rest Conferencias**: [http://localhost:8070](http://localhost:8070)
- **API Rest Artículos**: [http://localhost:8060](http://localhost:8060)

---

## Solución de problemas

1. **Error: el puerto ya está en uso**
   - Asegúrate de que los puertos definidos (8888, 8761, 8222, 8050, 8060, 8070) no estén en uso por otros procesos.

2. **Problemas con Keycloak**
   - Si estás utilizando Docker y encuentras problemas con Keycloak, se recomienda usar la rama `test` y ejecutar los servicios manualmente.

---
