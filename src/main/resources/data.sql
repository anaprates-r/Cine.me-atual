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
create table Usuario(
    id varchar(255) not null primary key,
    nome varchar(100) not null,
    nomeUsuario varchar(50) not null,
    senha varchar(255) not null
);
create table Avaliacao(
    id varchar(255) not null primary key,
    nota int not null,
    avaliacao varchar(255),
    dataAvaliacao DATE default current_date,
    usuarioId varchar(255),
    conteudoId varchar(255),
    foreign key (usuarioId) references Usuario(id),
    foreign key (conteudoId) references Conteudo(id)
);
