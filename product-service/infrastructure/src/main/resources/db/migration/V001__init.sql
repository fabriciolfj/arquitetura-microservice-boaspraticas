create table product (
id bigint not null auto_increment,
code varchar(100) not null,
limit_withdraw decimal(10,4) not null,
rate decimal(10,4) not null,
description varchar(200) not null,
daily int not null,
created datetime not null,
updated datetime,
status int not null,
unique(code),
primary key (id)
) engine=InnoDB default charset=utf8;