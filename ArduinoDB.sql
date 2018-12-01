create database arduino;

use arduino;

create table data (
	id int (2) primary key auto_increment,
	humedad varchar(45),
	temperatura varchar(45),
	rayos_v varchar(45),
	sensor_lluvia varchar(45),
	created_at date
);

select * from data;

insert into data (humedad, temperatura, rayos_v, sensor_lluvia, created_at)
values ('30%', '50.6 °C', '30.5 mW/cm2', '1', SYSDATE());