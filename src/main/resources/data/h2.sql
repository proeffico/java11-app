-- 1. create table answer for testing
CREATE SCHEMA IF NOT EXISTS testdb;
DROP TABLE IF EXISTS answer;
 
CREATE TABLE answer (answer_id INT AUTO_INCREMENT  PRIMARY KEY, answer TEXT NOT NULL);
-- insert testing data
INSERT INTO answer (answer) VALUES ('Kyllä'), ('Ei'), ('Ei koske minua');

SELECT * FROM answer;

-- 2. create table question_type
DROP TABLE IF EXISTS question_type;
 
CREATE TABLE question_type (question_type_id INT AUTO_INCREMENT PRIMARY KEY, type TEXT NOT NULL);
 
INSERT INTO question_type (type) VALUES ('Monivalintakysymys'), ('Suosittelukysymys'), ('Avoin palaute kysymys');

SELECT * FROM question_type;

-- 3. create table questionary
DROP TABLE IF EXISTS questionary;
CREATE TABLE questionary (questionary_id INT AUTO_INCREMENT  PRIMARY KEY, name TEXT NOT NULL);
INSERT INTO questionary (name) VALUES ('Kysely 1'), ('Kysely 2'), ('Kysely 2');


-- 4. create table question 
DROP TABLE IF EXISTS question;
CREATE TABLE question (
  question_id INT AUTO_INCREMENT  PRIMARY KEY,
  question TEXT NOT NULL,
  fk_question_type_id INT,
  fk_questionary_id INT,
  FOREIGN KEY (fk_question_type_id) REFERENCES question_type (question_type_id),
  FOREIGN KEY (fk_questionary_id) REFERENCES questionary (questionary_id)
);
 
INSERT INTO question (question, fk_question_type_id, fk_questionary_id) VALUES ('Question 1', 1, 2), ('Question 2', 1, 3), ('Question 2', 1, 2), ('Question 2', 1, 1), ('Question 3', 2, 3);
INSERT INTO question (question, fk_question_type_id, fk_questionary_id) VALUES ('Question 1', 1, 1), ('Question 1', 2, 1), ('Question 1', 3, 1);
SELECT * FROM question;