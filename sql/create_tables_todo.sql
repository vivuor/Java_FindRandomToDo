CREATE TABLE todo(
id int auto_increment not null,
nimi varchar(20) not null,
kuvaus varchar(100) not null,
sijainti varchar(50) not null,
primary key(id)
)engine=InnoDB;