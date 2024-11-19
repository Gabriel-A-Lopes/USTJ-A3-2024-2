drop database dbCoracaoPet;
create database dbCoracaoPet;
use dbCoracaoPet;
create table tb_funcionarios(
	idFuncionario int primary key auto_increment,
    nomeFunc varchar(200),
    org varchar(200),
    loginFunc varchar(200),
    senhaFunc varchar(200)
);
create table tb_admin(
	idADM int primary key auto_increment,
    nomeADM varchar(200),
    loginADM varchar(200),
    senhaADM varchar(200)
);

create table tb_animais(
	idAnimal int primary key auto_increment,
    nomeAnimal varchar(200),
    tipoAnimal varchar(200),
    racaAnimal varchar(200),
    cor varchar(200),
    local varchar(200),
    idade int,
    castrado boolean
);

insert into tb_funcionarios
(nomeFunc, org, loginFunc, senhaFunc) values
("Alan", "Coração Pet", "alan.binato", "123asdfg");

insert into tb_admin
(nomeADM, loginADM, senhaADM) values
("Administrador", "adm", "ADMAccess");


select * from tb_funcionarios;
select * from tb_admin;
select * from tb_animais;

delete from tb_funcionarios where codigoFunc = 4;
delete from tb_animais;