create table appeal_type (
    id      int auto_increment,
    name    varchar(8096),
    lang_id int
);

insert into appeal_type(id, name, lang_id) values (1, 'Образование', 1);
insert into appeal_type(id, name, lang_id) values (1, 'Білім беру', 2);
insert into appeal_type(id, name, lang_id) values (1, 'Education', 3);

insert into appeal_type(id, name, lang_id) values (2, 'Здравоохранение', 1);
insert into appeal_type(id, name, lang_id) values (2, 'Денсаулық сақтау', 2);
insert into appeal_type(id, name, lang_id) values (2, 'Healthcare', 3);

insert into appeal_type(id, name, lang_id) values (3, 'Жилищно-коммунальное хозяйство', 1);
insert into appeal_type(id, name, lang_id) values (3, 'Тұрғын үй-коммуналдық шаруашылық', 2);
insert into appeal_type(id, name, lang_id) values (3, 'Housing and communal services', 3);

insert into appeal_type(id, name, lang_id) values (4, 'Сельское хозяйство', 1);
insert into appeal_type(id, name, lang_id) values (4, 'Ауыл шаруашылық', 2);
insert into appeal_type(id, name, lang_id) values (4, 'Agriculture', 3);

insert into appeal_type(id, name, lang_id) values (5, 'Земельные отношения, архитектура и градостроительства', 1);
insert into appeal_type(id, name, lang_id) values (5, 'Жер қатынастары, сәулет және қала құрылысы', 2);
insert into appeal_type(id, name, lang_id) values (5, 'Land relations, architecture and urban planning', 3);

insert into appeal_type(id, name, lang_id) values (6, 'Грузовые и пассажирские перевозки', 1);
insert into appeal_type(id, name, lang_id) values (6, 'Жүк және жолаушылар тасымалы', 2);
insert into appeal_type(id, name, lang_id) values (6, 'Freight and passenger traffic', 3);

insert into appeal_type(id, name, lang_id) values (7, 'Строительство автомобильных дорог', 1);
insert into appeal_type(id, name, lang_id) values (7, 'Автомобиль жолдарын салу', 2);
insert into appeal_type(id, name, lang_id) values (7, 'Construction of highways', 3);

insert into appeal_type(id, name, lang_id) values (8, 'Экология', 1);
insert into appeal_type(id, name, lang_id) values (8, 'Экология', 2);
insert into appeal_type(id, name, lang_id) values (8, 'Ecology', 3);

insert into appeal_type(id, name, lang_id) values (9, 'Оборона', 1);
insert into appeal_type(id, name, lang_id) values (9, 'Қорғаныс', 2);
insert into appeal_type(id, name, lang_id) values (9, 'Defense', 3);

insert into appeal_type(id, name, lang_id) values (10, 'Полицейская служба', 1);
insert into appeal_type(id, name, lang_id) values (10, 'Полиция қызметі', 2);
insert into appeal_type(id, name, lang_id) values (10, 'Police service', 3);

insert into appeal_type(id, name, lang_id) values (11, 'Центр обслуживания населения', 1);
insert into appeal_type(id, name, lang_id) values (11, 'Халыққа қызмет көрсету орталығы', 2);
insert into appeal_type(id, name, lang_id) values (11, 'Public service Centers', 3);

insert into appeal_type(id, name, lang_id) values (12, 'Защита бизнеса и инвестиций', 1);
insert into appeal_type(id, name, lang_id) values (12, 'Бизнес және инвестицияларды қорғау', 2);
insert into appeal_type(id, name, lang_id) values (12, 'Protecting business and investments', 3);

insert into appeal_type(id, name, lang_id) values (13, 'Иные', 1);
insert into appeal_type(id, name, lang_id) values (13, 'Өзге де салалар бойынша', 2);
insert into appeal_type(id, name, lang_id) values (13, 'Others', 3);