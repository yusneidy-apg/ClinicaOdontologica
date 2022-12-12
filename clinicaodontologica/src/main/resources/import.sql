-- Insertar rol
INSERT INTO ROLES VALUES (1, 'ADMIN');
INSERT INTO ROLES VALUES (2, 'USER');

-- Insertar usuario
INSERT INTO USUARIO VALUES(1, true, '$2a$10$BGyAsVTTAmNhYL0h2M2qQ.VtuxnjQ5gn9ZpPjHBsVOXyhYozUd1Oy', 'usuario1');

-- Insertar usuario rol
INSERT INTO USUARIOSROLES VALUES (1, 1);
