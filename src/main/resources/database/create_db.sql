create table USUARIOS(
ID bigint not null AUTO_INCREMENT,
EMAIL varchar(70) not null,
CONTRASENIA varchar(70) not null,
PRIMARY KEY(ID);
);

CREATE TABLE COMPRADORES(
ID bigint not null,
NOMBRE varchar(60)not null,
APELLIDO varchar(60)not null,
TELEFONO int not null,
DIRECCION varchar(90)not null,
CODIGO_POSTAL int not null,
PRIMARY KEY(ID);
);
alter table COMPRADORES add constraint COMP$USU foreign key(ID) references USUARIOS(ID);


CREATE TABLE PEDIDOS(
ID bigint not null AUTO_INCREMENT,
FECHA timestamp not null,
TOTAL decimal(9,2)not null,
ESTADO varchar(50)not null,
PRIMARY KEY(ID);
);
alter table PEDIDOS add constraint PED$COMP foreign key(COMPRADOR_ID) references COMPRADORES(ID)

CREATE TABLE PRODUCTOS(
ID bigint not null AUTO_INCREMENT,
NOMBRE varchar(150) not null,
MARCA varchar(70)not null,
COLOR varchar(50)not null,
PRECIO decimal(9,2) not null,
CANTIDAD int not null,
PRIMARY KEY(ID);
);

CREATE TABLE CELULARES(
ID bigint not null,
TAMANIO int not null, 
RESOLUCION_PANTALLA varchar(60)not null,
RESULOCION_CAMARA varchar(60)not null,
RAM int not null,
ALMACENAMIENTO int not null,
PRIMARY KEY(ID);
);

CREATE TABLE CARGADORES(
ID bigint not null,
WATS int not null,
CARGA_RAPIDA boolean not null,
PRIMARY KEY(ID);
);

alter table CELULARES add constraint CEL$PRO foreign key(ID) references PRODUCTOS(ID);
alter table CARGADORES add constraint CAR$PRO foreign key(ID) references PRODUCTOS(ID);

CREATE TABLE ITEMS_PEDIDOS (
ID bigint not null AUTO_INCREMENT,
PEDIDO_ID bigint not null,
PRODUCTO_ID bigint not null,
CANTIDAD int not null,
PRECIO_UNITARIO decimal(9,2) not null,
PRIMARY KEY(ID);
);
 alter table ITEMS_PEDIDOS add constraint ITEM$PED foreign key(PEDIDO_ID) references PEDIDOS(ID),
 alter table ITEMS_PEDIDOS add constraint ITEM$PRO foreign key(PRODUCTO_ID) references PRODUCTOS(ID)

CREATE TABLE PAGOS (
ID bigint not null AUTO_INCREMENT,
PEDIDO_ID bigint not null,
FECHA_PAGO timestamp not null,
METODO_PAGO varchar(30) not null,
MONTO decimal(9,2) not null,
ESTADO varchar(50)not null,
PRIMARY KEY(ID);
);
alter table PAGOS add constraint PAGO$PED foreign key(PEDIDO_ID) references PEDIDOS(ID)
    
CREATE TABLE ESTADOS(
ID int not null,
VALOR varchar(50)not null,
PRIMARY KEY(ID);
)
    
CREATE TABLE METODOS_PAGOS(
ID int not null,
VALOR varchar(50)not null,
PRIMARY KEY(ID);
)
    