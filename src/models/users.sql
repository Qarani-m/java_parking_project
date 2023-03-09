create database parking_project;
use parking_project;
create table users(
    id int(10) auto_increment primary key,
    username varchar(255) not null unique,
    email varchar(255) not null unique,
    phone int(10) not null,
    password varchar(255) not null
);
CREATE TABLE lot (
    id int(10) auto_increment primary key,
    date_ date default (current_date),
    plate_number varchar(255) not null,
    slot_number varchar(255) not null,
    entry_time time default (current_time),
    departure_time time default (current_time),
    charge varchar(255),
    payment_id varchar(255) default ''
);
