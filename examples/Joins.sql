# ---------
# Joins.sql
# ---------

use test;

# ------------------------------------------------------------------------
drop table if exists R;
drop table if exists S;

# ------------------------------------------------------------------------
create table R (A int);
create table S (B int, C int);

# ------------------------------------------------------------------------
insert into R values (1);
insert into R values (2);
insert into R values (3);

insert into S values (1, 6);
insert into S values (1, 7);
insert into S values (4, 8);
insert into S values (4, 9);

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from R ***" as "Select";
select * from S;

# select count(*) from R, S;
# select       *  from R, S;

# select count(*) from R inner join S;
# select       *  from R inner join S;
select "*** select count(*)/* from R cross join S" as "cross join";
select count(*) from R cross join S;
select       *  from R cross join S;

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

# select count(*) from R, S where R.A = S.B;
# select       *  from R, S where R.A = S.B;

# select count(*) from R cross join S where R.A = S.B;
# select       *  from R cross join S where R.A = S.B;

# select count(*) from R inner join S where R.A = S.B;
# select       *  from R inner join S where R.A = S.B;

# select count(*) from R, S on R.A = S.B; # You have an error in your SQL syntax
# select       *  from R, S on R.A = S.B; # You have an error in your SQL syntax

# select count(*) from R cross join S on R.A = S.B;
# select       *  from R cross join S on R.A = S.B;
select "*** select count(*)/* from R inner join S on R.A = S.B" as "inner join";
select count(*) from R inner join S on R.A = S.B;
select       *  from R inner join S on R.A = S.B;

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

# select count(*) from R left join S where R.A = S.B; # You have an error in your SQL syntax
# select       *  from R left join S where R.A = S.B; # You have an error in your SQL syntax

select "*** select count(*)/* from R left join S on R.A = S.B" as "left join";
select count(*) from R left join S on R.A = S.B;
select       *  from R left join S on R.A = S.B;

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

# select count(*) from R right join S where R.A = S.B; # You have an error in your SQL syntax
# select       *  from R right join S where R.A = S.B; # You have an error in your SQL syntax

select "*** select count(*)/* from R right join S on R.A = S.B" as "right join";
select count(*) from R right join S on R.A = S.B;
select       *  from R right join S on R.A = S.B;

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R natural join S" as "natural join";
select count(*) from R natural join S;
select       *  from R natural join S;

# ------------------------------------------------------------------------
drop table if exists R;
drop table if exists S;

# ------------------------------------------------------------------------
create table R (A int);
create table S (A int, C int);

# ------------------------------------------------------------------------
insert into R values (1);
insert into R values (2);
insert into R values (3);

insert into S values (6, 1);
insert into S values (7, 2);
insert into S values (8, 3);
insert into S values (9, 4);

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R cross join S" as "cross join";
select count(*) from R cross join S;
select       *  from R cross join S;

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R inner join S using (A)" as "inner join";
select count(*) from R inner join S using (A);
select       *  from R inner join S using (A);

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R left join S using(A)" as "left join";
select count(*) from R left join S using (A);
select       *  from R left join S using (A);

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R right join S using(A)" as "right join";
select count(*) from R right join S using (A);
select       *  from R right join S using (A);

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R natural join S" as "natural join";
select count(*) from R natural join S;
select       *  from R natural join S;

# ------------------------------------------------------------------------
drop table if exists R;
drop table if exists S;

# ------------------------------------------------------------------------
create table R (A int);
create table S (A int, C int);

# ------------------------------------------------------------------------
insert into R values (1);
insert into R values (2);
insert into R values (3);

insert into S values (1, 6);
insert into S values (1, 7);
insert into S values (4, 8);
insert into S values (4, 9);

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R cross join S" as "cross join";
select count(*) from R cross join S;
select       *  from R cross join S;

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R inner join S" as "inner join";
select count(*) from R inner join S using (A);
select       *  from R inner join S using (A);

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R left join S using(A)" as "left join";
select count(*) from R left join S using (A);
select       *  from R left join S using (A);

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R right join S using(A)" as "right join";
select count(*) from R right join S using (A);
select       *  from R right join S using (A);

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R natural join S" as "natural join";
select count(*) from R natural join S;
select       *  from R natural join S;

# ------------------------------------------------------------------------
drop table if exists R;
drop table if exists S;

# ------------------------------------------------------------------------
create table R (A int, B int);
create table S (A int, C int, D int);

# ------------------------------------------------------------------------
insert into R values (1, 4);
insert into R values (2, 5);
insert into R values (3, 6);

insert into S values (1, 3, 4);
insert into S values (1, 4, 5);
insert into S values (1, 4, 6);
insert into S values (2, 4, 7);
insert into S values (2, 5, 8);
insert into S values (4, 7, 9);

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R cross join S" as "cross join";
select count(*) from R cross join S;
select       *  from R cross join S;

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R inner join S" as "inner join";
select count(*) from R inner join S on R.A = S.A;
select       *  from R inner join S on R.A = S.A;

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R left join S on R.A = S.A" as "left join";
select count(*) from R left join S on R.A = S.A;
select       *  from R left join S on R.A = S.A;

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R right join S on R.A = S.A" as "right join";
select count(*) from R right join S on R.A = S.A;
select       *  from R right join S on R.A = S.A;

# ------------------------------------------------------------------------
select "*** select * from R ***" as "Select";
select * from R;
select "*** select * from S ***" as "Select";
select * from S;

select "*** select count(*)/* from R natural join S" as "natural join";
select count(*) from R natural join S;
select       *  from R natural join S;

# ------------------------------------------------------------------------
drop table if exists R;
drop table if exists S;
drop table if exists T;

# ------------------------------------------------------------------------
create table T (A int);

# ------------------------------------------------------------------------
insert into T values (1);
insert into T values (2);
insert into T values (3);

# ------------------------------------------------------------------------
select "*** select * from T ***" as "Select";
select * from T;

select "*** select count(*)/* from T as R cross join T as S" as "cross join";
select count(*) from T as R cross join T as S;
select       *  from T as R cross join T as S;

# ------------------------------------------------------------------------
select "*** select * from T ***" as "Select";
select * from T;

select "*** select count(*)/* from T as R inner join T as S" as "inner join";
select count(*) from T as R inner join T as S using (A);
select       *  from T as R inner join T as S using (A);

# ------------------------------------------------------------------------
select "*** select * from T ***" as "Select";
select * from T;

select "*** select count(*)/* from T as R left join T as S using (A)" as "left join";
select count(*) from T as R left join T as S using (A);
select       *  from T as R left join T as S using (A);

# ------------------------------------------------------------------------
select "*** select * from T ***" as "Select";
select * from T;

select "*** select count(*)/* from T as R right join T as S using (A)" as "right join";
select count(*) from T as R right join T as S using (A);
select       *  from T as R right join T as S using (A);

# ------------------------------------------------------------------------
select "*** select * from T ***" as "Select";
select * from T;

select "*** select count(*)/* from T as R natural join T as S using (A)" as "natural join";
select count(*) from T as R natural join T as S;
select       *  from T as R natural join T as S;

# ------------------------------------------------------------------------
drop table if exists T;

exit
