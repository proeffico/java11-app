-- create table answer
CREATE TABLE answer(
   answer_id serial PRIMARY KEY,
   answer text NOT NULL
);

-- create table user
DROP TABLE IF EXISTS user;

CREATE TABLE "user"(
  user_id serial PRIMARY KEY,
  username text,
  password text,
  email text
);


-- create table questionary
CREATE TABLE questionary(
   questionary_id serial PRIMARY KEY,
   name text NOT NULL,
   created_date timestamp default now(),
   fk_user_id serial,
   CONSTRAINT questionary_fk_user_id FOREIGN KEY (fk_user_id) REFERENCES "user" (user_id)
);

-- create table question_type
CREATE TABLE question_type(
   question_type_id serial PRIMARY KEY,
   type text NOT NULL
);

-- create table question
CREATE TABLE question(
   question_id serial PRIMARY KEY,
   question text NOT NULL,
   fk_questionary_id serial,
   CONSTRAINT question_fk_questionary_id FOREIGN KEY (fk_questionary_id) REFERENCES questionary (questionary_id)
);



-- insert testing data
INSERT INTO answer (answer) VALUES ('Kyllä'), ('Ei'), ('Ei koske minua');
INSERT INTO "user" (username) VALUES ('user1'), ('user2'), ('user3');
INSERT INTO question_type (type) VALUES ('Avoin palaute'), ('Suosittelukysymys'), ('Monivalintakysymys');
INSERT INTO questionary(name, fk_user_id) VALUES ('Kysely 1',1), ('Kysely 2',2), ('Kysely 3',3);
INSERT INTO question (question, fk_questionary_id) VALUES ('Question 1', 1), ('Question 2', 1), ('Question 3',1);
