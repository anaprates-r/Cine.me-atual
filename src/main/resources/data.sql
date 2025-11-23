create table Conteudo (
    id varchar(255) NOT NULL primary key,
    titulo varchar(100) not null,
    descricao varchar(255) not null,
    genero varchar(50) not null,
    duracao varchar(10),
    classificacao int not null,
    Url varchar(255) not null,
    tipo varchar(20) not null
);
create table Usuario(
    id varchar(255) not null primary key,
    nome varchar(100) not null,
    nome_usuario varchar(50) not null,
    senha varchar(255) not null
);
create table Avaliacao(
    id varchar(255) not null primary key,
    nota int not null,
    comentario varchar(255),
    data_avaliacao DATE default current_date,
    usuario_id varchar(255),
    conteudo_id varchar(255),
    foreign key (usuario_id) references Usuario(id),
    foreign key (conteudo_id) references Conteudo(id)
);
