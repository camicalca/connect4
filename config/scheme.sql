DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id INT(11) NOT NULL AUTO_INCREMENT,
    email VARCHAR(60) UNIQUE,
    first_name VARCHAR(56),
    last_name VARCHAR(56),
  CONSTRAINT users_pk PRIMARY KEY (id)


 DROP TABLE IF EXISTS users;
  CREATE TABLE ranks(
  	user_id INT(11) NOT NULL,
  	position INT(11) NOT NULL,
  	games_won INT(11) NOT NULL, 
   
);
DROP TABLE IF EXISTE matrix;
	CREATE TABLE matrix(
		id INT(11) NOT NULL AUTO_INCREMENT,
		cell_id INT (11) NOT NULL,
		CONSTRAINT matrix_pk PRIMARY KEY (id)
);



