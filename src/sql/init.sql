create database user;
use user;
create table user(
`user_id` int primary key auto_increment,
`name` varchar (30) not null ,
`password` varchar(30) not null
);

insert into user(name,password) values ('huanggang','1234'),('tanjian','12345');
