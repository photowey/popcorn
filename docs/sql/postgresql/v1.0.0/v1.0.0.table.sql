-- table

drop table if exists schedule_app;

drop table if exists schedule_group;

drop table if exists schedule_instance;

drop table if exists schedule_job;

drop table if exists schedule_task;

/*==============================================================*/
/* Table: schedule_app                                          */
/*==============================================================*/
create table schedule_app (
   id                   INT8                 not null,
   create_time          TIMESTAMP            not null,
   update_time          TIMESTAMP            not null,
   deleted              INT2                 not null,
   app_code             VARCHAR(32)          not null,
   app_name             VARCHAR(64)          not null,
   client_id            VARCHAR(32)          not null,
   client_secret        VARCHAR(32)          not null,
   constraint PK_SCHEDULE_APP primary key (id)
);

comment on table schedule_app is
'Applications to be scheduled;';

comment on column schedule_app.id is
'The primary key.';

comment on column schedule_app.create_time is
'The create time.';

comment on column schedule_app.update_time is
'The update time.';

comment on column schedule_app.deleted is
'The flag of deleted. 0/1';

comment on column schedule_app.app_code is
'The custom code of app. e.g.: merchant';

comment on column schedule_app.app_name is
'The custom name of app. e.g.: Merchant';

comment on column schedule_app.client_id is
'The client ID of app for the scheduler assignment, == username';

comment on column schedule_app.client_secret is
'The client secret of app for the scheduler assignment. == password';

/*==============================================================*/
/* Table: schedule_group                                        */
/*==============================================================*/
create table schedule_group (
   id                   INT8                 not null,
   create_time          TIMESTAMP            not null,
   update_time          TIMESTAMP            not null,
   deleted              INT2                 not null,
   app_id               INT8                 not null,
   group_code           VARCHAR(64)          not null,
   group_name           VARCHAR(64)          not null,
   job_type             INT2                 not null,
   cron                 VARCHAR(64)          null,
   context              TEXT                 null,
   rpc_protocol         VARCHAR(16)          not null,
   initial_delay        INT8                 not null,
   delay                INT8                 not null,
   period               INT8                 not null,
   time_unit            VARCHAR(16)          not null,
   trigger_time         TIMESTAMP            not null,
   constraint PK_SCHEDULE_GROUP primary key (id)
);

comment on table schedule_group is
'The group of schedule job';

comment on column schedule_group.id is
'The primary key.';

comment on column schedule_group.create_time is
'The create time.';

comment on column schedule_group.update_time is
'The update time.';

comment on column schedule_group.deleted is
'The flag of deleted. 0/1';

comment on column schedule_group.app_id is
'The app id.';

comment on column schedule_group.group_code is
'The group code of job. ';

comment on column schedule_group.group_name is
'The group name of job. ';

comment on column schedule_group.job_type is
'The type of job, 1:FixedRate 2:FixedDelay 3:Cron';

comment on column schedule_group.cron is
'The expression of cron.';

comment on column schedule_group.context is
'The context of rpc.';

comment on column schedule_group.rpc_protocol is
'The RPC protocol of schedule job . 1: HTTP(default)';

comment on column schedule_group.initial_delay is
'The initial delay time.';

comment on column schedule_group.delay is
'The fixed delay time.';

comment on column schedule_group.period is
'The period of FixedRate job.';

comment on column schedule_group.time_unit is
'The delay time unit';

comment on column schedule_group.trigger_time is
'The next trigger time.';

/*==============================================================*/
/* Table: schedule_instance                                     */
/*==============================================================*/
create table schedule_instance (
   id                   INT8                 not null,
   create_time          TIMESTAMP            not null,
   update_time          TIMESTAMP            not null,
   deleted              INT2                 not null,
   app_id               INT8                 not null,
   group_id             INT8                 not null,
   instance_ip          VARCHAR(64)          not null,
   instance_port        INT4                 not null,
   rpc_protocol         VARCHAR(16)          not null,
   heartbeat_time       TIMESTAMP            not null,
   constraint PK_SCHEDULE_INSTANCE primary key (id)
);

comment on table schedule_instance is
'The instance of schedule.';

comment on column schedule_instance.id is
'The primary key.';

comment on column schedule_instance.create_time is
'The create time.';

comment on column schedule_instance.update_time is
'The update time.';

comment on column schedule_instance.deleted is
'The flag of deleted. 0/1';

comment on column schedule_instance.app_id is
'The app id.';

comment on column schedule_instance.group_id is
'The group id';

comment on column schedule_instance.instance_ip is
'The ip of schedule instance.';

comment on column schedule_instance.instance_port is
'The port of schedule instance and shared with Spring Boot app.';

comment on column schedule_instance.rpc_protocol is
'The RPC protocol of schedule job . 1: HTTP(default)';

comment on column schedule_instance.heartbeat_time is
'The time of latest heart beat.';

/*==============================================================*/
/* Table: schedule_job                                          */
/*==============================================================*/
create table schedule_job (
   id                   INT8                 not null,
   create_time          TIMESTAMP            not null,
   update_time          TIMESTAMP            not null,
   deleted              INT2                 not null,
   app_id               INT8                 not null,
   group_id             INT8                 not null,
   group_code           VARCHAR(64)          not null,
   trigger_status       INT2                 not null,
   trigger_time         TIMESTAMP            not null,
   constraint PK_SCHEDULE_JOB primary key (id)
);

comment on table schedule_job is
'schedule_job';

comment on column schedule_job.id is
'The primary key.';

comment on column schedule_job.create_time is
'The create time.';

comment on column schedule_job.update_time is
'The update time.';

comment on column schedule_job.deleted is
'The flag of deleted. 0/1';

comment on column schedule_job.app_id is
'The app ID.';

comment on column schedule_job.group_id is
'The group ID.';

comment on column schedule_job.group_code is
'The group code.';

comment on column schedule_job.trigger_status is
'The trigger  status of this job, 1:scheduling 2:succeed 3:failed';

comment on column schedule_job.trigger_time is
'The trigger time of this job,';

/*==============================================================*/
/* Table: schedule_task                                         */
/*==============================================================*/
create table schedule_task (
   id                   INT8                 not null,
   create_time          TIMESTAMP            not null,
   update_time          TIMESTAMP            not null,
   deleted              INT2                 not null,
   app_id               INT8                 not null,
   group_id             INT8                 not null,
   group_code           VARCHAR(64)          not null,
   job_id               INT8                 not null,
   instance_ip          VARCHAR(64)          not null,
   instance_port        INT4                 not null,
   task_status          INT2                 not null,
   finished_time        TIMESTAMP            null,
   fail_reason          TEXT                 null,
   retry_count          INT4                 not null,
   constraint PK_SCHEDULE_TASK primary key (id)
);

comment on table schedule_task is
'schedule_task';

comment on column schedule_task.id is
'The primary key.';

comment on column schedule_task.create_time is
'The create time.';

comment on column schedule_task.update_time is
'The update time.';

comment on column schedule_task.deleted is
'The flag of deleted. 0/1';

comment on column schedule_task.app_id is
'The app id.';

comment on column schedule_task.group_id is
'The group id';

comment on column schedule_task.group_code is
'The group code of job. ';

comment on column schedule_task.job_id is
'The job id.';

comment on column schedule_task.instance_ip is
'The ip of schedule instance.';

comment on column schedule_task.instance_port is
'The port of schedule instance and shared with Spring Boot app.';

comment on column schedule_task.task_status is
'The status of schedule task of this instance. 1:scheduling 2:succeed 3:failed';

comment on column schedule_task.finished_time is
'The finished time of schedule task of this instance.';

comment on column schedule_task.fail_reason is
'The fail reason of schedule task of this instance. ';

comment on column schedule_task.retry_count is
'The count of retry, default 0.';

