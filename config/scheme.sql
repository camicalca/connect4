DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id INT(11) NOT NULL AUTO_INCREMENT,
    pass varchar(45),
    email VARCHAR(60) UNIQUE,
    first_name VARCHAR(56),
    last_name VARCHAR(56),
  CONSTRAINT users_pk PRIMARY KEY (id)
);

 DROP TABLE IF EXISTS ranks;
  CREATE TABLE ranks(
	id INT(11) not null auto_increment primary key,
  	user_id INT(11) ,
  	position INT(11),
  	games_won INT(11) 
   
);

 DROP TABLE IF EXISTS games;
  CREATE TABLE games(
	id INT(11) not null auto_increment primary key,
  	user_id INT(11) ,//jugardor1
  	user_id INT(11),//jugador2
  	user_id INT(11) //ganador
	dateinit date,
	datefinish date
   
);
DROP TABLE IF EXISTS cells;
 CREATE TABLE cells 
 (id integer not null primary key auto_increment,
 row integer,
 column integer);

