# --------------
# Subqueries.sql
# --------------

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
select "*** select * from Student ***" as "Select";
select * from College;

# ------------------------------------------------------------------------
select "*** ID, name, and GPA of students who applied in CS ***";

select "this is not right, why?";

select sID, sName, GPA
    from Student
    inner join Apply using (sID)
    where major = 'CS';

select "this is right";

select distinct sID, sName, GPA
    from Student
    inner join Apply using (sID)
    where major = 'CS';

select "this is also right, using subquery, with in";
	
select sID, sName, GPA
    from Student
    where sID in
        (select sID
            from Apply
            where major = 'CS');

# ------------------------------------------------------------------------
select "*** GPA of students who applied in CS ***";

select "this is not right, why?";

select GPA
    from Student
    inner join Apply using (sID)
    where major = 'CS'
    order by GPA desc;

select "this is still not right, why?";

select distinct GPA
    from Student
    inner join Apply using (sID)
    where major = 'CS'
    order by GPA desc;

select "this is right, using subquery, with in";

select GPA
    from Student
    where sID in
        (select sID
            from Apply
            where major = 'CS')
    order by GPA desc;

# ------------------------------------------------------------------------
select "*** ID of students who have applied in CS but not in EE ***";

select "this is not right, why?";

select sID
    from Student
    where
        sID in (select sID from Apply where major  = 'CS')
        and
        sID in (select sID from Apply where major != 'EE');

select "this is right, using subquery, with in and not in";

select sID
    from Student
    where
        sID     in (select sID from Apply where major = 'CS')
        and
        sID not in (select sID from Apply where major = 'EE');

select "this is also right, using subquery, with in";

select distinct sID
    from Apply
    where
        (major = 'CS')
        and
        sID not in (select sID from Apply where major = 'EE');

# ------------------------------------------------------------------------
select "*** colleges with another college in the same state ***";

select "using inner join";

select distinct R.cName, R.state
    from College as R
    inner join College as S
    where (R.cName != S.cName) and
          (R.state  = S.state);

select "using subquery, with exists";

select cName, state
    from College as R
    where exists
        (select *
            from College as S
            where (R.cName != S.cName) and
                  (R.state =  S.state));

select "using subquery, with group by and having";

select cName, state
    from College
    natural join
        (select State
            from College
            group by State
            having count(State) > 1) as T;

# ------------------------------------------------------------------------
select "*** colleges with highest enrollment ***";

select "using subquery, with not exists"III;

select cName, enrollment
    from College as R
    where not exists
        (select *
            from College as S
            where R.enrollment < S.enrollment);

select "using subquery, with all";

select cName, enrollment
    from College
    where enrollment >= all
        (select enrollment
            from College);

# ------------------------------------------------------------------------
select "*** students with highest GPA ***";

select "this is not right, why?";

select sID, sName, GPA
    from Student as R
    where not exists
        (select *
            from Student as S
            where R.GPA < S.GPA);

select "this is right";

select sID, sName, GPA
    from Student as R
    where
        not exists
            (select *
                from Student as S
                where R.GPA < S.GPA)
        and
        (GPA is not null);

select "this is also right, using subquery, with all";

select sID, sName, GPA
    from Student
    where GPA >= all
        (select GPA
            from Student
            where GPA is not null);

# ------------------------------------------------------------------------
drop table if exists Student;
drop table if exists Apply;
drop table if exists College;

exit
