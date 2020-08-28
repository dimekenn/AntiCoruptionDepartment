create table keyboard (
    id          int not null constraint KEYBOARD_ID_UINDEX unique,
    button_ids  varchar(4096),
    inline      boolean default false,
    comment     varchar(4096),
    constraint KEYBOARD_PK primary key (ID)
);

insert into keyboard(id, button_ids,         comment)   values (1,      '2;3;4',                    'Меню "Выбор языка "');
insert into keyboard(id, button_ids,         comment)   values (2,      '5,6;7,8;9,10;11,12',       'Меню "Главное меню"' );
insert into keyboard(id, button_ids,         comment)   values (3,      '14,16;17',                 'Меню "История обращений"');
insert into keyboard(id, button_ids,         comment)   values (4,      '19,20;17',                 'Меню "О нас"');
insert into keyboard(id, button_ids, inline, comment)   values (5,      '21;22;23;24',      true ,  'Меню "Структура"');
insert into keyboard(id, button_ids, inline, comment)   values (6,      '1011;1012',        true ,  'Меню "Контакты"');
insert into keyboard(id, button_ids, inline, comment)   values (7,      '1011;1013;1014',   true,   'Меню "Новости"');
insert into keyboard(id, button_ids,         comment)   values (8,      '26,27;17',                 'Меню "Полезная информация"');
insert into keyboard(id, button_ids,         comment)   values (9,      '28,29;30,31;32,33;34,17',  'Меню "Проекты"');
insert into keyboard(id, button_ids,         comment)   values (10,     '36,37;17',                 'Меню "Администратора"');
insert into keyboard(id, button_ids,         comment)   values (11,     '42,43;44,45;46,47',        'Меню "Редактор кнопок"');
insert into keyboard(id, button_ids,         comment)   values (12,     '38,48',                    'Меню "Информация"');
insert into keyboard(id, button_ids,         comment)   values (13,     '39,40;41,48',              'Меню "Редактирование"');
insert into keyboard(id, button_ids,         comment)   values (1001,   '1001',                     'Меню "Поделится контактом"');
insert into keyboard(id, button_ids, inline, comment)   values (1002,   '1002,1003',        true ,  'Меню "Выполнено"');
insert into keyboard(id, button_ids, inline, comment)   values (1003,   '1004;1005',        true,   'Меню "Прикрепить/пропустить"');
insert into keyboard(id, button_ids, inline, comment)   values (1004,   '1004;1006',        true,   'Меню "Прикрепить/завершить"');
insert into keyboard(id, button_ids, inline, comment)   values (1005,   '18',               true ,  'Меню "Назад"');
insert into keyboard(id, button_ids, inline, comment)   values (1006,   '25',               true ,  'Меню "Назад для Структуры"');
insert into keyboard(id, button_ids, inline, comment)   values (1007,   '1007',             true ,  'Меню "Записаться"');
insert into keyboard(id, button_ids, inline, comment)   values (1008,   '1008,1009,1010',   true ,  'Меню "Оценки для обращении"');
insert into keyboard(id, button_ids, inline, comment)   values (1009,   '1016;1017;17',   false,  'Меню "Ответственных');
insert into keyboard(id, button_ids, inline, comment)   values (1010,   '1018;1019',   true,  'Меню "Подтверждения или отказ прием граждан"');