-- Crear base de datos (schema en MySQL)
CREATE DATABASE IF NOT EXISTS practica_final_backend;

-- Usar la base de datos
USE practica_final_backend;

-- =========================
-- Tabla: genero
-- =========================
CREATE TABLE genero (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- =========================
-- Tabla: puesto_trabajo
-- =========================
CREATE TABLE puesto_trabajo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT
);

-- =========================
-- Tabla: usuario
-- =========================
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    genero_id INT,
    puesto_trabajo_id INT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (genero_id) REFERENCES genero(id),
    FOREIGN KEY (puesto_trabajo_id) REFERENCES puesto_trabajo(id)
);

-- =========================
-- Tabla: direccion
-- =========================
CREATE TABLE direccion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    calle VARCHAR(150) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    provincia VARCHAR(100),
    codigo_postal VARCHAR(20),
    pais VARCHAR(100),

    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);