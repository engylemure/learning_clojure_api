CREATE TABLE users(
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(255),
  username varchar(255) UNIQUE NOT NULL,
  email varchar(255),
  password TEXT,
  created_at DATETIME,
  updated_AT DATETIME,
  primary key (id)
);
--;;
CREATE TABLE todos(
  id INT NOT NULL AUTO_INCREMENT,
  title varchar(255),
  created_at DATETIME,
  updated_at DATETIME,
  description varchar(255),
  primary key (id)
);