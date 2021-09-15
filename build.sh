# Levanta el servicio de base de datos para buildear las imágenes
docker-compose up -d database

# Build de imagen de Microservicio de BCRA
cd src/ms-bcra
mvn spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Microservicio de Pagos
cd src/ms-pagos
mvn spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Microservicio de Pedido
cd src/ms-pedidos
mvn spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Microservicio de Producto
cd src/ms-productos
mvn spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Microservicio de Usuario
cd src/ms-usuarios
mvn spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Servicio de Proxy
cd src/proxy-service
mvn spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Microservicio de Service Discovery
cd src/service-discovery
mvn spring-boot:build-image -DskipTests=true
cd ../../

# Baja del servicio de base de datos
docker-compose up down database