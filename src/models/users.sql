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
    payment_id varchar(255) default
);
CREATE TABLE reservations (
    id int(10) auto_increment primary key,
    date_ date default (current_date),
    plate_number varchar(255) not null,
    size_ varchar(255) not null,
    slot_number varchar(255) not null,
    entry_time time default (current_time),
    departure_time time default (current_time),
    charge varchar(255),
    payment_id varchar(255) default
);
insert into lot(date_, plate_number, slot_number, entry_time, departure_time, charge, payment_id) values("2023-01-01", "KCY 120E", "F3C1R1","19:51:27", "21:12:32", "200", "QWR4E423");
create table reservations(
    id int(10) auto_increment primary key,
    slot_number varchar(255) not null,
    floor varchar(255) not null,
    reservation_id varchar(255) not null,
    reserve_time varchar(255) not null,
)
