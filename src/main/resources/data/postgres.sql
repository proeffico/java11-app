-- create table answer
CREATE TABLE answer(
   id serial PRIMARY KEY,
   answer text NOT NULL
);

-- create table question
CREATE TABLE question(
   id serial PRIMARY KEY,
   question text NOT NULL
);

-- create table questionary
CREATE TABLE questionary(
   id serial PRIMARY KEY,
   name text NOT NULL,
   fk_question_id serial,
   CONSTRAINT questionary_fk_question_id FOREIGN KEY (fk_question_id) REFERENCES question (id) MATCH SIMPLE
   ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- insert testing data
INSERT INTO answer (answer) VALUES ('Kyllä'), ('Ei'), ('Ei koske minua');
INSERT INTO question (question) VALUES ('Question 1'), ('Question 2'), ('Question 3');