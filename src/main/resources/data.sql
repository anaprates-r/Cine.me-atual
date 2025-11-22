create table Conteudo (
    id varchar(255) NOT NULL primary key,
    titulo varchar(100) not null,
    descricao varchar(255) not null,
    genero varchar(50) not null,
    duracao varchar(10),
    classificacao int not null,
    fotoUrl varchar(255) not null,
    tipo varchar(20) not null
);