use message_board;
drop table if exists users;
create table users(
  id int unsigned primary key auto_increment,
  username char(20) unique ,
  password char(30) not null,
  token char(30) not null unique,

  birthday date,
  phone_number int unsigned unique ,
  email char(30),

  create_datetime datetime
      default current_timestamp not null
);
desc users;



delete from users where token = 'bbc';

insert into users(username, password, token)
values('Jack', '123456', 'safesedese');

select * from users;

PREPARE createUser
  FROM 'insert into users(
          user_name, password, token)
        VALUE (?, ?, ?)';

# set three variables for prepared statement.
SET @a = 'AAAA';
SET @b = '132131';
SET @c = 'bbc';
EXECUTE createUser USING @a, @b, @c;

DEALLOCATE PREPARE createUser;

PREPARE testMultipleStatement1
  FROM 'insert into users(
          user_name, password, token)
        VALUE (?, ?, ?)';
