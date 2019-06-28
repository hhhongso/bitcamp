CREATE TABLE student(
	no number(3) primary key,
	age varchar2(100), 
	name varchar2(100),
	hakbun varchar2(100)	
)
INSERT INTO STUDENT(no, age, name, hakbun) values(1, '23', 'È«±æµ¿', '2019')
SELECT NO, AGE, NAME, HAKBUN FROM STUDENT
DELETE FROM STUDENT
DROP TABLE STUDENT 

CREATE TABLE professor(
	no number(3) primary key,
	age varchar2(100),
	name varchar2(100),
	subject varchar2(100)
)

INSERT INTO PROFESSOR(NO, AGE, NAME, SUBJECT) values(1, '60', '±³¼ö´Ô', 'ÀÚ¹Ù')
SELECT NO, AGE, NAME, SUBJECT FROM PROFESSOR
DROP TABLE PROFESSOR

CREATE TABLE manager(
no number(3) primary key, 
age varchar2(100),
name varchar2(100),
part varchar2(100)
)
DROP TABLE MANAGER
INSERT INTO MANAGER(NO, AGE, NAME, PART) VALUES (1, '55', '±è°ü¸®', '°³¹ßºÎ')
SELECT NO, AGE, NAME, PART FROM MANAGER