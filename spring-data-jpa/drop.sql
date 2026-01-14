
    set client_min_messages = WARNING;

    alter table if exists student.customer 
       drop constraint if exists FKglkhkmh2vyn790ijs6hiqqpi;

    alter table if exists student.employee 
       drop constraint if exists FKbejtwvg9bxus2mffsm3swj3u9;

    alter table if exists student.home_room 
       drop constraint if exists FKs9975spwhxi9l5sp63x21vrj6;

    alter table if exists student.home_room 
       drop constraint if exists FKc42setb3gqgluc56w68ds32as;

    alter table if exists student.student_course 
       drop constraint if exists FKejrkh4gv8iqgmspsanaji90ws;

    alter table if exists student.student_course 
       drop constraint if exists FKq7yw2wg9wlt2cnj480hcdn6dq;

    drop table if exists student.address cascade;

    drop table if exists student.course cascade;

    drop table if exists student.customer cascade;

    drop table if exists student.department cascade;

    drop table if exists student.employee cascade;

    drop table if exists student.home cascade;

    drop table if exists student.home_room cascade;

    drop table if exists student.room cascade;

    drop table if exists student.student cascade;

    drop table if exists student.student_course cascade;
