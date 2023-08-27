create table userrole (
   userid bigint not null,
   roles varchar(255)
) engine=InnoDB
GO

alter table userrole
   add constraint FK5myx5qtxjcsem4ji6ykl1921g
   foreign key (userid)
   references users (id)
GO
