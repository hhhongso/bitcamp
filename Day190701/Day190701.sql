CREATE TABLE BOARD(
NO NUMBER(3) PRIMARY KEY, 
TITLE VARCHAR2(100),
CONTENT VARCHAR2(500),
AUTHOR VARCHAR2(100),
NAL VARCHAR2(20),
READCOUNT NUMBER(4)
)

DROP TABLE BOARD

SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD
