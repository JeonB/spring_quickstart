
CREATE TABLE member (
                        id NUMBER,
                        password VARCHAR2(30),
                        name VARCHAR2(30),
                        role VARCHAR2(30)
);

CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE board (
                       seq NUMBER,
                       title VARCHAR2(255),
                       writer VARCHAR2(255),
                       content VARCHAR2(4000),
                       regDate DATE,
                       cnt NUMBER,
                       searchCondition VARCHAR2(255),
                       searchKeyword VARCHAR2(255),
                       uploadFile VARCHAR2(255)
);
CREATE OR REPLACE TRIGGER board_trigger
BEFORE INSERT ON board
FOR EACH ROW
BEGIN
SELECT board_seq.NEXTVAL INTO :new.seq FROM dual;
END;
/
