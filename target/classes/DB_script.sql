CREATE TABLE USERS
(
USER_ID SERIAL ,
FIRST_NAME character varying(20),
LAST_NAME character varying(20),
PHONE character varying(20),
EMAIL character varying(30),
PASSWORD character varying(20),
CONSTRAINT USERS_PK PRIMARY KEY (USER_ID),
CONSTRAINT USERS_PHONE UNIQUE (PHONE)
);