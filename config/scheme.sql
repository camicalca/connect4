DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id INT(11) NOT NULL AUTO_INCREMENT,
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

