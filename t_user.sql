create table t_user(
	id bigint primary key auto_increment,
	loginName varchar(255) not null unique,
	loginPwd varchar(255)
);
insert into t_user(loginName,loginPwd) values('admin', '123');
commit;