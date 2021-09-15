# Levanta el servicio de base de datos para buildear las imágenes
docker-compose up -d database

# Build de imagen de Microservicio de BCRA
cd src/ms-bcra
./mvnw spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Microservicio de Pagos
cd src/ms-pagos
./mvnw spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Microservicio de Pedido
cd src/ms-pedidos
./mvnw spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Microservicio de Producto
cd src/ms-productos
./mvnw spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Microservicio de Usuario
cd src/ms-usuarios
./mvnw spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Servicio de Proxy
cd src/proxy-service
./mvnw spring-boot:build-image -DskipTests=true
cd ../../

# Build de imagen de Servicio de Service Discovery
cd src/service-discovery
./mvnw spring-boot:build-image -DskipTests=true
cd ../../

# Baja del servicio de base de datos
docker-compose up down database