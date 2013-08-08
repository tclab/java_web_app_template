create table app_users(
      username varchar(50) not null primary key,
      password varchar(50) not null,
      enabled bit not null);

  create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references app_users(username));
      create unique index ix_auth_username on authorities (username,authority);
      
    
insert into app_users (username, password, enabled) values ('juan', 'juan1018', 1);
insert into authority (username, authority) values ('juan', 'ROLE_ADMIN');