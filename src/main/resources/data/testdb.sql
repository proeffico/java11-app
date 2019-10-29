-- create table answers for testing
CREATE SCHEMA IF NOT EXISTS testdb;
DROP TABLE IF EXISTS testdb.answers;
 
CREATE TABLE answers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  answer TEXT NOT NULL
);
 
INSERT INTO answers (answer) VALUES
  ('Kyllä'),
  ('Ei'),
  ('Ei koske minua');

SELECT * FROM answers;