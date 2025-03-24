CREATE TABLE IF NOT EXISTS PORTAFOLIO (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_proyecto VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_inicio DATE,
    fecha_fin DATE,
    tecnologias_usadas VARCHAR(255),
    url_proyecto VARCHAR(255)
);

