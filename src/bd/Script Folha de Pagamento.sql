create schema if not exists folha_pagamento default character  set utf8;

use folha_pagamento;

create table contrato(
id int auto_increment not null,
numero_contrato int,
inicio_contrato date, 
termino_contrato date,
cargo varchar(20),
local_trabalho varchar(20),
valor_hora double,
hora_trabalhada_mes int,
primary key(id)
);

create table funcionario(
id int auto_increment not null,
nome varchar(20),
cpf varchar (14),
data_nascimento Date,
primary key(id)
);


