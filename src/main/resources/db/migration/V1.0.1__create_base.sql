CREATE TABLE if not exists department (
    id serial NOT NULL primary key,
    name varchar(32));
CREATE TABLE if not exists employee (
    id serial NOT NULL primary key,
    hire_time bigint,
    fired_time bigint,
    department_id bigint,
    FOREIGN KEY (department_id) REFERENCES department(id)
    );

INSERT INTO department (name)
VALUES
('IT'),
('HR'),
('Marketing'),
('Maintenance'),
('Sales'),
('Финансовый отдел'),
('Production Department'),
('Research and Development'),
('Dispatch Department'),
('Customer Service');




