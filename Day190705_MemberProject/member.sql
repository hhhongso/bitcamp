CREATE TABLE MEMBER (
ID VARCHAR2(100) PRIMARY KEY, 
PW VARCHAR2(100),
ADDR VARCHAR2(100),
TEL VARCHAR2(100)
)

SELECT ID, PW, ADDR, TEL FROM MEMBER

DELETE FROM MEMBER