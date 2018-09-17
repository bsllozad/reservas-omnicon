

INSERT INTO public.rol(id_rol, descripcion) VALUES (1, 'ADMINISTRADOR');
INSERT INTO public.rol(id_rol, descripcion) VALUES (2, 'CLIENTE');


INSERT INTO public.sede(id_sede, ciudad, direccion, telefono, estado)VALUES (1, 'CALI', 'CALLE 10 # 10 - 10', '+57 2 5552233', 'ACTIVO');
INSERT INTO public.sede(id_sede, ciudad, direccion, telefono, estado)VALUES (2, 'CALI', 'AV ROOSVELT # 39 -04', '+57 2 4445566', 'ACTIVO');
INSERT INTO public.sede(id_sede, ciudad, direccion, telefono, estado)VALUES (3, 'BOGOTA', 'CALLE 100 # 15 -34', '+57 1 3365544', 'ACTIVO');
INSERT INTO public.sede(id_sede, ciudad, direccion, telefono, estado)VALUES (4, 'BARRANQUILLA', 'CARRERA 1 # 11 - 53', '+57 5 2458711', 'ACTIVO');


INSERT INTO public.usuario(numero_identificacion, nombres, apellidos, usuario, contrasena, telefono, estado, id_rol)VALUES ('1130602387', 'BERNARDO', 'LOPEZ LOZADA', 'bll2387', '4f0a8046b3221fb055e0e2709c249a8d79b59b0d', '+573176591032', 'ACTIVO', 1);


INSERT INTO public.reserva(codigo_reserva, estado, fecha_registro, fecha_reserva, numero_personas, id_sede, numero_identificacion)VALUES ('1', 'INACTIVA', '15/09/2018', '18/09/2018', 5, 1, '1130602387');
INSERT INTO public.reserva(codigo_reserva, estado, fecha_registro, fecha_reserva, numero_personas, id_sede, numero_identificacion)VALUES ('2', 'ACTIVA', '15/09/2018', '18/09/2018', 2, 1, '1130602387');
INSERT INTO public.reserva(codigo_reserva, estado, fecha_registro, fecha_reserva, numero_personas, id_sede, numero_identificacion)VALUES ('3', 'ACTIVA', '15/09/2018', '19/09/2018', 3, 2, '1130602387');




