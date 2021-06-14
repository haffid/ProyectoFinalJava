CREATE DATABASE bd_usuarios;
USE bd_usuarios;

CREATE TABLE tbl_usuario(
	id_usuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre_usuario VARCHAR(35) NOT NULL,
	apellido_usuario VARCHAR(35) NOT NULL,
	edad_usuario INT,
	usuario VARCHAR(25),
	clave VARCHAR(25), 
	id_estado_fk INT,
	id_tipo_usuario_fk INT
);

CREATE TABLE tbl_estado(
	id_estado INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre_estado VARCHAR(35) NOT NULL,
	descripcion_estado VARCHAR(35) NOT NULL
);

CREATE TABLE tbl_tipo_usuario(
	id_tipo_usuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre_tipo_usuario VARCHAR(35) NOT NULL,
	descripcion_tipo_usuario VARCHAR(35) NOT NULL
);

CREATE TABLE tbl_score(
	id_score INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	punteo_score INT NOT NULL,
	id_usuario_fk INT
);

ALTER TABLE tbl_usuario ADD FOREIGN KEY (id_estado_fk)
REFERENCES tbl_estado (id_estado);

ALTER TABLE tbl_usuario ADD FOREIGN KEY (id_tipo_usuario_fk)
REFERENCES tbl_tipo_usuario (id_tipo_usuario);

ALTER TABLE tbl_score ADD FOREIGN KEY (id_usuario_fk)
REFERENCES tbl_usuario (id_usuario);

INSERT INTO tbl_estado (nombre_estado, descripcion_estado)
VALUES ('Activo', 'Usuario activo en el juego'), ('Inactivo', 'Usuario que termino el juego');

INSERT INTO tbl_tipo_usuario (nombre_tipo_usuario, descripcion_tipo_usuario)
VALUES ('Administrador', 'CRUD de Usuarios'), 
('Principiante', 'Nivel 1'), 
('Intermedio', 'Nivel 2'), 
('Avanzado', 'Nivel 3');

INSERT INTO tbl_usuario (nombre_usuario, apellido_usuario, edad_usuario, usuario, clave, id_estado_fk, id_tipo_usuario_fk)
VALUES ('Omar', 'Espina', 28, 'omar', 1234, 1, 1);

SELECT * FROM tbl_estado;
SELECT * FROM tbl_tipo_usuario;
SELECT * FROM tbl_score;
SELECT * FROM tbl_usuario;

SELECT 
id_usuario, 
nombre_usuario,
apellido_usuario,
edad_usuario,
usuario,
id_estado_fk,
id_tipo_usuario_fk,
id_score,
punteo_score
FROM tbl_usuario u
INNER JOIN tbl_score s
ON u.id_usuario = s.id_usuario_fk


