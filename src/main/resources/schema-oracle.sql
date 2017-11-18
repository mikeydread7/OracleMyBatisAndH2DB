
drop sequence userIDs_ID;
drop table   USER_DB;
commit;
create table  USER_DB  
(  
 userId  number(4) primary key,  
 userName VARCHAR2(50) not null,
 eyeColor VARCHAR2(50) not null,
 height number(4) not null,
 weight number(4) not null,
 birthday date not null,
 userAge number(4) not null  
);  

create sequence userIDs_ID increment by 1 start with 1;

insert into USER_DB values(userIDs_ID.nextval,'Michael','brown',73,140,sysdate-16900,47);  
insert into USER_DB values(userIDs_ID.nextval,'Steffan','brown',63,89,sysdate-5000,13);  
insert into USER_DB values(userIDs_ID.nextval,'Louis','brown',70,170,sysdate-16990,48);  
insert into USER_DB values(userIDs_ID.nextval,'Jeff','brown',68,190sysdate-16800,43); 
