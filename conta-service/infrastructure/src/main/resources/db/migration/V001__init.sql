create table conta (
id bigint not null auto_increment,
code varchar(100) not null,
cpf varchar(11) not null,
created datetime not null,
updated datetime,
primary key (id),
unique(cpf)
) engine=InnoDB default charset=utf8;

create table extrato(
id bigint not null auto_increment,
conta_id bigint not null,
debit decimal(10,4) not null,
credit decimal(10,4) not null,
balance decimal(10,5) not null,
primary key (id),
foreign key (conta_id) references  conta (id)
) engine=InnoDB default charset=utf8;