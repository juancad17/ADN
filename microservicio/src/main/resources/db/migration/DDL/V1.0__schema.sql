create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table evento (
  id int(11) not null auto_increment,
  nombre varchar(100) not null,
  direccion varchar(100) not null,
  valor_entrada double null,
  numero_boletas int not null,
  exige_carnet boolean not null,
  fecha_inicio datetime null,
  fecha_cierre datetime null,
  primary key (id)
);

create table boleta (
  id int(11) not null auto_increment,
  id_usuario varchar(45) not null,
  id_evento int(11) not null,
  fecha_compra datetime null,
  valor_total_compra double null,
  cantidad int(11) not null,
  PRIMARY KEY (id)
);