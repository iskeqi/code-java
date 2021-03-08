/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/3/8 15:05:37                            */
/*==============================================================*/


drop table if exists task_task;

drop table if exists task_task_detail;

drop table if exists task_task_file;

drop table if exists task_task_grid;

drop table if exists task_task_grid_account;

drop table if exists task_task_handle_record;

drop table if exists task_task_handle_record_file;

drop table if exists task_theme;

drop table if exists task_theme_field;

drop table if exists task_theme_field_value;

/*==============================================================*/
/* Table: task_task                                             */
/*==============================================================*/
create table task_task
(
   id                   bigint not null auto_increment comment 'id',
   name                 varchar(32) comment '任务名称',
   type                 tinyint comment '任务类型[1 日常巡检，2 专项巡查，3 其它任务]',
   priority             tinyint comment '任务优先级[1 普通，2 较低，3 紧急，4 非常紧急]',
   begin_date           date comment '任务期限开始日期',
   end_date             date comment '任务期限结束日期',
   interval_type        varchar(32) comment '任务间隔[1 每日，2 每周，3 每月，4 无]',
   frequency            int comment '任务频次',
   note                 varchar(256) comment '任务说明',
   registrant           bigint comment '任务登记人',
   status               tinyint comment '当前状态[1 待办理，2 办理中，3 未开始，4 已归档，5 已失效]',
   processing_level     tinyint comment '任务处理等级[1 超，2 急]',
   control_level        tinyint comment '任务控制等级[1 督，2 催]',
   supervisor           bigint comment '督办人',
   reminder             bigint comment '催办人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id)
);

alter table task_task comment '任务表';

/*==============================================================*/
/* Table: task_task_detail                                      */
/*==============================================================*/
create table task_task_detail
(
   id                   bigint not null auto_increment comment 'id',
   task_id              bigint comment '任务id',
   begin_date           date comment '任务间隔开始日期',
   end_date             date comment '任务间隔结束日期',
   frequency            int comment '任务频次',
   primary key (id)
);

alter table task_task_detail comment '任务明细表';

/*==============================================================*/
/* Table: task_task_file                                        */
/*==============================================================*/
create table task_task_file
(
   id                   bigint not null comment 'id',
   task_id              bigint comment '任务表id',
   file_name            varchar(128) comment '文件名称',
   primary key (id)
);

alter table task_task_file comment '任务文件表';

/*==============================================================*/
/* Table: task_task_grid                                        */
/*==============================================================*/
create table task_task_grid
(
   id                   bigint not null comment 'id',
   task_id              bigint comment '任务id',
   grid_id              bigint comment '网格id',
   primary key (id)
);

alter table task_task_grid comment '任务网格表';

/*==============================================================*/
/* Table: task_task_grid_account                                */
/*==============================================================*/
create table task_task_grid_account
(
   id                   bigint not null comment 'id',
   task_grid_id         bigint comment '任务网格id',
   account_id           bigint comment '人员id',
   status               varchar(32) comment '当前状态[1 待办理，2 办理中，3 未开始，4 已归档，5 已失效]',
   processing_level     varchar(32) comment '任务处理等级[1 超，2 急]',
   control_level        varchar(32) comment '任务控制等级[1 督，2 催]',
   score                int comment ' 评分',
   primary key (id)
);

alter table task_task_grid_account comment '任务网格人员表';

/*==============================================================*/
/* Table: task_task_handle_record                               */
/*==============================================================*/
create table task_task_handle_record
(
   id                   bigint not null auto_increment comment 'id',
   task_detail_id       bigint comment '任务明细id',
   note                 varchar(256) comment '办理说明',
   handle_id            bigint comment '任务办理人',
   lon                  decimal(9,6) comment '经度',
   lat                  decimal(8,6) comment '纬度',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id)
);

alter table task_task_handle_record comment '任务办理记录表';

/*==============================================================*/
/* Table: task_task_handle_record_file                          */
/*==============================================================*/
create table task_task_handle_record_file
(
   id                   bigint not null comment 'id',
   file_name            varchar(128) comment '文件名称',
   task_handle_record_id bigint comment '任务办理记录id',
   primary key (id)
);

alter table task_task_handle_record_file comment '任务办理记录文件表';

/*==============================================================*/
/* Table: task_theme                                            */
/*==============================================================*/
create table task_theme
(
   id                   bigint not null comment 'id',
   name                 varchar(32) comment '主题名称',
   required             tinyint comment '是否必须上传附件[0 否，1 必须]',
   note                 varchar(256) comment '主题说明',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   task_id              bigint comment '任务id',
   primary key (id)
);

alter table task_theme comment '主题表';

/*==============================================================*/
/* Table: task_theme_field                                      */
/*==============================================================*/
create table task_theme_field
(
   id                   bigint not null comment 'id',
   theme_id             bigint comment '主题id',
   required             tinyint comment '是否必填[0 否，1 是]',
   field_name           varchar(32) comment '字段名称',
   field_type           tinyint comment '字段类型[1 文本，2 日期，3 选项]',
   field_type_detail    varchar(32) comment '字段类型补充[1 年月日，2 年月，3 月日，或选项具体值]',
   primary key (id)
);

alter table task_theme_field comment '主题字段';

/*==============================================================*/
/* Table: task_theme_field_value                                */
/*==============================================================*/
create table task_theme_field_value
(
   id                   bigint not null comment 'id',
   field_value          varchar(32) comment '字段值',
   theme_field_id       bigint comment '主题字段id',
   task_handle_record_id bigint comment '任务办理记录id',
   primary key (id)
);

alter table task_theme_field_value comment '主题字段值';

alter table task_task_detail add constraint FK_Reference_11 foreign key (task_id)
      references task_task (id) on delete restrict on update restrict;

alter table task_task_file add constraint FK_Reference_8 foreign key (task_id)
      references task_task (id) on delete restrict on update restrict;

alter table task_task_grid add constraint FK_Reference_9 foreign key (task_id)
      references task_task (id) on delete restrict on update restrict;

alter table task_task_grid_account add constraint FK_Reference_10 foreign key (task_grid_id)
      references task_task_grid (id) on delete restrict on update restrict;

alter table task_task_handle_record add constraint FK_Reference_14 foreign key (task_detail_id)
      references task_task_detail (id) on delete restrict on update restrict;

alter table task_task_handle_record_file add constraint FK_Reference_15 foreign key (task_handle_record_id)
      references task_task_handle_record (id) on delete restrict on update restrict;

alter table task_theme add constraint FK_Reference_12 foreign key (task_id)
      references task_task (id) on delete restrict on update restrict;

alter table task_theme_field add constraint FK_Reference_13 foreign key (theme_id)
      references task_theme (id) on delete restrict on update restrict;

alter table task_theme_field_value add constraint FK_Reference_16 foreign key (theme_field_id)
      references task_theme_field (id) on delete restrict on update restrict;

alter table task_theme_field_value add constraint FK_Reference_17 foreign key (task_handle_record_id)
      references task_task_handle_record (id) on delete restrict on update restrict;

