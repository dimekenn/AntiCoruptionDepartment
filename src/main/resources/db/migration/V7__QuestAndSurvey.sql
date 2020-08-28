create table QUEST (
    ID      INT auto_increment,
    NAME    VARCHAR(4096),
    LANG_ID INT
);

create table SURVEY (
    ID          INT auto_increment,
    CHAT_ID     BIGINT,
    ANSWERS     VARCHAR(4096),
    DATE_ANSWER TIMESTAMP,
    constraint SURVEY_PK primary key (ID)
);

insert into QUEST(ID, NAME, LANG_ID) VALUES (1, concat('<b><i>Какие методы борьбы с коррупцией Вы считаете наиболее эффективными?</i></b>', stringdecode('\n'), '<b>А.</b> Совершенствование законодательной базы, эффективная реализация существующих законов',
stringdecode('\n'), '<b>В</b>. Увеличение заработной платы', stringdecode('\n'), '<b>С</b>. Усиление государственного и общественного контроля', stringdecode('\n'), '<b>Д.</b> Ужесточение уголовного наказания за коррупцию',
stringdecode('\n'), '<b>Е</b>. Формирование нетерпимости в обществе к коррупционному поведению'), 1);
insert into QUEST(ID, NAME, LANG_ID) VALUES (1, concat('<b><i>Сыбайлас жемқорлыққа қарсы күрестің қандай әдістерін ең тиімді деп санайсыз?</i></b>', stringdecode('\n'), '<b>А.</b> Заңнамалық базаны жетілдіру, қолданыстағы заңдарды тиімді іске асыру',
stringdecode('\n'), '<b>В</b>. Жалақыны ұлғайту', stringdecode('\n'), '<b>С</b>. Мемлекеттік және қоғамдық бақылауды күшейту', stringdecode('\n'), '<b>Д.</b> Сыбайлас жемқорлық үшін қылмыстық жазаны қатаңдату',
stringdecode('\n'),'<b>Е</b>. Қоғамда сыбайлас жемқорлыққа төзбеушілікті қалыптастыру'), 2);
insert into QUEST(ID, NAME, LANG_ID) VALUES (1, concat('<b><i>What methods of fighting corruption do you consider the most effective?</i></b>', stringdecode('\n'), '<b>А.</b> Improvement of the legal framework, effective implementation of existing laws',
stringdecode('\n'), '<b>В</b>. Wage increases', stringdecode('\n'), '<b>С</b>. Wage increases', stringdecode('\n'), '<b>D.</b> Toughening criminal penalties for corruption',
stringdecode('\n'),'<b>Е</b>. Formation of intolerance in society to corrupt behavior'), 3);

insert into QUEST(ID, NAME, LANG_ID) VALUES (2, concat('<b><i>Сообщали ли Вы о фактах коррупции?</i></b>', stringdecode('\n'), '<b>А</b>. Да', stringdecode('\n'), '<b>В</b>. Нет', stringdecode('\n'), '<b>С</b>. Не сталкивался (- лась)'), 1);
insert into QUEST(ID, NAME, LANG_ID) VALUES (2, concat('<b><i>Сіз сыбайлас жемқорлық фактілері туралы хабарлап көрдіңіз бе?</i></b>', stringdecode('\n'), '<b>А</b>. Иә', stringdecode('\n'), '<b>В</b>. Жоқ', stringdecode('\n'), '<b>С</b>. Бұндай жағдайға тап болған жоқпын'), 2);
insert into QUEST(ID, NAME, LANG_ID) VALUES (2, concat('<b><i>Have you reported facts of corruption?</i></b>', stringdecode('\n'), '<b>А</b>. Yes', stringdecode('\n'), '<b>В</b>. No', stringdecode('\n'), '<b>С</b>. Not experienced'), 3);

insert into QUEST(ID, NAME, LANG_ID) VALUES (3, concat('<b><i>Приходилось ли Вам попадать в коррупционную ситуацию ?</i></b>', stringdecode('\n'), '<b>А</b>. Да', stringdecode('\n'), '<b>В</b>. Нет'), 1);
insert into QUEST(ID, NAME, LANG_ID) VALUES (3, concat('<b><i>Сіздің сыбайлас жемқорлық жағдайына тап болған кезіңіз болды ма?</i></b>', stringdecode('\n'), '<b>А</b>. Иә', stringdecode('\n'), '<b>В</b>. Жоқ'), 2);
insert into QUEST(ID, NAME, LANG_ID) VALUES (3, concat('<b><i>Have you ever got into a corrupt situation?</i></b>', stringdecode('\n'), '<b>А</b>. Yes', stringdecode('\n'), '<b>В</b>. No'), 3);

insert into QUEST(ID, NAME, LANG_ID) VALUES (4, concat('<b><i>Достаточно ли информации об антикоррупционной политике в СМИ?</i></b>', stringdecode('\n'), '<b>А</b>. Да, информация предоставляется в необходимом для меня объеме', stringdecode('\n'), '<b>В</b>. Информации достаточно, но она не освещает всех аспектов',
stringdecode('\n'), '<b>C</b>. Нет, информации не достаточно'), 1);
insert into QUEST(ID, NAME, LANG_ID) VALUES (4, concat('<b><i>БАҚ-та сыбайлас жемқорлыққа қарсы саясат туралы ақпарат жеткілікті ме?</i></b>', stringdecode('\n'), '<b>А</b>. Иә, ақпарат мен үшін қажетті көлемде беріледі', stringdecode('\n'), '<b>В</b>. Ақпарат жеткілікті, бірақ ол барлық аспектілерді қамтымайды',
stringdecode('\n'), '<b>С</b>. Жоқ, ақпарат жеткіліксіз'), 2);
insert into QUEST(ID, NAME, LANG_ID) VALUES (4, concat('<b><i>Is there Enough information about anti-corruption policy in the media?</i></b>', stringdecode('\n'), '<b>А</b>. Yes, the information is provided in the amount necessary for me', stringdecode('\n'), '<b>В</b>. There is enough information, but it does not cover all aspects',
stringdecode('\n'), '<b>C</b>. No, there is not enough information'), 3);