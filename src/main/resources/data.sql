INSERT INTO major (title,required_subject) VALUES ('국어국문학과','국어');
INSERT INTO major (title,required_subject) VALUES ('컴퓨터공학과','수학');

INSERT INTO subject (name) VALUES ('국어');
INSERT INTO subject (name) VALUES ('수학');
INSERT INTO subject (name) VALUES ('댄스');

INSERT INTO student (name,student_id,major_id) VALUES ('김영롱',211213,1);
INSERT INTO student (name,student_id,major_id) VALUES ('우무룡',212330,2);
INSERT INTO student (name,student_id,major_id) VALUES ('정지용',201518,1);
INSERT INTO student (name,student_id,major_id) VALUES ('이윤선',202360,1);
INSERT INTO student (name,student_id,major_id) VALUES ('김현지',201290,2);

INSERT INTO score (student_id,subject,score) VALUES (211213,'국어',95);
INSERT INTO score (student_id,subject,score) VALUES (211213,'수학',56);
INSERT INTO score (student_id,subject,score) VALUES (212330,'국어',95);
INSERT INTO score (student_id,subject,score) VALUES (212330,'수학',98);
INSERT INTO score (student_id,subject,score) VALUES (201518,'국어',100);
INSERT INTO score (student_id,subject,score) VALUES (201518,'수학',88);
INSERT INTO score (student_id,subject,score) VALUES (202360,'국어',89);
INSERT INTO score (student_id,subject,score) VALUES (202360,'수학',95);
INSERT INTO score (student_id,subject,score) VALUES (201290,'국어',83);
INSERT INTO score (student_id,subject,score) VALUES (201290,'수학',56);
INSERT INTO score (student_id,subject,score) VALUES (211213,'댄스',95);
INSERT INTO score (student_id,subject,score) VALUES (212330,'댄스',85);
INSERT INTO score (student_id,subject,score) VALUES (201518,'댄스',55);