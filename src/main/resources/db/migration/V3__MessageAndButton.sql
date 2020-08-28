create table message (
    id          integer,
    name        varchar(8096) not null,
    photo       varchar,
    keyboard_id integer,
    file        varchar,
    file_type   varchar,
    language_id integer
);

create table button (
    id              integer      not null,
    name            varchar(300) not null,
    command_id      integer default 0,
    url             varchar(4096),
    request_contact boolean default false,
    message_id      integer,
    lang_id         integer
);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1, '⁉️Команда не найдена', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1, '⁉️Команда табылмады',  null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1, '⁉️Command not found',  null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (2, concat('Интерфейс тілін таңдаңыз.',STRINGDECODE('\n'),'-------------------------------',STRINGDECODE('\n'),'Выберите язык интерфейса.'), null, 1, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (2, concat('Интерфейс тілін таңдаңыз.',STRINGDECODE('\n'),'-------------------------------',STRINGDECODE('\n'),'Выберите язык интерфейса.'), null, 1, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (2, concat('Интерфейс тілін таңдаңыз.',STRINGDECODE('\n'),'-------------------------------',STRINGDECODE('\n'),'Выберите язык интерфейса.'), null, 1, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (3, '«Вас приветствует онлайн консультант «antikor1424»', null, 2, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (3, '«antikor1424» онлайн кеңесшісі мәзіріне қош келдіңіз', null, 2, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (3, '«Welcome to the online consultant «Anticor 1424» ', null, 2, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (4, '<i><b>Выберите категорию обращений ⬇️</b></i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (4, '<i><b>Өтініштер санатын таңдаңыз ⬇️</b></i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (4, '<i><b>Select a category of requests ⬇️</b></i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (5, 'В строке ввода подробно изложите<b> обращение ⬇️</b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (5, '<b>Енгізу жолында өтінішті егжей-тегжейлі сипаттаңыз ⬇️</b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (5, '<b>In the entry bar, describe the request in detail ⬇️</b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (6, '📎<b>Прикрепите файл (фото / видео)</b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (6, '📎<b>Файлды тіркеңіз (фото / видео)</b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (6, '📎<b>Attach a file (photo / video)</b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (7, '📎<b>Прикрепите геолокацию</b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (7, '📎<b>Геолокацияны бекітіңіз</b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (7, '📎<b>Attach a geolocation</b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (8, '❌ <b>Нету доступа</b> ❌', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (8, '❌ <b>Кіру жоқ</b> ❌', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (8, '❌ <b>No access</b> ❌', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (9, '<i><b>Введите текст пояснение 🖊</i></b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (9, '<i><b>Түсіндірме мәтінін енгізіңіз 🖊</i></b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (9, '<i><b>Enter the text explanation 🖊</i></b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (10, '🗂 История обращений', null, 3, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (10, '🗂 Өтініштер тізімі', null, 3, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (10, '🗂 The history of appeals', null, 3, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (11, '💯 О нас', null, 4, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (11, '💯 Біз туралы', null, 4, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (11, '💯 About us', null, 4, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (12, '<b>Выберите интересующую вас информацию о структуре</b> ⬇️', null, 5, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (12, '<b>Select the structure information you are interested in</b> ⬇️', null, 5, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (12, '<b>Сізді қызықтыратын құрылым туралы ақпаратты таңдаңыз</b> ⬇️', null, 5, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (13, concat('<b>Сапаров Ныгмеджан Мухамеджанович</b>',STRINGDECODE('\n'),'Руководитель Департамента Агентства Республики Казахстан по противодействию коррупции (Антикоррупционной службы) по г. Алматы',STRINGDECODE('\n'),'Телефон: 278-75-78'), null, 1006, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (13, concat('<b>Сапаров Нығмеджан Мұхамеджанұлы</b>',STRINGDECODE('\n'),'Қазақстан Республикасы Сыбайлас жемқорлыққа қарсы іс-қимыл Агенттігінің (Сыбайлас жемқорлыққа қарсы қызмет)  Алматы қаласы бойынша департаменті басшысы', STRINGDECODE('\n'),'Телефон: 278-75-78'), null, 1006, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (13, concat('<b>Saparov Nygmedzhan Mukhamedzhanovich</b>',STRINGDECODE('\n'),'Head of the Department of the anti-corruption Agency of the Republic of Kazakhstan (Anti-Corruption service) in Almaty',STRINGDECODE('\n'),'Phone: 278-75-78'), null, 1006, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (14, concat('<b>Таумурат Данияр Таумуратович</b>',stringdecode('\n'),'Первый заместитель руководителя Департамента Агентства Республики Казахстан по противодействию коррупции (Антикоррупционной службы) по г. Алматы, курирующий Управление превенции и добропорядочности',STRINGDECODE('\n'),'Телефон: 278-74-94'), null, 1006, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (14, concat('<b>Таумұрат Данияр Таумұратұлы</b>', stringdecode('\n'),'Қазақстан Республикасы Сыбайлас жемқорлыққа қарсы іс-қимыл Агенттігінің (Сыбайлас жемқорлыққа қарсы қызмет)  Алматы қаласы бойынша департаменті басшысының бірінші орынбасары. Превенция және парасаттылық басқармасына жетекшілік етеді.',STRINGDECODE('\n'),'Телефон: 278-74-94'), null, 1006, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (14, concat('<b>Taumurat Daniyar Taumuratovich</b>',stringdecode('\n'),'First Deputy head of the Department of the anti-corruption Agency of the Republic of Kazakhstan (Anti-Corruption service) in Almaty, supervising the Department of prevention and integrity',STRINGDECODE('\n'),'Phone: 278-74-94'), null, 1006, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (15, concat('<b>Башев Талгат Мамырбекович </b>',stringdecode('\n'),'Заместитель руководителя Департамента Агентства Республики Казахстан по противодействию коррупции (Антикоррупционной службы) по г. Алматы',STRINGDECODE('\n'),'Телефон: 278-73-33'), null, 1006, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (15, concat('<b>Башев Талғат Мамырбекұлы </b>',stringdecode('\n'),'Қазақстан Республикасы Сыбайлас жемқорлыққа қарсы іс-қимыл Агенттігінің (Сыбайлас жемқорлыққа қарсы қызмет) Алматы қаласы бойынша департаменті басшысыныңорынбасары.',STRINGDECODE('\n'),'Телефон: 278-73-33'), null, 1006, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (15, concat('<b>Bashev Talgat Mamyrbekovich</b>',stringdecode('\n'),'Deputy head of the Department of the anti-corruption Agency of the Republic of Kazakhstan (Anti-Corruption service) in Almaty',STRINGDECODE('\n'),'Phone: 278-73-33'), null, 1006, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (16, 'Заместитель руководителя Департамента Агентства Республики Казахстан по противодействию коррупции (Антикоррупционной службы) по г. Алматы', null, 1006, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (16, 'Қазақстан Республикасы Сыбайлас жемқорлыққа қарсы іс-қимыл Агенттігінің (Сыбайлас жемқорлыққа қарсы қызмет) Алматы қаласы бойынша департаменті басшысының орынбасары.', null, 1006, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (16, 'Deputy head of the Department of the anti-corruption Agency of the Republic of Kazakhstan (Anti-Corruption service) in Almaty', null, 1006, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (17, concat('<b>Адрес : </b>Жибек-жолы проспект, 15 (уг.ул Барибаева)', stringdecode('\n'), '<b>Тел./факс : </b>278-73-24(канцелярия)', stringdecode('\n'), '<b>Почта : </b>almaty@nab.gov.kz'), null, 6, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (17, concat('<b>Мекенжай : </b>Жібек-жолы даңғылы, 15 (Бәрібаев көшесі)', stringdecode('\n'), '<b>Тел./факс : </b>278-73-24(кеңсе)', stringdecode('\n'), '<b>Пошта : </b>almaty@nab.gov.kz'), null, 6, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (17, concat('<b>Address : </b>Zhibek-Zholy prospect, 15', stringdecode('\n'), '<b>Phone / Fax : </b>278-73-24 (office)', stringdecode('\n'), '<b>Email : </b>almaty@nab.gov.kz'), null, null, 6, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (18, '<i><b>Для перехода нажмите на кнопку ⬇️</b></i>', null, 7, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (18, '<i><b>Өту үшін түймесін басыңыз ⬇️</b></i>', null, 7, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (18, '<i><b>Click on the button to proceed ⬇️</b></i>', null, 7, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (19, concat('<i><b>CALL ЦЕНТР – 1424 </b></i>', stringdecode('\n'),
'Основной задачей cаll-центра является бесплатная консультационная поддержка по вопросам противодействия коррупции и прием телефонных сообщении о коррупционных правонарушениях.', stringdecode('\n'),
'<b>Прием сообщений:</b>', stringdecode('\n'), '- о коррупционных фактах, в том числе о совершенных или готовящихся коррупционных правонарушениях;', stringdecode('\n'),
'- о незаконных действиях (бездействиях) сотрудников Антикоррупционной службы;', stringdecode('\n'), '- касательно вопросов воспрепятствования предпринимательской деятельности;', stringdecode('\n'),
'- о сведениях по разыскиваемым лицам Антикоррупционной службой;', stringdecode('\n'), '- отклики, предложения.', stringdecode('\n'),'<b>Консультирование граждан по вопросам:</b>', stringdecode('\n'),
'- о ходе рассмотрения заявлений и сообщений, находящихся в производстве Антикоррупционной службы;', stringdecode('\n'), '- поощрения лиц, сообщивших о факте коррупции;', stringdecode('\n'),
'- поступление в антикоррупционную службу;', stringdecode('\n'), '- иные вопросы, входящие в компетенцию Антикоррупционной службы.', stringdecode('\n'), '<b>График работы:</b>', stringdecode('\n'),
'Круглосуточно, ежедневно.'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (19, concat('<i><b>1424 -  CALL ОРТАЛЫҒЫ </b></i>', stringdecode('\n'),
'Сall-орталықтың негізгі міндеті сыбайлас жемқорлыққа қарсы іс-қимыл мәселелері бойынша азаматтарды тегін консультациялық қолдау және сыбайлас жемқорлық құқық бұзушылықтар туралы телефон хабарламаларын қабылдау болып табылады.', stringdecode('\n'),
'<b>Хабарламаларды қабылдау:</b>', stringdecode('\n'), '- сыбайлас жемқорлық фактілері туралы, соның ішінде жасалған немесе дайындалып жатқан;', stringdecode('\n'),
'- сыбайллас жемқорлыққа қарсы қызмет қызметкерлерінің заңсыз әрекеттері (әрекетсіздігі) туралы;', stringdecode('\n'), '-кәсіпкерлік қызметке кедергі жасау мәселелеріне қатысты;', stringdecode('\n'),
'- сыбайлас жемқорлыққа қарсы қызметпен іздеудегі тұлғалар бойынша мәліметтер туралы;', stringdecode('\n'), '- пікірлер, ұсыныстар.', stringdecode('\n'),'<b>Азаматтарға кеңес беру:</b>', stringdecode('\n'),
'- өтініштер мен хабарламаларды қарау барысы туралы;', stringdecode('\n'), '- сыбайлас жемқорлық фактісі туралы хабарлаған адамдарды көтермелеу;', stringdecode('\n'),
'- сыбайлас жемқорлыққа қарсы қызметі жұмысына орналастыру бойынша;', stringdecode('\n'), '- сыбайлас жемқорлыққа қарсы қызметтің құзыретіне кіретін өзге де мәселелер.', stringdecode('\n'), '<b>Жұмыс уақыты: </b>', stringdecode('\n'),
'Тәулік бойы, күнделікті.'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (19, concat('<i><b>CALL CENTER-1424</b></i>', stringdecode('\n'),
'The call center provides free consultation support to citizens on anti-corruption issues and receiving phone messages about corruption offenses.', stringdecode('\n'),
'<b>Receiving messages:</b>', stringdecode('\n'), '- about corruption facts, including about committed or upcoming corruption offenses;', stringdecode('\n'),
'- about illegal actions (omissions) of employees of the anti-Corruption service;', stringdecode('\n'), '- regarding the questions of obstruction of business activities;', stringdecode('\n'),
'- information on wanted persons by the anti-Corruption service;', stringdecode('\n'), '- feedback, suggestions.', stringdecode('\n'),'<b>Advising citizens on the following issues:</b>', stringdecode('\n'),
'- on the progress of consideration of applications and the message ;', stringdecode('\n'), '- encouragement of persons who reported the fact of corruption;', stringdecode('\n'),
'- admission to the anti-corruption service;', stringdecode('\n'), '- other issues within the competence of the anti-Corruption service.', stringdecode('\n'), '<b>Work schedule: </b>', stringdecode('\n'),
'Around the clock, every day.'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (20, 'ℹ️Полезные информации', null, 8, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (20, 'ℹ️Пайдалы ақпараттар', null, 8, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (20, 'ℹ️Useful information', null, 8, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (21, '🗂️ Проекты', null, 9, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (21, '🗂️ Жобалар', null, 9, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (21, '🗂️ Projects', null, 9, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (22, concat('<b>САНАЛЫ УРПАК</b>', stringdecode('\n'), '<b>Цель:</b>', stringdecode('\n') , 'Искоренение коррупции в системе образования, формирование среды всеобщего неприятия коррупции через систему образования'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (22, concat('<b>САНАЛЫ ҰРПАҚ</b>', stringdecode('\n'), '<b>Мақсаты:</b>', stringdecode('\n'), 'Білім беру жүйесіндегі сыбайласжемқорлықты жою, білім беру жүйесі арқылы сыбайлас жемқорлықты жалпыға бірдей қабылдамау ортасын қалыптастыру'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (22, concat('<b>SANALY URPAQ</b>', stringdecode('\n'), '<b>Goal:</b>', stringdecode('\n'), 'to eliminate corruption in the education system, creating an environment of universal rejection of corruption through the education system'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (23, concat('<b>ЗАЩИТА БИЗНЕСА И ИНВЕСТИЦИЙ </b>', stringdecode('\n'), '<b>Цель:</b>', stringdecode('\n') , 'создание благоприятного инвестиционного климата и повышения доверия бизнеса и инвесторов к институтам государственной власти.'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (23, concat('<b>БИЗНЕСТІ ЖӘНЕ ИНВЕСТИЦИЯЛАРДЫ ҚОРҒАУ</b>', stringdecode('\n'), '<b>Мақсаты:</b>', stringdecode('\n'), 'қолайлы инвестициялық ахуал жасау және бизнес пен инвесторлардың мемлекеттік билік институттарына сенімін арттыру.'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (23, concat('<b>PROTECTING BUSINESS AND INVESTMENTS</b>', stringdecode('\n'), '<b>Goal:</b>', stringdecode('\n'), 'to create a favorable investment climate and increase the confidence of business and investors in the institutions of state power.'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (24, concat('<b>ИНТЕРАКТИВНАЯ КАРТА ОТКРЫТЫХ БЮДЖЕТОВ</b>', stringdecode('\n'), 'Карта в режиме реального времени отображает детальные сведения о выделенных бюджетных средствах на строительство, ремонт и содержание социальных объектов города Алматы.', stringdecode('\n') , 'официальный сайт: <b>publicbudget.kz</b>'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (24, concat('<b>АШЫҚ БЮДЖЕТТЕРДІҢ ИНТЕРАКТИВТІ КАРТАСЫ</b>', stringdecode('\n'), 'Карта нақты уақыт режимінде Алматы қаласының әлеуметтік объектілерін салуға, жөндеуге және ұстауға бөлінген бюджет қаражаты туралы егжей-тегжейлі мәліметтерді көрсетеді', stringdecode('\n'), 'ресми сайт: <b>publicbudget.kz</b>'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (24, concat('<b>INTERACTIVE MAP OF OPEN BUDGETS</b>', stringdecode('\n'), 'The map displays detailed information about the allocated budget funds for the construction, repair and maintenance of social facilities in Almaty in real time', stringdecode('\n'), 'official site: <b>publicbudget.kz</b>'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (25, concat('<b>СПЕЦИАЛЬНАЯ МОНИТОРИНГОВАЯ ГРУППА </b>', stringdecode('\n'), '<b>Цель:</b>', stringdecode('\n') , 'анализ и мониторинг коррупционных рисков в различных сферах деятельности, выявление «болевых точек»'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (25, concat('<b>АРНАЙЫ МОНИТОРИНГТІК ТОП </b>', stringdecode('\n'), '<b>Мақсаты:</b>', stringdecode('\n'), 'әр түрлі қызметтің салаларындағы сыбайлас жемқорлық тәуекелдерін талдау және мониторингілеу'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (25, concat('<b>SPECIAL MONITORING GROUP </b>', stringdecode('\n'), '<b>Goal:</b>', stringdecode('\n'), 'analysis and monitoring of corruption risks in various areas of activity'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (26, concat('<b>САПАЛЫ ЖОЛ </b>', stringdecode('\n'), '<b>Цель:</b>', stringdecode('\n') , 'проведение экспертизы качества работ и материалов при строительстве, реконструкции, ремонте и содержании автомобильных дорог'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (26, concat('<b>САПАЛЫ ЖОЛ </b>', stringdecode('\n'), '<b>Мақсаты:</b>', stringdecode('\n'), 'автомобиль жолдарын салу, қайта жаңарту, жөндеу және күтіп ұстау кезінде жұмыстар мен материалдардың сапасына сараптама жүргізу'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (26, concat('<b>SAPALY JOL </b>', stringdecode('\n'), '<b>Goal:</b>', stringdecode('\n'), 'conducting an expert examination of the quality of works and materials in the construction, reconstruction, repair and maintenance of highways'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (27, concat('<b>АДАЛ ЖОЛ </b>', stringdecode('\n'), '<b>Цель:</b>', stringdecode('\n') , 'исключение бытовой коррупции в пассажирских и грузовых железнодорожных перевозках, создание принципа прозрачности при покупке билетов, борьба с недобросовестными перекупщиками билетов'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (27, concat('<b>АДАЛ ЖОЛ </b>', stringdecode('\n'), '<b>Мақсаты:</b>', stringdecode('\n'), 'жолаушылар және жүк теміржол тасымалдарындағы тұрмыстық сыбайлас жемқорлықты жою, билеттерді сатып алу кезінде ашықтық қағидатын құру, билеттерді жосықсыз сатып алушылармен күрес жүргізу'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (27, concat('<b>ADAL JOL </b>', stringdecode('\n'), '<b>Goal:</b>', stringdecode('\n'), 'elimination of domestic corruption in passenger and freight rail transport, creation of the principle of transparency when purchasing tickets, fight against unscrupulous ticket dealers'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (28, concat('<b>АКСЕЛЕРАТОР ДОБРА: ІЗГІЛІК ЕЛШІСІ</b>', stringdecode('\n'), '<b>Цель:</b>', stringdecode('\n') , 'формирование правовой культуры среди населения и предоставление волонтерских услуг в виде оказания юридической и социальной помощи нуждающимся лицам'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (28, concat('<b>ІЗГІЛІК ЕЛШІСІ : АКСЕЛЕРАТОР ДОБРА</b>', stringdecode('\n'), '<b>Мақсаты:</b>', stringdecode('\n'), 'халық арасында құқықтық мәдениетті қалыптастыру және мұқтаж адамдарға құқықтық және әлеуметтік көмек көрсету түрінде волонтерлік қызметтер көрсету'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (28, concat('<b>AKSELERATOR DOBRA: IZGILIK ELShISI</b>', stringdecode('\n'), '<b>Goal:</b>', stringdecode('\n'), 'to create a legal culture among the population and provide volunteer services in the form of legal and social assistance to people'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (29, 'Личный кабинет администратора', null, 10, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (29, 'Личный кабинет администратора', null, 10, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (29, 'Личный кабинет администратора', null, 10, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (30, 'Информация', null, 12, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (30, 'Информация', null, 12, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (30, 'Информация', null, 12, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (31, 'Редактирование', null, 13, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (31, 'Редактирование', null, 13, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (31, 'Редактирование', null, 13, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1001, 'Просим пройти первичную регистрацию. Напишите пожалуйста, своё полное <b> Ф.И.О. </b> ⬇️', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1001, 'Бастапқы тіркеуден өтуіңізді сұраймыз.Жазыңыздар, өтінемін, өзінің толық <b> аты-Жөні </b> ⬇️', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1001, 'Please complete the initial registration.Please write your <b> Full Name </b> ⬇️', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1002, '<i><b>‼️Неверный формат данных</b></i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1002, '<i><b>‼️Деректер пішімі жарамсыз</b></i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1002, '<i><b>‼️Invalid data format</b></i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1003, '<i>Нажмите кнопку </i><b> Отправить контакт </b> ⬇️', null, 1001, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1003, '<i><b>Контактіні Жіберу</b> түймешігін басыңыз</i> ⬇️', null, 1001, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1003, '<i>Click <b>Send contact</b></i> ⬇️', null, 1001, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1004, '<i><b>Обращение :</b> В процессе исполнения</i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1004, '<i><b>Жүгіну :</b> Орындау процесінде</i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1004, '<i><b>Appeal :</b> In the process of execution</i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1005, '<b>Обращение : № </b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1005, '<b>Жүгіну : № </b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1005, '<b>Appeal : № </b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1006, '<b>Ответственный : </b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1006, '<b>Жауапты : </b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1006, '<b>Responsible : </b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1007, '<b>Заявитель : </b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1007, '<b>Өтініш беруші : </b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1007, '<b>Applicant : </b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1008, '<b>Текст обращения : </b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1008, '<b>Өтініш мәтіні : </b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1008, '<b>The text of the appeal : </b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1009, '<b>Дата обращения : </b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1009, '<b>Өтініш берген күні : </b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1009, '<b>Date of request : </b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1010, 'Нажмите <b>📎 Прикрепить файл</b> если хотите отправить фото/видео или <b>➡️ Пропустить </b>если хотите отправить без фото/видео', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1010, 'Нажмите <b>📎 Прикрепить файл</b> если хотите отправить фото/видео или <b>➡️ Пропустить </b>если хотите отправить без фото/видео', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1010, 'Нажмите <b>📎 Прикрепить файл</b> если хотите отправить фото/видео или <b>➡️ Пропустить </b>если хотите отправить без фото/видео', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1011, '<b>Документ отправлен</b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1011, '<b>Құжат жіберілді</b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1011, '<b>The document is sent</b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1012, '<i>Исполнено</i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1012, '<i>Орындалды</i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1012, '<i>Executed</i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1013, '<i>Не исполнено</i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1013, '<i>Орындалған жоқ</i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1013, '<i>Not executed</i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1014, '<i>Здравствуйте, </i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1014, '<i>Cәлеметсіз бе, </i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1014, '<i>Hello, </i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1015, '<i><b>Ответ отправлен</b></i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1015, '<i><b>Жауап жіберілді</b></i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1015, '<i><b>Response sent</b></i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1016, '<i><b>Категория обращения: </b></i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1016, '<i><b>Өтініш санаты: </b></i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1016, '<i><b>Request category: </b></i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1017, '<i><b>Выберите к кому вы хотите записаться ⬇️</b></i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1017, '<i><b>Кімге жазғыңыз келетінін таңдаңыз ⬇️</b></i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1017, '<i><b>Choose who you want to sign up with ⬇️</b></i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1018, 'В строке ввода подробно изложите <b> характер вопроса ⬇️</b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1018, 'Енгізу жолында сұрақтың сипатын егжей-тегжейлі сипаттаңыз ⬇️', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1018, 'In the entry bar, describe the nature of the question in detail ⬇️', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1019, '<i><b>Подтвердите нажав на кнопку «Записаться»</b></i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1019, '<i><b>«Жазылу» батырмасын басу арқылы растаңыз</b></i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1019, '<i><b>Confirm by clicking on the «sign Up» button</b></i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1020, 'Уважаемый (ая), <b>%s</b>! Вы записаны на прием. Благодарим за участие в улучшении качества жизни города Алматы', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1020, 'Құрметті <b>%s</b>! Сіз қабылдауға жазылдыңыз. Алматыдағы өмір сапасын жақсартуға қатысқаныңыз үшін рахмет', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1020, 'Dear <b>%s</b>! You have an appointment. Thank you for your participation in improving the quality of life in Almaty', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1021, '<i><b>Опрос успешно пройден</b></i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1021, '<i><b>Сауалнама сәтті өтті</b></i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1021, '<i><b>The survey was completed successfully</b></i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1022, '<b><i>Оцените оказанную услугу выбрав вариант по кнопкам ниже</i></b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1022, '<b><i>Төмендегі батырмалар бойынша опцияны таңдау арқылы көрсетілген қызметті бағалаңыз</i></b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1022, '<b><i>Evaluate the service provided by selecting the option on the buttons below</i></b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1023, '<i>На Ваше обращение под № </i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1023, '<i>Жазған астында № </i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1023, '<i>To Your request under № </i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1024, '<i> сообщаем следующие: </i>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1024, '<i> келесілерді хабарлаймыз: </i>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1024, '<i> we report the following: </i>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1025, '<b><i> Спасибо за ваш ответ </i></b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1025, '<b><i> Жауап </i></b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1025, '<b><i> Thanks for your reply </i></b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1026, '❌', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1026, '❌', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1026, '❌', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1027, '🔎', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1027, '🔎', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1027, '🔎', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1028, '/del', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1028, '/del', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1028, '/del', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1029, 'Пользователь не зарегистрирован в данном боте', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1029, 'Пользователь не зарегистрирован в данном боте', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1029, 'Пользователь не зарегистрирован в данном боте', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1030, 'Пользователь уже администратор', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1030, 'Пользователь уже администратор', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1030, 'Пользователь уже администратор', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1031, 'Должен быть минимум 1 администратор.', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1031, 'Должен быть минимум 1 администратор.', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1031, 'Должен быть минимум 1 администратор.', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1032, concat('Список администраторов:', stringdecode('\n'), '%s', stringdecode('\n'), stringdecode('\n'), 'Чтобы добавить нового пользователя, отправьте контакт пользователя. Он должен быть зарегистрированным.'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1032, concat('Список администраторов:', stringdecode('\n'), '%s', stringdecode('\n'), stringdecode('\n'), 'Чтобы добавить нового пользователя, отправьте контакт пользователя. Он должен быть зарегистрированным.'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1032, concat('Список администраторов:', stringdecode('\n'), '%s', stringdecode('\n'), stringdecode('\n'), 'Чтобы добавить нового пользователя, отправьте контакт пользователя. Он должен быть зарегистрированным.'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1033, concat('Список категорий:', stringdecode('\n'), stringdecode('\n'), '%s', stringdecode('\n'), '<b>Добавить категорию:</b> чтобы добавить новую категорию нажмите на %s'
, stringdecode('\n'), 'Используйте комманды напротив нужной категорий', stringdecode('\n'), '<b>em</b> - для добавления/удаления ответственного в категорий', stringdecode('\n'), '<b>st</b> - для настройки категорий'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1033, concat('Список категорий:', stringdecode('\n'), stringdecode('\n'), '%s', stringdecode('\n'), '<b>Добавить категорию:</b> чтобы добавить новую категорию нажмите на %s'
    , stringdecode('\n'), 'Используйте комманды напротив нужной категорий', stringdecode('\n'), '<b>em</b> - для добавления/удаления ответственного в категорий', stringdecode('\n'), '<b>st</b> - для настройки категорий'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1033, concat('Список категорий:', stringdecode('\n'), stringdecode('\n'), '%s', stringdecode('\n'), '<b>Добавить категорию:</b> чтобы добавить новую категорию нажмите на %s'
    , stringdecode('\n'), 'Используйте комманды напротив нужной категорий', stringdecode('\n'), '<b>em</b> - для добавления/удаления ответственного в категорий', stringdecode('\n'), '<b>st</b> - для настройки категорий'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1034, '👨‍💼 %s - ⚙️ %s - 🧾 %s.', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1034, '👨‍💼 %s - ⚙️ %s - 🧾 %s.', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1034, '👨‍💼 %s - ⚙️ %s - 🧾 %s.', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1035, concat('<b> О категорий:</b>  🧾 %s', stringdecode('\n'), '<b>Ответственные:</b>', stringdecode('\n'),
'%s', stringdecode('\n'), '<b>Добавить ответственного</b>: %s', stringdecode('\n'), '<b>Вернуться к списку категорий</b>: %s'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1035, concat('<b> О категорий:</b>  🧾 %s', stringdecode('\n'), '<b>Ответственные:</b>', stringdecode('\n'),
'%s', stringdecode('\n'), '<b>Добавить ответственного</b>: %s', stringdecode('\n'), '<b>Вернуться к списку категорий</b>: %s'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1035, concat('<b> О категорий:</b>  🧾 %s', stringdecode('\n'), '<b>Ответственные:</b>', stringdecode('\n'),
'%s', stringdecode('\n'), '<b>Добавить ответственного</b>: %s', stringdecode('\n'), '<b>Вернуться к списку категорий</b>: %s'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1036, concat('<b> О категорий:</b>  🧾 %s', stringdecode('\n\n'), '<b>Текущая версия языка:</b> %s', stringdecode('\n'), '🔁 - %s - <b>чтобы сменить язык</b>', stringdecode('\n\n'),
'🔧 - %s - <b> Изменить наименование</b>', stringdecode('\n'), '❌ - %s - <b>Удалить категорию</b>', stringdecode('\n\n'), '<i>Чтобы добавить ответственного в категорию используйте комманду напротив нужной категорий в меню <b>"список категорий".</b></i>',
stringdecode('\n'), '<b>Вернуться к списку категорий</b>: %s'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1036, concat('<b> О категорий:</b>  🧾 %s', stringdecode('\n\n'), '<b>Текущая версия языка:</b> %s', stringdecode('\n\n'), '🔁 - %s - <b>чтобы сменить язык</b>', stringdecode('\n\n'),
'🔧 - %s - <b> Изменить наименование</b>', stringdecode('\n'), '❌ - %s - <b>Удалить категорию</b>', stringdecode('\n\n'), '<i>Чтобы добавить ответственного в категорию используйте комманду напротив нужной категорий в меню <b>"список категорий".</b></i>',
stringdecode('\n'), '<b>Вернуться к списку категорий</b>: %s'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1036, concat('<b> О категорий:</b>  🧾 %s', stringdecode('\n\n'), '<b>Текущая версия языка:</b> %s', stringdecode('\n\n'), '🔁 - %s - <b>чтобы сменить язык</b>', stringdecode('\n\n'),
'🔧 - %s - <b> Изменить наименование</b>', stringdecode('\n'), '❌ - %s - <b>Удалить категорию</b>', stringdecode('\n\n'), '<i>Чтобы добавить ответственного в категорию используйте комманду напротив нужной категорий в меню <b>"список категорий".</b></i>',
stringdecode('\n'), '<b>Вернуться к списку категорий</b>: %s'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1037, 'Список меню доступных для редактирования:', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1037, 'Список меню доступных для редактирования:', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1037, 'Список меню доступных для редактирования:', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1038, '<b>Ссылки в виде кнопок:</b>', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1038, '<b>Ссылки в виде кнопок:</b>', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1038, '<b>Ссылки в виде кнопок:</b>', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1039, concat('<b>Название кнопки:</b> %s ', stringdecode('\n\n'), '<b>Сообщение:</b>', stringdecode('\n\n'),
'%s  %s', stringdecode('\n\n'), 'Текущая версия для <b>%s</b> языка:', stringdecode('\n\n'), 'Добавьте фото или файл чтобы прикрепить к сообщению. Для редактирования используйте кнопки.'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1039, concat('<b>Название кнопки:</b> %s ', stringdecode('\n\n'), '<b>Сообщение:</b>', stringdecode('\n\n'),
'%s  %s', stringdecode('\n\n'), 'Текущая версия для <b>%s</b> языка:', stringdecode('\n\n'), 'Добавьте фото или файл чтобы прикрепить к сообщению. Для редактирования используйте кнопки.'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1039, concat('<b>Название кнопки:</b> %s ', stringdecode('\n\n'), '<b>Сообщение:</b>', stringdecode('\n\n'),
'%s  %s', stringdecode('\n\n'), 'Текущая версия для <b>%s</b> языка:', stringdecode('\n\n'), 'Добавьте фото или файл чтобы прикрепить к сообщению. Для редактирования используйте кнопки.'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1040, concat('<b>Название кнопки:</b> %s ', stringdecode('\n\n'), '<b>Сообщение:</b>', stringdecode('\n\n'),
'%s', stringdecode('\n\n'), 'Текущая версия для <b>%s</b> языка:', stringdecode('\n\n'), 'Добавьте фото или файл чтобы прикрепить к сообщению. Для редактирования используйте кнопки.'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1040, concat('<b>Название кнопки:</b> %s ', stringdecode('\n\n'), '<b>Сообщение:</b>', stringdecode('\n\n'),
'%s', stringdecode('\n\n'), 'Текущая версия для <b>%s</b> языка:', stringdecode('\n\n'), 'Добавьте фото или файл чтобы прикрепить к сообщению. Для редактирования используйте кнопки.'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1040, concat('<b>Название кнопки:</b> %s ', stringdecode('\n\n'), '<b>Сообщение:</b>', stringdecode('\n\n'),
'%s', stringdecode('\n\n'), 'Текущая версия для <b>%s</b> языка:', stringdecode('\n\n'), 'Добавьте фото или файл чтобы прикрепить к сообщению. Для редактирования используйте кнопки.'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1041, 'Для данной кнопки не предусмотрено сообщение', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1041, 'Для данной кнопки не предусмотрено сообщение', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1041, 'Для данной кнопки не предусмотрено сообщение', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1042, 'Для данной кнопки отсутствует такая возможность', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1042, 'Для данной кнопки отсутствует такая возможность', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1042, 'Для данной кнопки отсутствует такая возможность', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1043, 'Введите название (не более 100 символов).', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1043, 'Введите название (не более 100 символов).', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1043, 'Введите название (не более 100 символов).', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1044, 'Введите новый текст', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1044, 'Введите новый текст', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1044, 'Введите новый текст', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1045, 'Отправьте файл', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1045, 'Отправьте файл', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1045, 'Отправьте файл', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1046, 'Выберите что нужно отредактировать:', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1046, 'Выберите что нужно отредактировать:', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1046, 'Выберите что нужно отредактировать:', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1047, concat('Для изменения названия введите:', stringdecode('\n'), 'name: Новое название',
stringdecode('\n'), 'Для изменения ссылки напишите', stringdecode('\n'), 'link: Новая ссылка'), null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1047, concat('Для изменения названия введите:', stringdecode('\n'), 'name: Новое название',
stringdecode('\n'), 'Для изменения ссылки напишите', stringdecode('\n'), 'link: Новая ссылка'), null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1047, concat('Для изменения названия введите:', stringdecode('\n'), 'name: Новое название',
stringdecode('\n'), 'Для изменения ссылки напишите', stringdecode('\n'), 'link: Новая ссылка'), null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1048, 'Название не может состоять только из цифр, введите новое название.', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1048, 'Название не может состоять только из цифр, введите новое название.', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1048, 'Название не может состоять только из цифр, введите новое название.', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1049, 'Такое название уже используется', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1049, 'Такое название уже используется', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1049, 'Такое название уже используется', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1050, 'Ваш файл успешно отправлен', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1050, 'Ваш файл успешно отправлен', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) VALUES (1050, 'Ваш файл успешно отправлен', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1051, 'Меню управляющих', null, 1009, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1051, 'Меню управляющих', null, 1009, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1051, 'Меню управляющих', null, 1009, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1052, 'Уважаемый %s! Вы записаны на прием к %s, %s %s. Просим Вас подтвердить свое участие?', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1052, 'Уважаемый %s! Вы записаны на прием к %s, %s %s. Просим Вас подтвердить свое участие?', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1052, 'Dear %s! You have an appointment at %s, %s %s. Can you confirm your participation?', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1053, 'Выберите начальную дату, для подробного отчета', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1053, 'Выберите начальную дату, для подробного отчета', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1053, 'Выберите начальную дату, для подробного отчета', null, null, null, null, 3);

insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1054, 'Выберите конечную дату', null, null, null, null, 1);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1054, 'Выберите конечную дату', null, null, null, null, 2);
insert into message(id, name, photo, keyboard_id, file, file_type, language_id) values (1054, 'Выберите конечную дату', null, null, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1, '/start', 2, null, 2, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1, '/start', 2, null, 2, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1, '/start', 2, null, 2, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (2, '🇰🇿 Қазақ тілінде', 3, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (2, '🇰🇿 Қазақ тілінде', 3, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (2, '🇰🇿 Қазақ тілінде', 3, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (3, '🇷🇺 На русском языке', 3, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (3, '🇷🇺 На русском языке', 3, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (3, '🇷🇺 На русском языке', 3, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (4, '🇬🇧 English', 3, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (4, '🇬🇧 English', 3, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (4, '🇬🇧 English', 3, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (5, '📤 Направить обращение', 4, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (5, '📤 Өтініш жіберу', 4, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (5, '📤 Send requests', 4, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (6, '🔊 История обращений', 1, null, 10, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (6, '🔊 Өтініштер тізімі', 1, null, 10, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (6, '🔊 History of requests', 1, null, 10, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (7, '💯 О нас', 1, null, 11, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (7, '💯 Біз туралы', 1, null, 11, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (7, '💯 About us', 1, null, 11, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (8, '🕐 Прием граждан', 6, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (8, '🕐 Азаматтарды қабылдау', 6, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (8, '🕐 Reception of citizens', 6, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (9, '🗣 Пройти экспресс опрос', 7, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (9, '🗣 Экспресс сауалнамаға өту', 7, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (9, '🗣 Go to the Express survey', 7, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (10, '🌐 Новости', 1, null, 18, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (10, '🌐 Жаңалықтар', 1, null, 18, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (10, '🌐 News', 1, null, 18, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (11, 'ℹ️ Полезные информации', 1, null, 20, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (11, 'ℹ️ Пайдалы ақпараттар', 1, null, 20, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (11, 'ℹ️ Useful information', 1, null, 20, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (12, '🔁 Сменить язык', 1, null, 2, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (12, '🔁 Тілді ауыстыру', 1, null, 2, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (12, '🔁 Change language', 1, null, 2, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (14, '✅ Выпoлненные', 5, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (14, '✅ Орындалған', 5, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (14, '✅ Performed', 5, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (15, '❌ Невыпoлненные', 5, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (15, '❌ Орындалмаған', 5, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (15, '❌ Unfulfilled', 5, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (16, '📝 В прoцессе', 5, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (16, '📝 Процесінде', 5, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (16, '📝 In process', 5, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (17, '🔙 Назад в меню', 1, null, 3, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (17, '🔙 Мәзірге оралу', 1, null, 3, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (17, '🔙 Back to menu', 1, null, 3, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (18, '⬅️Hазад', 0, null, null, 1); // 1 пробел
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (18, '⬅️Артқа', 0, null, null, 2); // 1 пробел
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (18, '⬅️This ago', 0, null, null, 3); // 1 пробел

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (19, '🗄 Структура', 1, null, 12, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (19, '🗄 Құрылым', 1, null, 12, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (19, '🗄 Structure', 1, null, 12, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (20, '☎️Контакты', 1, null, 17, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (20, '☎️Байланыс ақпараты', 1, null, 17, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (20, '☎️Contacts', 1, null, 17, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (21, 'Руководитель депар...', 1, null, 13, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (21, 'Департамент басшыс...', 1, null, 13, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (21, 'Head of the Depart...', 1, null, 13, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (22, 'Первый заместитель руковод...', 1, null, 14, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (22, 'Департамент басшысының бір...', 1, null, 14, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (22, 'First Deputy head of the D...', 1, null, 14, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (23, 'Заместитель руководителя депар...', 1, null, 15, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (23, 'Департамент басшысының орынбас... ', 1, null, 15, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (23, 'Deputy head of the Department', 1, null, 15, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (24, ' Заместитель руководителя депар...', 1, null, 16, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (24, ' Департамент басшысының орынбас... ', 1, null, 16, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (24, ' Deputy head of the Department', 1, null, 16, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (25, '⬅️ Hазад', 1, null, 12, 1); // 2 пробелa
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (25, '⬅️ Артқа', 1, null, 12, 2); // 2 пробелa
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (25, '⬅️ This ago', 1, null, 12, 3); // 2 пробелa

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (26, '⚖️Call-центр 1424', 1, null, 19, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (26, '⚖️Call-орталық 1424', 1, null, 19, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (26, '⚖️Call-center 1424', 1, null, 19, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (27, '🗂️ Проекты', 1, null, 21, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (27, '🗂️ Жобалар', 1, null, 21, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (27, '🗂️ Projects', 1, null, 21, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (28, 'Саналы урпак', 1, null, 22, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (28, 'Саналы ұрпақ', 1, null, 22, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (28, 'Sanaly urpaq', 1, null, 22, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (29, 'Защита бизнеса и инвестиций', 1, null, 23, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (29, 'Бизнесті және инвестицияларды қорғау', 1, null, 23, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (29, 'Protecting business and investments', 1, null, 23, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (30, 'Интерактивная карта открытых бюджетов', 1, null, 24, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (30, 'Ашық бюджттердің интерактивті картасы', 1, null, 24, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (30, 'Interactive map of open budgets', 1, null, 24, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (31, 'Специальная мониторинговая группа', 1, null, 25, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (31, 'Арнайы мониторингтік топ', 1, null, 25, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (31, 'Special monitoring group', 1, null, 25, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (32, 'Сапалы жол', 1, null, 26, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (32, 'Сапалы жол', 1, null, 26, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (32, 'Sapaly jol', 1, null, 26, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (33, 'Адал жол', 1, null, 27, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (33, 'Адал жол', 1, null, 27, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (33, 'Adal jol', 1, null, 27, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (34, 'Акселератор добра: ізгілік елшісі', 1, null, 28, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (34, 'Ізгілік елшісі : Акселератор добра', 1, null, 28, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (34, 'Akselerator dobra: izgilik elshisi', 1, null, 28, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (35, '/admin', 9, null, 29, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (35, '/admin', 9, null, 29, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (35, '/admin', 9, null, 29, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (36, '📑 Информация', 9, null, 30, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (36, '📑 Информация', 9, null, 30, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (36, '📑 Информация', 9, null, 30, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (37, '🔧 Редактирование', 9, null, 31, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (37, '🔧 Редактирование', 9, null, 31, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (37, '🔧 Редактирование', 9, null, 31, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (38, 'Отчет по обращениям', 10, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (38, 'Отчет по обращениям', 10, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (38, 'Отчет по обращениям', 10, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (39, 'Редактор админов', 11, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (39, 'Редактор админов', 11, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (39, 'Редактор админов', 11, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (40, 'Редактор обращении', 12, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (40, 'Редактор обращении', 12, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (40, 'Редактор обращении', 12, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (41, 'Редактор меню', 13, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (41, 'Редактор меню', 13, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (41, 'Редактор меню', 13, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (42, 'Изменить название кнопки', 0, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (42, 'Изменить название кнопки', 0, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (42, 'Изменить название кнопки', 0, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (43, 'Изменить сообщение', 0, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (43, 'Изменить сообщение', 0, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (43, 'Изменить сообщение', 0, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (44, '✅ Добавить файл', 0, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (44, '✅ Добавить файл', 0, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (44, '✅ Добавить файл', 0, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (45, '❌ Удалить файл', 0, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (45, '❌ Удалить файл', 0, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (45, '❌ Удалить файл', 0, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (46, '🔄 Сменить язык', 0, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (46, '🔄 Сменить язык', 0, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (46, '🔄 Сменить язык', 0, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (47, '🔜 Далее', 0, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (47, '🔜 Далее', 0, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (47, '🔜 Далее', 0, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (48, '🔚 Назад в админку', 9, null, 29, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (48, '🔚 Назад в админку', 9, null, 29, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (48, '🔚 Назад в админку', 9, null, 29, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (49, '/photo', 14, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (49, '/photo', 14, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (49, '/photo', 14, null, null, 3);

insert into button(id, name, command_id, url, request_contact, message_id, lang_id) VALUES (1001, '↪️Направить контактный номер', null, null, true, null, 1);
insert into button(id, name, command_id, url, request_contact, message_id, lang_id) VALUES (1001, '↪️Байланыс нөмірін жіберу', null, null, true, null, 2);
insert into button(id, name, command_id, url, request_contact, message_id, lang_id) VALUES (1001, '↪️Send a contact number', null, null, true, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1002, '✅  Выполнено', 5, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1002, '✅  Орындалды', 5, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1002, '✅  Done', 5, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1003, '❌  Не выполнено', 5, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1003, '❌  Орындалмады', 5, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1003, '❌  Not completed', 5, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1004, '📎 Прикрепить файл', 0, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1004, '📎 Файлды тіркеу', 0, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1004, '📎 Attachment', 0, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1005, '➡️Пропустить', 0, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1005, '➡️Өткізіп жіберу', 0, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1005, '➡️Miss', 0, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1006, '➡️Завершить', 0, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1006, '➡️Аяқтау', 0, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1006, '➡️Complete', 0, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1007, '✅ Записаться', 0, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1007, '✅ Жазылу', 0, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1007, '✅ Sign up', 0, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1008, '👍🏻 Отлично', 5, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1008, '👍🏻 Өте жақсы', 5, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1008, '👍🏻 Excellent', 5, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1009, '🤝 Хорошо', 5, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1009, '🤝 Жақсы', 5, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1009, '🤝 well', 5, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1010, '👎🏻 Удовлетварительно', 5, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1010, '👎🏻 Қанағаттанарлық', 5, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1010, '👎🏻 Satisfactorily', 5, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1011, '🖥 Сайт', null, 'https://www.gov.kz/memleket/entities/anticorruption?lang=kk', null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1011, '🖥 Сайт', null, 'https://www.gov.kz/memleket/entities/anticorruption?lang=kk', null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1011, '🖥 Site', null, 'https://www.gov.kz/memleket/entities/anticorruption?lang=kk', null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1012, '🌏 Карта', 8, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1012, '🌏 Карта', 8, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1012, '🌏 Map', 8, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1013, '🤙🏻 Facebook', null, 'https://www.facebook.com/anticorruptionalmaty', null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1013, '🤙🏻 Facebook', null, 'https://www.facebook.com/anticorruptionalmaty', null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1013, '🤙🏻 Facebook', null, 'https://www.facebook.com/anticorruptionalmaty', null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1014, '📸 Instagram', null, 'https://www.instagram.com/almatyanticorruption/', null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1014, '📸 Instagram', null, 'https://www.instagram.com/almatyanticorruption/', null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) VALUES (1014, '📸 Instagram', null, 'https://www.instagram.com/almatyanticorruption/', null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) values (1015, '/menu', 15, null, 1051, 1);
insert into button(id, name, command_id, url, message_id, lang_id) values (1015, '/menu', 15, null, 1051, 2);
insert into button(id, name, command_id, url, message_id, lang_id) values (1015, '/menu', 15, null, 1051, 3);

insert into button(id, name, command_id, url, message_id, lang_id) values (1016, 'Отправить напоминание', 16, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) values (1016, 'Отправить напоминание', 16, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) values (1016, 'Отправить напоминание', 16, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) values (1017, 'Отчет зарегистрированых', 17, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) values (1017, 'Отчет зарегистрированых', 17, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) values (1017, 'Отчет зарегистрированых', 17, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) values (1018, '✅ Подтвердить', 18, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) values (1018, '✅ Подтвердить', 18, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) values (1018, '✅ Confirm', 18, null, null, 3);

insert into button(id, name, command_id, url, message_id, lang_id) values (1019, '❌ Отказаться', 18, null, null, 1);
insert into button(id, name, command_id, url, message_id, lang_id) values (1019, '❌ Отказаться', 18, null, null, 2);
insert into button(id, name, command_id, url, message_id, lang_id) values (1019, '❌ Refuse', 18, null, null, 3);