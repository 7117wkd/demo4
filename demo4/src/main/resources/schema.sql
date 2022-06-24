create table tbl_board(
    boardId long auto_increment,
    title varchar (30) not null,
    content varchar (300) not null,
    name varchar (30) not null,
    count integer,
    comment varchar (300),
    primary key(boardId)
);

create table comment(
    boardId long not null,
    comment varchar (300),
    time timestamp,
    foreign key(boardId) references tbl_board (boardId)
);

insert into tbl_board ( title, content, name, count) values('title1', 'content1', 'name1', 0);
insert into tbl_board ( title, content, name, count) values('title2', 'content2', 'name2', 0);
insert into tbl_board ( title, content, name, count) values('title3', 'content3', 'name3', 0);
insert into tbl_board ( title, content, name, count) values('title4', 'content4', 'name4', 0);
insert into tbl_board ( title, content, name, count) values('title5', 'content5', 'name5', 0);
insert into tbl_board ( title, content, name, count) values('title6', 'content6', 'name6', 0);
insert into tbl_board ( title, content, name, count) values('title7', 'content7', 'name7', 0);
insert into tbl_board ( title, content, name, count) values('title8', 'content8', 'name8', 0);
insert into tbl_board ( title, content, name, count) values('title9', 'content9', 'name9', 0);
insert into tbl_board ( title, content, name, count) values('title10', 'content10', 'name10', 0);