drop database dbCoracaoPet;
create database dbCoracaoPet;
use dbCoracaoPet;
create table tb_funcionarios(
	codigoFunc int primary key auto_increment,
    nomeFunc varchar(200),
    org varchar(200),
    loginFunc varchar(200),
    senhaFunc varchar(200)
);
create table tb_admin(
	codigoADM int primary key auto_increment,
    nomeADM varchar(200),
    loginADM varchar(200),
    senhaADM varchar(200)
);
insert into tb_funcionarios
(nomeFunc, org, loginFunc, senhaFunc) values
("Alan", "Coração Pet", "alan.binato", "123asdfg");

insert into tb_admin
(nomeADM, loginADM, senhaADM) values
("Administrador", "adm", "ADMAccess");

select * from tb_funcionarios;
select * from tb_admin;