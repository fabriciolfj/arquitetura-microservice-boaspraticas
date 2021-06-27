create table product(
id bigint not null auto_increment,
code varchar(100) not null,
limit decimal(10,4) not null,
rate decimal(10,4) not null,
describe varchar(200) not null,
daily bigint not null,
created datetime not null,
updated datetime,
status bigint not null,
unique(code),
primary key (id)
) engine=InnoDB default charset=utf8;