create sequence hibernate_sequence start with 1 increment by 1;

create table properties (
    id          integer not null,
    name        varchar(4096),
    value       varchar(4096),
    latitude    varchar(500),
    longitude   varchar(500), primary key (id)
);

insert into properties (id, name, value)        values (1, 'botUsername',   'dimeken04AntiC');
insert into properties (id, name, value)        values (2, 'botToken',      '1334874633:AAEm2NhvelNoFiu1gCBmUEiT_KccBMs91Hg');
insert into properties (id,latitude, longitude) values (3, '43.302373',     '77.063817');

//840528216:AAG0nr1Yi22M8A0u_QR3s6hV7uVvu0_1GkA
//1330528607:AAGVrPfyQo11Sg6MJVeLsyPStsku9ZgtxPU