# Proyecto Gestión de Conferencias Académicas

Este proyecto contiene un conjunto de microservicios desplegados mediante Docker Compose. A continuación, se presentan las instrucciones para clonar el repositorio, construir las imágenes y ejecutar los servicios.

---

## Requisitos previos

Asegúrate de tener las siguientes herramientas instaladas en tu máquina:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

---

## Documentación y protocolo de sustentación

- **Documentación del proyecto**: [Documentación en PDF](https://docs.google.com/document/d/10-IaxTAloIKLhTPku-zjhZLPSVDNExfqZgOOzyGPHT8/edit?tab=t.0)
- **Video del protocolo de sustentación**: [Video en YouTube](<URL_VIDEO>)

---

## Pasos para la ejecución

### 1. Clonar el repositorio

Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/Mary31-05/proyectoSoftwareII_TC.git
cd proyectoSoftwareII_TC.git
```

### 2. Construir y ejecutar los servicios

Ejecuta el siguiente comando para construir las imágenes y levantar los servicios definidos en el archivo `docker-compose.yml`:

```bash
docker-compose up --build
```

### 3. Servicios disponibles

Una vez que los contenedores estén en ejecución, los servicios estarán disponibles en las siguientes direcciones:

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
---
