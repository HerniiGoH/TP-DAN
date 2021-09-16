CREATE DATABASE application_usuario_db;
CREATE USER 'user_application'@'%' IDENTIFIED BY '3be43125f05dc87c9b5f27533daf2f01';
GRANT ALL PRIVILEGES ON application_usuario_db.* TO 'user_application'@'%';
FLUSH PRIVILEGES ;

CREATE DATABASE ms_usuarios_db;
CREATE USER 'user_usuarios'@'%' IDENTIFIED BY '3be43125f05dc87c9b5f27533daf2f01';
GRANT ALL PRIVILEGES ON ms_usuarios_db.* TO 'user_usuarios'@'%';
FLUSH PRIVILEGES ;

CREATE DATABASE ms_pedidos_db;
CREATE USER 'user_pedidos'@'%' IDENTIFIED BY '3be43125f05dc87c9b5f27533daf2f01';
GRANT ALL PRIVILEGES ON ms_pedidos_db.* TO 'user_pedidos'@'%';
FLUSH PRIVILEGES ;

CREATE DATABASE ms_productos_db;
CREATE USER 'user_productos'@'%' IDENTIFIED BY '3be43125f05dc87c9b5f27533daf2f01';
GRANT ALL PRIVILEGES ON ms_productos_db.* TO 'user_productos'@'%';
FLUSH PRIVILEGES ;

CREATE DATABASE ms_cuentacorriente_db;
CREATE USER 'user_cuentacorriente'@'%' IDENTIFIED BY '3be43125f05dc87c9b5f27533daf2f01';
GRANT ALL PRIVILEGES ON ms_cuentacorriente_db.* TO 'user_cuentacorriente'@'%';
FLUSH PRIVILEGES ;

# CREATE DATABASE "keycloak-db";
# CREATE USER keycloak_application WITH PASSWORD 'FNvJ1ThgdcvU390G';
# GRANT ALL PRIVILEGES ON DATABASE "keycloak-db" to keycloak_application;