-- create table answer

CREATE TABLE answer(
   answer_id serial PRIMARY KEY,
   answer text NOT NULL
);

-- create table questionary
CREATE TABLE questionary(
   questionary_id serial PRIMARY KEY,
   name text NOT NULL
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
   fk_question_type_id serial,
   CONSTRAINT question_fk_questionary_id FOREIGN KEY (fk_questionary_id) REFERENCES questionary (questionary_id),
   CONSTRAINT question_fk_question_type_id FOREIGN KEY (fk_question_type_id) REFERENCES question_type (question_type_id)
);



-- insert testing data
INSERT INTO answer (answer) VALUES ('Kyllä'), ('Ei'), ('Ei koske minua');
INSERT INTO question_type (type) VALUES ('Avoin palaute'), ('Suosittelukysymys'), ('Monivalintakysymys');
INSERT INTO question (question, fk_questionary_id) VALUES ('Question 1', 1), ('Question 2', 1), ('Question 3',1);
INSERT INTO questionary(name) VALUES ('Kysely 1'), ('Kysely 2'), ('Kysely 3');
INSERT INTO question (question, fk_question_type_id, fk_questionary_id) VALUES ('Question 1', 1, 2), ('Question 2', 1, 3), ('Question 2', 1, 2), ('Question 2', 1, 1), ('Question 3', 2, 3);
