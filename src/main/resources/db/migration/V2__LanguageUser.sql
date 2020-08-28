create table users (
    id          integer not null auto_increment,
    chat_id     bigint not null,
    full_name   varchar(255),
    phone       varchar(255),
    username    varchar(500), primary key (id)
);

create table language_user (
    id          integer not null,
    chat_id     bigint not null,
    language_id integer not null, primary key (id)
);


