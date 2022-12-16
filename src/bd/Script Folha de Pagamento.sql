create schema if not exists folha_pagamento default character  set utf8;

use folha_pagamento;

create table funcionario(
id int auto_increment not null,
nome varchar(20),
cpf varchar (14),
data_nascimento Date,
primary key(id)
);

create table contrato(
id int auto_increment not null,
inicio_contrato date, 
termino_contrato date,
cargo varchar(20),
local_trabalho varchar(20),
valor_hora double,
hora_trabalhada_mes int,
id_funcionario int not null,
primary key(id),
foreign key contrato (id_funcionario) references funcionario (id)
);

create table calculo(
id int not null auto_increment,
vale_transporte double,
vale_alimentacao double,
id_contrato int not null,
primary key (id),
foreign key calculo (id_contrato) references contrato (id)
);

select * from funcionario;

select * from contrato;

select * from calculo;
