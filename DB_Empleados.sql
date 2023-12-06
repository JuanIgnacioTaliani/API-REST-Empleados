CREATE DATABASE db_api_empleados;
USE db_api_empleados;

CREATE TABLE departamento (
	id_departamento INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_departamento)
);

CREATE TABLE puesto (
	id_puesto INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    departamento_id INT NOT NULL,
    PRIMARY KEY (id_puesto),
    FOREIGN KEY (departamento_id) REFERENCES departamento(id_departamento)
);

CREATE TABLE provincia (
	id_provincia INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_provincia)
);

CREATE TABLE localidad (
	id_localidad INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    provincia_id INT NOT NULL,
    PRIMARY KEY (id_localidad),
    FOREIGN KEY (provincia_id) REFERENCES provincia(id_provincia)
);

CREATE TABLE tipo_documento (
	id_tipo_documento INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_tipo_documento)
);

CREATE TABLE empleados (
	legajo INT NOT NULL AUTO_INCREMENT,
    tipo_documento_id INT NOT NULL,
    nro_documento INT NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    telefono INT NOT NULL,
    calle VARCHAR(45) NOT NULL,
    numero_calle INT NOT NULL,
    localidad_id INT NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    fecha_contratacion DATE NOT NULL,
    salario INT NOT NULL,
    puesto_id INT NOT NULL,
    PRIMARY KEY (legajo),
    FOREIGN KEY (tipo_documento_id) REFERENCES tipo_documento(id_tipo_documento),
    FOREIGN KEY (localidad_id) REFERENCES localidad(id_localidad),
    FOREIGN KEY (puesto_id) REFERENCES puesto(id_puesto)
);