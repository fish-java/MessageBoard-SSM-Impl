use message_board;

drop table if exists messages;
create table messages(
  id int unsigned primary key auto_increment,
  content varchar(500) not null,
  username char(20) not null,

  create_datetime datetime
    default current_timestamp not null,
  update_datetime timestamp
    default current_timestamp not null
    on update current_timestamp
);

ALTER TABLE messages
  Change user_name username char(20);

select * from messages
where update_datetime > '2019-03-17 03:21:54'
order by update_datetime desc
limit 30
offset 20
;

select id,content,username,
       create_datetime,
       update_datetime
from messages limit 10 offset 2;

insert into messages(content, username)
values ('hello world, this is first message', 'Jon');

select
  id,content,username,update_datetime
from messages
order by create_datetime
limit 3 offset 3;
