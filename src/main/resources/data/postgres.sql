-- When create a table in Postgres, please check that is that name is used in another table or not. Example user is used in PostgreSQL. If you still like to use the same name, you have to put it in a quote mark
-- Name	Storage Size	Range
-- SMALLSERIAL	2 bytes	1 to 32,767
-- SERIAL	4 bytes	1 to 2,147,483,647
-- BIGSERIAL	8 bytes	1 to 9,223,372,036,854,775,807

-- list all sequences
SELECT * FROM information_schema.sequences;
-- drop a sequences
DROP SEQUENCE IF EXISTS sequences-name
-- drop all tables
DROP TABLE IF EXISTS ibiza_answer, ibiza_user, ibiza_questionary, ibiza_question_type, ibiza_question;
-- create table answer
CREATE SEQUENCE ibiza_answer_id_seq;
CREATE TABLE ibiza_answer(
   answer_id integer NOT NULL DEFAULT nextval('ibiza_answer_id_seq') PRIMARY KEY,
   answer text
);

-- create table ibiza_user
CREATE SEQUENCE ibiza_user_id_seq;
CREATE TABLE ibiza_user(
  user_id integer NOT NULL DEFAULT nextval('ibiza_user_id_seq')  PRIMARY KEY,
  username text,
  password text,
  email text
);

-- create table ibiza_questionary
CREATE SEQUENCE ibiza_questionary_id_seq;
CREATE TABLE ibiza_questionary(
   questionary_id integer NOT NULL DEFAULT nextval('ibiza_questionary_id_seq') PRIMARY KEY,
   name text NOT NULL,
   created_date timestamp default now(),
   fk_user_id integer,
   CONSTRAINT questionary_fk_user_id FOREIGN KEY (fk_user_id) REFERENCES ibiza_user (user_id)
);

-- create table ibiza_question_type
CREATE SEQUENCE ibiza_question_type_id_seq;
CREATE TABLE ibiza_question_type(
   question_type_id integer NOT NULL DEFAULT nextval('ibiza_question_type_id_seq') PRIMARY KEY,
   type text NOT NULL
);

-- create table question
CREATE SEQUENCE ibiza_question_id_seq;
CREATE TABLE ibiza_question(
   question_id integer NOT NULL DEFAULT nextval('ibiza_question_id_seq') PRIMARY KEY,
   question text NOT NULL,
   fk_questionary_id integer,
   fk_question_type_id integer,
   CONSTRAINT question_fk_questionary_id FOREIGN KEY (fk_questionary_id) REFERENCES ibiza_questionary (questionary_id),
   CONSTRAINT question_fk_question_type_id FOREIGN KEY (fk_question_type_id) REFERENCES ibiza_question_type (question_type_id)
);

-- insert testing data
INSERT INTO ibiza_answer (answer) VALUES ('Kyllä'), ('Ei'), ('Ei koske minua');
INSERT INTO ibiza_user (username) VALUES ('user1'), ('user2'), ('user3');
INSERT INTO ibiza_question_type (type) VALUES ('Avoin palaute'), ('Suosittelukysymys'), ('Monivalintakysymys');
INSERT INTO ibiza_questionary(name, fk_user_id) VALUES ('Kysely 1',1), ('Kysely 2',2), ('Kysely 3',3);
INSERT INTO ibiza_question (question, fk_questionary_id, fk_question_type_id) VALUES ('Question 1', 1,1), ('Question 2', 1, 2), ('Question 3',1, 3);
INSERT INTO ibiza_question (question, fk_questionary_id, fk_question_type_id) VALUES ('Question 23',2, 2), ('Question 24', 2, 1), ('Question 25',2, 3);
INSERT INTO ibiza_question (question, fk_questionary_id, fk_question_type_id) VALUES ('Question 31', 3, 3), ('Question 32', 3, 2), ('Question 33',3, 1);
