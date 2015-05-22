DROP SCHEMA IF EXISTS connect4_development;
CREATE SCHEMA connect4_development;
USE connect4_development;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
   id int(11) not null auto_increment  primary key,
    username varchar(45) UNIQUE,
    email VARCHAR(60) UNIQUE,
    first_name VARCHAR(56),
    last_name VARCHAR(56)

 
);


 DROP TABLE IF EXISTS ranks;
  CREATE TABLE ranks(
  id INT(11) not null auto_increment primary key,
    user_id INT(11) ,
    games_won INT(11) 
   
);

 DROP TABLE IF EXISTS games;
  CREATE TABLE games(
  id INT(11) not null auto_increment primary key,
    player1_id INT(11) ,
    player2_id INT(11),
    win_id INT(11), 
  dateinit date,
  datefinish date
   
);
DROP TABLE IF EXISTS cells;
 CREATE TABLE cells 
 (id integer not null primary key auto_increment,
 filas integer,
 columnas integer
 game_id integer 	
);
