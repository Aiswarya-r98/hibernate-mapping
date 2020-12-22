create database hb_demo;

use hb_demo;

create table regions(
region_id int primary key auto_increment,
region_name varchar(20)
);

create table countries(
country_id int primary key auto_increment,
country_name varchar(20),
region_id int ,
foreign key(region_id) references regions(region_id)
);

create table locations(
location_id int primary key auto_increment,
street_address varchar(20),
postal_code varchar(20),
city varchar(20),
state_province varchar(20),
country_id int not null,
foreign key(country_id) references countries(country_id)
);

create table jobs(
job_id int primary key auto_increment,
job_title varchar(20),
min_salary decimal(10,2),
max_salary decimal(10,2)
);

create table departments(
department_id int primary key auto_increment,
department_name varchar(20),
manager_id int,
location_id int not null,
foreign key(location_id) references locations(location_id)
);


create table employees(
employee_id int primary key auto_increment,
first_name varchar(20),
last_name varchar(20),
email varchar(20),
phone_number varchar(20),
hire_date date,
job_id int references jobs(job_id),
salary decimal(10,2),
commission_pct decimal(2,2),
manager_id int,
department_id int not null,
foreign key(department_id) references departments(department_id)
);

drop tables departments, employees;

alter table departments
add constraint foreign key(manager_id) references employees(employee_id);

alter table employees
add constraint foreign key(manager_id) references employees(employee_id);

create table job_history(
job_history_id int primary key auto_increment,
employee_id int not null,
start_date date,
end_date date,
department_id int not null,
foreign key(employee_id) references employees(employee_id),
foreign key(department_id) references departments(department_id)
);