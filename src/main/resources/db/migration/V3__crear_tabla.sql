CREATE DATABASE IF NOT EXISTS practica_final_backend;
USE practica_final_backend;

CREATE TABLE IF NOT EXISTS genero (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS puesto_trabajo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nick_usuario VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE,
    genero_id INT,
    nombre VARCHAR(100) NOT NULL,
    primer_apellido VARCHAR(100) NOT NULL,
    segundo_apellido VARCHAR(100),
    fecha_hora_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    hora_desayuno TIME,
    puesto_trabajo_id INT,
    CONSTRAINT fk_usuario_genero FOREIGN KEY (genero_id) REFERENCES genero(id),
    CONSTRAINT fk_usuario_puesto FOREIGN KEY (puesto_trabajo_id) REFERENCES puesto_trabajo(id)
);

CREATE TABLE IF NOT EXISTS direccion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    nombre_calle VARCHAR(150) NOT NULL,
    numero_calle VARCHAR(20) NOT NULL,
    direccion_principal BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_direccion_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

INSERT INTO genero (nombre)
VALUES ('Hombre'), ('Mujer'), ('Otro')
ON DUPLICATE KEY UPDATE nombre = VALUES(nombre);

INSERT INTO puesto_trabajo (nombre, descripcion)
VALUES
    ('Desarrollador', 'Desarrollo de aplicaciones'),
    ('Analista', 'Analisis funcional y tecnico'),
    ('Gerente', 'Gestion de equipos y proyectos')
ON DUPLICATE KEY UPDATE descripcion = VALUES(descripcion);
