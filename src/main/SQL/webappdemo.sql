create database webapp;
use webapp;
create table users(id int primary key auto_increment, uname varchar(255), uemail varchar(255) unique , upwd varchar(255));

select * from users;
