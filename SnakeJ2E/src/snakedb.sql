-- lancer mysql: mysql -u root -p

DROP DATABASE IF EXISTS snakedb;
CREATE DATABASE IF NOT EXISTS snakedb;
USE snakedb;


CREATE TABLE IF NOT EXISTS USER (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    pseudo VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    UNIQUE (pseudo)
);

INSERT INTO USER(pseudo,password) VALUES ("tim", "1234"); 
INSERT INTO USER(pseudo,password) VALUES ("mateo", "5678"); 

create table if not exists PARTIE( 
  partie_id int auto_increment primary key,  
  date datetime NOT NULL,
  score int NOT NULL,
  user_id int NOT NULL,
  foreign key(user_id) references USER(user_id)
);

INSERT INTO PARTIE(user_id,date,score) VALUES ("1",CURRENT_TIMESTAMP,"15"); 
INSERT INTO PARTIE(user_id,date,score) VALUES ("1",CURRENT_TIMESTAMP, "23"); 
INSERT INTO PARTIE(user_id,date,score) VALUES ("2",CURRENT_TIMESTAMP, "50"); 
INSERT INTO PARTIE(user_id,date,score) VALUES ("2",CURRENT_TIMESTAMP,"5"); 
INSERT INTO PARTIE(user_id,date,score) VALUES ("2",CURRENT_TIMESTAMP, "19"); 