use module-db;

create table module (
    id int not null auto_increment primary key,
    name varchar(80) not null
);

insert into module (name) values ('Docker');
insert into module (name) values ('Service Discovery');
insert into module (name) values ('Kubernetes');
insert into module (name) values ('Rabbit MQ');
insert into module (name) values ('Kafka');