IF NOT EXISTS(SELECT * FROM sys.databases WHERE name='demo_db')
BEGIN
 CREATE DATABASE demo_db;
END;
GO
USE demo_db;
GO
CREATE TABLE categories(
 id BIGINT IDENTITY(1,1) PRIMARY KEY,
 name VARCHAR(255) NOT NULL UNIQUE
);
CREATE TABLE products(
 id BIGINT IDENTITY(1,1) PRIMARY KEY,
 name VARCHAR(255) NOT NULL,
 price FLOAT,
 quantity INT,
 category_id BIGINT FOREIGN KEY REFERENCES categories(id)
);
SELECT DISTINCT local_tcp_port  
FROM sys.dm_exec_connections  
WHERE local_tcp_port IS NOT NULL;
