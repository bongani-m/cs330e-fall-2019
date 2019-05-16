# --------
# Join.sql
# --------

use test;

# ------------------------------------------------------------------------
drop table if exists Student;
drop table if exists Apply;
drop table if exists College;

# ------------------------------------------------------------------------
create table Student (
    sID    int,
    sName  text,
    GPA    float,
    sizeHS int);

create table Apply (
    sID      int,
    cName    text,
    major    text,
    decision boolean);

create table College (
    cName      text,
    state      char(2),
    enrollment int);

# ------------------------------------------------------------------------
insert into Student values (123, 'Amy',    3.9,  1000);
insert into Student values (234, 'Bob',    3.6,  1500);
insert into Student values (320, 'Lori',   null, 2500);
insert into Student values (345, 'Craig',  3.5,   500);
insert into Student values (432, 'Kevin',  null, 1500);
insert into Student values (456, 'Doris',  3.9,  1000);
insert into Student values (543, 'Craig',  3.4,  2000);
insert into Student values (567, 'Edward', 2.9,  2000);
insert into Student values (654, 'Amy',    3.9,  1000);
insert into Student values (678, 'Fay',    3.8,   200);
insert into Student values (765, 'Jay',    2.9,  1500);
insert into Student values (789, 'Gary',   3.4,   800);
insert into Student values (876, 'Irene',  3.9,   400);
insert into Student values (987, 'Helen',  3.7,   800);

insert into Apply values (123, 'Berkeley', 'CS',             true);
insert into Apply values (123, 'Cornell',  'EE',             true);
insert into Apply values (123, 'Stanford', 'CS',             true);
insert into Apply values (123, 'Stanford', 'EE',             false);
insert into Apply values (234, 'Berkeley', 'biology',        false);
insert into Apply values (321, 'MIT',      'history',        false);
insert into Apply values (321, 'MIT',      'psychology',     true);
insert into Apply values (345, 'Cornell',  'bioengineering', false);
insert into Apply values (345, 'Cornell',  'CS',             true);
insert into Apply values (345, 'Cornell',  'EE',             false);
insert into Apply values (345, 'MIT',      'bioengineering', true);
insert into Apply values (543, 'MIT',       'CS',            false);
insert into Apply values (678, 'Stanford', 'history',        true);
insert into Apply values (765, 'Cornell',  'history',        false);
insert into Apply values (765, 'Cornell',  'psychology',     true);
insert into Apply values (765, 'Stanford', 'history',        true);
insert into Apply values (876, 'MIT',      'biology',        true);
insert into Apply values (876, 'MIT',      'marine biology', false);
insert into Apply values (876, 'Stanford', 'CS',             false);
insert into Apply values (987, 'Berkeley', 'CS',             true);
insert into Apply values (987, 'Stanford', 'CS',             true);

insert into College values ('Berkeley', 'CA', 36000);
insert into College values ('Cornell',  'NY', 21000);
insert into College values ('Irene',    'TX', 25000);
insert into College values ('MIT',      'MA', 10000);
insert into College values ('Stanford', 'CA', 15000);

# ------------------------------------------------------------------------
select "*** select * from Student ***" as "Select";
select * from Student;
select "*** select * from Apply ***" as "Select";
select * from Apply;
select "*** select * from College ***" as "Select";
select * from College;

# ------------------------------------------------------------------------
# select *
#     from Student, Apply
#     order by Student.sID;
select "*** select * from Student ***" as "CrossJoin";
select *
    from Student cross join Apply
    order by Student.sID;

# ------------------------------------------------------------------------
# select *
#     from Student
#     inner join Apply
#     where Student.sID = Apply.sID;

# select *
#     from Student
#     inner join Apply on Student.sID = Apply.sID;
select "*** select * from Student ***" as "ThetaJoin";
select *
    from Student
    inner join Apply using (sID);

# ------------------------------------------------------------------------
select "*** select * from Student where (sizeHS > 1000) and (major = 'CS') and (decision = false) ***" as "ThetaJoin";
select *
    from Student
    inner join Apply using (sID)
    where (sizeHS > 1000) and (major = 'CS') and (decision = false);

select "*** select sName, GPA from Student where (sizeHS > 1000) and (major = 'CS') and (decision = false) ***" as "ThetaJoin";
select sName, GPA
    from Student
    inner join Apply using (sID)
    where (sizeHS > 1000) and (major = 'CS') and (decision = false);

# ------------------------------------------------------------------------
select "*** select * from Student where (sizeHS > 500)   and (major = 'CS')  and (decision = true)  and (enrollment > 20000) ***" as "ThetaJoin: Three tables";

select *
    from Student
        inner join Apply   using (sID)
        inner join College using (cName)
    where (sizeHS     > 500)   and
          (major      = 'CS')  and
          (decision   = true)  and
          (enrollment > 20000);

select "*** select sName, GPA from Student where (sizeHS > 500)   and (major = 'CS')  and (decision = true)  and (enrollment > 20000) ***" as "ThetaJoin: Three tables";
select sName, GPA
    from Student
        inner join Apply   using (sID)
        inner join College using (cName)
    where (sizeHS     > 500)   and
          (major      = 'CS')  and
          (decision   = true)  and
          (enrollment > 20000);

# ------------------------------------------------------------------------
drop table if exists Student;
drop table if exists Apply;
drop table if exists College;

exit
