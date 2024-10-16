create table categorias (
    id bigint generated by default as identity,
    descricao varchar(100) not null,
    primary key (id)
);

insert into categorias (descricao)
values ('Java'),
    ('Dart'),
    ('Kotlin'),
    ('C++'),
    ('Python');