DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
                         id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                         name varchar(50),
                         age INT,
                         city VARCHAR(50)
);