create database if not exists trabajadores_granja; 
use trabajadores_granja; 

CREATE TABLE trabajadores (
    dni VARCHAR(20) PRIMARY KEY,  -- DNI del trabajador (clave primaria)
    nombre VARCHAR(50) NOT NULL,  -- Nombre del trabajador
    apellidos VARCHAR(100) NOT NULL,  -- Apellidos del trabajador
    email VARCHAR(100) UNIQUE,  -- Correo electrónico (único)
    telefono VARCHAR(15),  -- Teléfono del trabajador
    sueldo DECIMAL(10, 2) NOT NULL,  -- Sueldo del trabajador
    puesto VARCHAR(50) NOT NULL  -- Puesto del trabajador
);
INSERT INTO trabajadores (dni, nombre, apellidos, email, telefono, sueldo, puesto)
VALUES 
    ('12345678A', 'Juan', 'Pérez García', 'juan.perez@example.com', '600123456', 2500.00, 'Veterinario'),
    ('87654321B', 'María', 'López Martínez', 'maria.lopez@example.com', '600654321', 3000.00, 'Control de calidad'),
    ('56789012C', 'Carlos', 'Gómez Sánchez', 'carlos.gomez@example.com', '600987654', 2000.00, 'Inspector de sanidad');