create table if not exists channels (
channel_id int auto_increment primary key,
channel_name varchar(255)
);

create table if not exists events (
event_id int auto_increment primary key
);

create table if not exists users (
user_id int auto_increment primary key,
channel_name varchar(255),
current_last_event_id int,
user_name varchar(255)
);

create table if not exists user_channels (
user_channel_id int auto_increment primary key,
user_channel_name varchar(255)
);

create table if not exists user_schedules (
user_schedule_id int auto_increment primary key
);
