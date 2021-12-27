insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());
insert into evento(nombre, direccion, valor_entrada, numero_boletas, exige_carnet, fecha_inicio, fecha_cierre) values('testInfraEvento','Calle infra', 5000, 50, 1, now(), (now()+1));
insert into boleta(id_usuario, id_evento, fecha_compra, valor_total_compra, cantidad) values('123', 1, now(), 0, 3);

