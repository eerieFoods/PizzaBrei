-- auto-generated definition
create table pb_application
(
    id             varchar(255) not null
        primary key,
    authors        varchar(255) null,
    creation_date  datetime(6)  not null,
    description    varchar(255) null,
    download_count int          not null,
    file_url       varchar(255) not null,
    name           varchar(255) not null,
    version        varchar(255) not null
);

create table pb_application_ratings
(
    application_id varchar(255) not null,
    ratings_id     varchar(255) not null,
    constraint UK_6ws4gqdg8j8uu2gyie8ucg72g
        unique (ratings_id),
    constraint FK8x0fx47lko6viauargafpjgdi
        foreign key (application_id) references pb_application (id),
    constraint FKi1gjvvloex48lcw0pjhta5k6i
        foreign key (ratings_id) references pb_review (id)
);

create table pb_review
(
    id             varchar(255) not null
        primary key,
    author         varchar(255) not null,
    content        varchar(255) not null,
    rating         int          not null,
    application_id varchar(255) null,
    constraint FK89bhewctvx3gorph3w3pycjkp
        foreign key (application_id) references pb_application (id)
);



