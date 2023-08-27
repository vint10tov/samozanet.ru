create table users (
   id bigint not null auto_increment,
   active bit,
   date_of_created datetime(6),
   email varchar(255),
   firstname varchar(255),
   lastname varchar(255),
   password varchar(1000),
   phonenumber varchar(255),
   primary key (id)
) engine=InnoDB
GO

alter table users
   add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
GO