create table TASK (
    ID          INTEGER auto_increment,
    ID_STATUS   INTEGER,
    TASK_TEXT   VARCHAR(10000),
    DATE_BEGIN  TIMESTAMP,
    PEOPLE_ID   BIGINT,
    APPRAISAL   VARCHAR(500),
    HANDLING    INTEGER,
    MESSAGE_ID  INTEGER,
    TIME_TASK   VARCHAR(500),
    constraint TASK_PK primary key (ID)
);

create table TASK_ARCHIVE (
    ID      INTEGER auto_increment,
    TEXT    VARCHAR(10000),
    TASK_ID INTEGER,
    constraint TASK_ARCHIVE_PK primary key (ID)
);

create table FILE (
    ID       INTEGER auto_increment,
    IMG      VARCHAR(5000),
    VIDEO    VARCHAR(5000),
    ID_TASK  INTEGER,
    LOCATION VARCHAR(5000),
    DONE     BOOLEAN,
    constraint FILE_PK primary key (ID)
);

create table EMPLOYEE (
    ID          INTEGER auto_increment,
    EMPLOYEE_ID BIGINT,
    HANDLING    INTEGER,
    constraint EMPLOYEE_PK primary key (ID)
);

create table RECEPTION (
    ID   INT auto_increment,
    NAME VARCHAR(4096),
    LANG_ID INT
);

create table CITIZENS_REGISTRATION (
    ID            INT auto_increment,
    CHAT_ID       BIGINT,
    RECEPTION_ID  INT,
    FULL_NAME     VARCHAR(4096),
    QUESTION      VARCHAR(4096),
    STATUS        VARCHAR(4096),
    DATE          TIMESTAMP,
    CITIZENS_DATE TIMESTAMP,
    CITIZENS_TIME VARCHAR(4096),
    constraint CITIZENS_REGISTRATION_PK primary key (ID)
);

create table CITIZENS_INFO (
    ID       INT auto_increment,
    DATE     TIMESTAMP,
    TIME     VARCHAR(4096),
    constraint CITIZENS_INFO_PK primary key (ID)
);

insert into EMPLOYEE(EMPLOYEE_ID, HANDLING) VALUES (383431601, 1);

insert into RECEPTION(ID, NAME, LANG_ID) VALUES (1, 'Руководитель Департамента', 1);
insert into RECEPTION(ID, NAME, LANG_ID) VALUES (1, 'Департамент басшысы', 2);
insert into RECEPTION(ID, NAME, LANG_ID) VALUES (1, 'Head of department', 3);

insert into RECEPTION(ID, NAME, LANG_ID) VALUES (2, 'Первый заместитель руководителя', 1);
insert into RECEPTION(ID, NAME, LANG_ID) VALUES (2, 'Басшының бірінші орынбасары', 2);
insert into RECEPTION(ID, NAME, LANG_ID) VALUES (2, 'First Deputy Head', 3);

insert into RECEPTION(ID, NAME, LANG_ID) VALUES (3, 'Заместитель руководителя', 1);
insert into RECEPTION(ID, NAME, LANG_ID) VALUES (3, 'Басшының орынбасары', 2);
insert into RECEPTION(ID, NAME, LANG_ID) VALUES (3, 'Deputy Head', 3);