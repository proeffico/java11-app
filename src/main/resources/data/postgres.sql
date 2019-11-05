-- Name	Storage Size	Range
-- SMALLSERIAL	2 bytes	1 to 32,767
-- SERIAL	4 bytes	1 to 2,147,483,647
-- BIGSERIAL	8 bytes	1 to 9,223,372,036,854,775,807

-- list all sequences
SELECT * FROM information_schema.sequences;
-- drop a sequences
DROP SEQUENCE IF EXISTS sequences-name
-- drop all tables
DROP TABLE IF EXISTS answer, "user", questionary, question_type, question;
-- create table answer
CREATE SEQUENCE answer_id_seq;
CREATE TABLE answer(
   answer_id integer NOT NULL DEFAULT nextval('answer_id_seq') PRIMARY KEY,
   answer text
);

-- create table user
CREATE SEQUENCE user_id_seq;
CREATE TABLE "user"(
  user_id integer NOT NULL DEFAULT nextval('user_id_seq')  PRIMARY KEY,
  username text,
  password text,
  email text
);

-- create table questionary
CREATE SEQUENCE questionary_id_seq;
CREATE TABLE questionary(
   questionary_id integer NOT NULL DEFAULT nextval('questionary_id_seq') PRIMARY KEY,
   name text NOT NULL,
   created_date timestamp default now(),
   fk_user_id integer,
   CONSTRAINT questionary_fk_user_id FOREIGN KEY (fk_user_id) REFERENCES "user" (user_id)
);

-- create table question_type
CREATE SEQUENCE question_type_id_seq;
CREATE TABLE question_type(
   question_type_id integer NOT NULL DEFAULT nextval('question_type_id_seq') PRIMARY KEY,
   type text NOT NULL
);

-- create table question
CREATE SEQUENCE question_id_seq;
CREATE TABLE question(
   question_id integer NOT NULL DEFAULT nextval('question_id_seq') PRIMARY KEY,
   question text NOT NULL,
   fk_questionary_id integer,
   fk_question_type_id integer,
   CONSTRAINT question_fk_questionary_id FOREIGN KEY (fk_questionary_id) REFERENCES questionary (questionary_id),
   CONSTRAINT question_fk_question_type_id FOREIGN KEY (fk_question_type_id) REFERENCES question_type (question_type_id)
);

-- insert testing data
INSERT INTO answer (answer) VALUES ('Kyllä'), ('Ei'), ('Ei koske minua');
INSERT INTO "user" (username) VALUES ('user1'), ('user2'), ('user3');
INSERT INTO question_type (type) VALUES ('Avoin palaute'), ('Suosittelukysymys'), ('Monivalintakysymys');
INSERT INTO questionary(name, fk_user_id) VALUES ('Kysely 1',1), ('Kysely 2',2), ('Kysely 3',3);
INSERT INTO question (question, fk_questionary_id, fk_question_type_id) VALUES ('Question 1', 1,1), ('Question 2', 1, 2), ('Question 3',1, 3);
INSERT INTO question (question, fk_questionary_id, fk_question_type_id) VALUES ('Question 23',2, 2), ('Question 24', 2, 1), ('Question 25',2, 3);
INSERT INTO question (question, fk_questionary_id, fk_question_type_id) VALUES ('Question 31', 3, 3), ('Question 32', 3, 2), ('Question 33',3, 1);
