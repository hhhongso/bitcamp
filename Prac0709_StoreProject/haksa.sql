CREATE TABLE HAKSASTUDENT(
NO NUMBER(4) PRIMARY KEY,
NAME VARCHAR2(100),
AGE VARCHAR2(50),
IDNUM VARCHAR2(100)
)

CREATE TABLE HAKSAPROFESSOR(
NO NUMBER(4) PRIMARY KEY,
NAME VARCHAR2(100),
AGE VARCHAR2(50),
SUBJECT VARCHAR2(100)
)

CREATE TABLE HAKSAMANAGER(
NO NUMBER(4) PRIMARY KEY,
NAME VARCHAR2(100),
AGE VARCHAR2(50),
PART VARCHAR2(100)
)

SELECT NO, NAME, AGE, IDNUM FROM HAKSASTUDENT
SELECT NO, NAME, AGE, SUBJECT FROM HAKSAPROFESSOR
SELECT NO, NAME, AGE, PART FROM HAKSAMANAGER


DELETE FROM HAKSASTUDENT
DROP TABLE HAKSASTUDENT
DROP TABLE HAKSAPROFESSOR
DROP TABLE HAKSAMANAGER