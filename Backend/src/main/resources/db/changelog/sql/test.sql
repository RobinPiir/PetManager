CREATE TABLE pets(id IDENTITY NOT NULL,
    code varchar(255),
    name varchar(255),
    type varchar(255),
    color varchar(255),
    primary key (id));
INSERT INTO PETS(code,name,type,color) VALUES ('','Caesar', 'Cat', 'Multicolor'),('');
CREATE TABLE colors(id IDENTITY NOT NULL,
color varchar(255),
primary key (id));
insert into colors(color) VALUES ('Black'),('White'),('Brown'),('Yellow'),('Blue'),('Multicolor'),('Gray');
CREATE TABLE types(id IDENTITY NOT NULL,
type varchar(255),
primary key (id));
insert into types(type) VALUES ('Cat'),('Dog'),('Horse'),('Rabbit'),('Parrot');
