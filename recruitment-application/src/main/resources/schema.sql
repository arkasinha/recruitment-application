create table job_offer
(
   job_title varchar(255) not null,
   start_date date,
   team_email varchar(255),
   primary key(job_title)
);

create table job_application
(
   candidate_email varchar(255) not null,
   job_title varchar(255) not null,
   application_status varchar(255) not null   
);