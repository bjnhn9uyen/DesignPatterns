CREATE DATABASE design_patterns
GO

USE design_patterns

CREATE TABLE product (
	id int IdENTITY (1, 1) PRIMARY KEY,
	name nvarchar(30),
	price money
)