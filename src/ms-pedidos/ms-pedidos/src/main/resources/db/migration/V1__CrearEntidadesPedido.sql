CREATE TABLE pedido
(
    id               INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fecha_pedido     DATETIME         NOT NULL,
    estado_pedido    VARCHAR(20)      NOT NULL,
    obra_id          INTEGER UNSIGNED NOT NULL,

);

CREATE TABLE detalle_pedido
(
    id          INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cantidad    INTEGER UNSIGNED NOT NULL,
    precio      DOUBLE           NOT NULL,
    producto_id INTEGER UNSIGNED NOT NULL,
    pedido_id   INTEGER UNSIGNED NOT NULL,
    CONSTRAINT fk_pedido_detalle_pedido FOREIGN KEY (pedido_id) REFERENCES pedido (id)
);