CREATE TABLE items (
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  title varchar(255),
  created_at DATETIME,
  description varchar(255),
  primary key (id)
);