-- Insertar rol
INSERT INTO ROLES VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLES VALUES (2, 'ROLE_USER');

-- Insertar usuario
INSERT INTO USUARIO VALUES(1, true, '$2a$10$BGyAsVTTAmNhYL0h2M2qQ.VtuxnjQ5gn9ZpPjHBsVOXyhYozUd1Oy', 'usuario1');
INSERT INTO USUARIO VALUES(2, true, '$2a$10$BGyAsVTTAmNhYL0h2M2qQ.VtuxnjQ5gn9ZpPjHBsVOXyhYozUd1Oy', 'usuario2');
INSERT INTO USUARIO VALUES(3, true, '$2a$10$BGyAsVTTAmNhYL0h2M2qQ.VtuxnjQ5gn9ZpPjHBsVOXyhYozUd1Oy', 'usuarioSinRol');
INSERT INTO USUARIO VALUES(4, false, '$2a$10$BGyAsVTTAmNhYL0h2M2qQ.VtuxnjQ5gn9ZpPjHBsVOXyhYozUd1Oy', 'usuarioInactivo');

-- Insertar usuario rol
INSERT INTO USUARIOSROLES VALUES (1, 1);
INSERT INTO USUARIOSROLES VALUES (2, 2);
INSERT INTO USUARIOSROLES VALUES (1, 4);

--Insertar Odontólogo
INSERT INTO ODONTOLOGO VALUES (1, 'Diaz', 'R123456789', 'Diomedes');
INSERT INTO ODONTOLOGO VALUES (2, 'Celedon', 'J123456987', 'Jorge');

--Insertar Paciente
INSERT INTO PACIENTE VALUES(1, 'Paez', '123456789', 'Calle cable a tierra', '2022-12-05 20:00:00', 'Fito');
INSERT INTO PACIENTE VALUES(2, 'Martin', '19283746', 'Calle los proceres', '2022-12-05 20:00:00', 'Ricky');

INSERT INTO TURNO VALUES(1,'2022-12-05 20:00:00', 1, 1);
INSERT INTO TURNO VALUES(2,'2022-12-05 20:00:00', 2, 2);
