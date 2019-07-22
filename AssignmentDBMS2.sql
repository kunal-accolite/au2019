create database WorldCup;
use WorldCup;

-- 2) Create the schema with all the constraints needed.
create table role(id int ,name varchar(255));
alter table role add constraint primary key(id);
insert into role values (1,'batsman');
insert into role values (2,'bowler');
insert into role values (3,'wicketkeeper');
insert into role values (4,'allrounder');

create table team( id int primary key ,name varchar(255),highest int ,
 lowest int, matches int ,win int ,loss int ,tie int
 );
insert into team values(1,'Australia',398,90,10,7,3,0);
insert into team values(2,'India',414,108,10,7,2,1);
insert into team values(3,'England',434,56,11,7,4,0);
insert into team values(4,'Newzealand',400,90,11,6,3,1);

create table player(id int primary key , name varchar(255) , roleid int , 
teamid int,run int ,wicket int ,innings int, tournid int,
foreign key (roleid) references role(id),foreign key(teamid) references team(id),
foreign key(tournid) references tournament(id)
);

-- 3) Create sample data in all the tables. 
insert into player values(1,'Ricky Ponting',1,1,556,0,10,1);
insert into player values(2,'Sachin',1,2,600,4,10,1);
insert into player values(3,'Hardik',4,2,300,13,10,1);
insert into player values(4,'Bairstow',1,3,500,0,11,1);
insert into player values(5,'Joe Root',1,3,450,2,8,1);
insert into player values(6,'Shami',2,2,31,26,6,1);
insert into player values(7,'Williamson',1,4,580,3,9,1);
insert into player values(8,'Guptill',1,4,440,2,6,1);
insert into player values(9,'Boult',2,4,10,30,11,1);
insert into player values(10,'Woakes',2,3,90,22,6,1);
insert into player values(11,'Bumrah',2,2,5,32,10,1);
insert into player values(12,'Bhuvneshwar',2,2,15,30,8,1);
insert into player values(13,'Rohit',1,2,630,2,11,1);
insert into player values(14,'Virat',1,2,615,10,9,1);
insert into player values(15,'Chahal',2,2,50,25,10,1);


create table matches(
id int primary key , 
t1id int , t2id int , t1score int , t2score int ,winner int ,
foreign key(t1id) references team(id),foreign key(t2id) references team(id)
);
insert into matches values(1,1,2,245,267,2);
insert into matches values(2,3,1,312,293,1);
insert into matches values(3,1,4,289,275,1);
insert into matches values(4,2,3,197,234,2);
insert into matches values(5,4,2,267,89,1);
insert into matches values(6,3,4,189,240,2);

create table tournament(
id int primary key , name varchar(255) , winnerid int ,sixes int ); 
insert into tournament values (1,'CWC2019',2,600);

-- 4) Fetch the top 5 batsmen who scored the maximum runs.
select * from player where roleid=1 order by run desc limit 5;


-- 5) Fetch the top 5 bowlers who has taken the maximum wickets.
select * from player where roleid=2 order by wicket desc limit 5; 

-- 6) Fetch the average score scored by each team considering the matches played.
create view average1 as
select avg(l.s) as average , team_id from (
select sum(t1score) as s ,t1id as team_id from matches where t1id=1
union
select sum(t2score),t2id from matches where t2id=1
) as l;

create view average2 as
select avg(l.s) as average , team_id from (
select sum(t1score) as s ,t1id as team_id from matches where t1id=2
union
select sum(t2score),t2id from matches where t2id=2
) as l;

create view average3 as
select avg(l.s) as average , team_id from (
select sum(t1score) as s ,t1id as team_id from matches where t1id=3
union
select sum(t2score),t2id from matches where t2id=3
) as l;

create view average4 as
select avg(l.s) as average , team_id from (
select sum(t1score) as s ,t1id as team_id from matches where t1id=4
union
select sum(t2score),t2id from matches where t2id=4
) as l;

create view final as
select * from average1
union 
select * from average2
union 
select * from average3
union 
select * from average4;


-- 7) Increase the scores of each batsmen in the team, which has the least average computed in Step 6, by 10 runs.
update player set run=run+10 where teamid in 
(select team_id from final where average in (select min(average) from final)) and roleid=1;


 








