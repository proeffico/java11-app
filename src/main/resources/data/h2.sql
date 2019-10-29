-- create table answer for testing
CREATE SCHEMA IF NOT EXISTS testdb;
DROP TABLE IF EXISTS testdb.answer;
 
CREATE TABLE answer (id INT AUTO_INCREMENT  PRIMARY KEY, answer TEXT NOT NULL);
 
INSERT INTO answer (answer) VALUES
  ('Kyllä'),
  ('Ei'),
  ('Ei koske minua');

SELECT * FROM answer;


-- create table question for testing
DROP TABLE IF EXISTS testdb.question;
 
CREATE TABLE question (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  question TEXT NOT NULL
);
 
INSERT INTO question (question) VALUES
  ('Question 1'),
  ('Question 2'),
  ('Question 3');

SELECT * FROM question;