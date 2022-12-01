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

