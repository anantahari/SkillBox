create table Position (
    id serial not null primary key,
    name character varying not null
);

create sequence office_id_seq
start 1
increment 1
cache 1;

create table office (
    id integer not null default nextval('office_id_seq'),
    number integer not null,
    phone character varying
);

alter table employee
add constraint employee_position_fk foreign key (position_id)
references position(id);

alter table employee
add constraint employee_office_fk foreign key (office_id)
references office(id)
on delete restrict
on update set default;

create index i_employee_name
on employee(name);

create index i_employee_salary
on employee(salary);

create index i_employee_grade
on employee using HASH (grade);