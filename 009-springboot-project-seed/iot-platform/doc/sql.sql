/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/2/23 17:12:48                           */
/*==============================================================*/


drop table if exists t_uc_account;

drop table if exists t_uc_account_role;

drop table if exists t_uc_application;

drop table if exists t_uc_dict;

drop table if exists t_uc_menu;

drop table if exists t_uc_organization;

drop table if exists t_uc_role;

drop table if exists t_uc_role_app_menu;

drop table if exists t_uc_tenant;

/*==============================================================*/
/* Table: t_uc_account                                          */
/*==============================================================*/
create table t_uc_account
(
   id                   bigint unsigned not null auto_increment comment '主键',
   account              varchar(32) comment '用户账号',
   password             varchar(32) comment '用户密码',
   account_name         varchar(32) comment '用户姓名',
   user_type            char(14) comment '用户类型(SUPER_MANAGER 超级管理员，TENANT_MANAGER 租户管理员，COMMON_USER 普通用户)',
   phone                char(12) comment '用户手机号',
   email                varchar(32) comment '用户邮箱',
   photo_url            varchar(1024) comment '用户头像url',
   ui_theme             varchar(32) comment '用户界面主题',
   org_id               bigint unsigned comment '组织机构id',
   tenant_id            bigint unsigned comment '租户id',
   active_flag          char(1) comment '启用/禁用状态(Y 启用，N 禁用)',
   update_password_flag char(1) comment '强制修改密码状态(Y 强制修改，N 无需修改)',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id),
   unique key AK_Key_2 (account)
);

alter table t_uc_account comment '用户信息表';

/*==============================================================*/
/* Table: t_uc_account_role                                     */
/*==============================================================*/
create table t_uc_account_role
(
   id                   bigint unsigned not null auto_increment comment '主键',
   account_id           bigint unsigned comment '用户id',
   role_id              bigint unsigned comment '角色id',
   primary key (id),
   unique key AK_Key_2 (account_id, role_id)
);

alter table t_uc_account_role comment '用户角色关联表';

/*==============================================================*/
/* Table: t_uc_application                                      */
/*==============================================================*/
create table t_uc_application
(
   id                   bigint unsigned not null auto_increment comment '主键',
   full_name            varchar(32) comment '应用全称',
   simple_name          varchar(32) comment '应用简称',
   application_identifier varchar(32) comment '应用标识符',
   logo_url             varchar(1024) comment 'LOGO URL',
   storage_type         char(9) comment '存储方案类型(NOT_STORE 不存储，LIMITED 有期限，UNLIMITED 无期限)',
   storage_cycle        int unsigned comment '存储周期',
   storage_unit         char(5) comment '存储周期单位(DAY 日，MONTH 月，YEAR 年)',
   tenant_id            bigint unsigned comment '租户id',
   active_flag          char(1) comment '启用/禁用状态(Y 启用，N 禁用)',
   delete_flag          char(1) comment '有效/删除状态(Y 有效，N 删除)',
   delete_time          datetime comment '删除时间',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id)
);

alter table t_uc_application comment '应用信息表';

/*==============================================================*/
/* Table: t_uc_dict                                             */
/*==============================================================*/
create table t_uc_dict
(
   id                   bigint unsigned not null auto_increment comment '主键',
   dict_type            varchar(32) comment '字典类别',
   dict_key             varchar(32) comment '字典键值',
   dict_label           varchar(32) comment '字典标签',
   dict_sort            tinyint unsigned comment '字典排序',
   remark               varchar(32) comment '备注',
   css_class            varchar(32) comment '字典样式属性',
   active_flag          char(1) comment '启用/禁用状态(Y 启用，N 禁用)',
   primary key (id)
);

alter table t_uc_dict comment '数据字典表';

/*==============================================================*/
/* Table: t_uc_menu                                             */
/*==============================================================*/
create table t_uc_menu
(
   id                   bigint unsigned not null auto_increment comment '主键',
   menu_name            varchar(32) comment '菜单名称',
   menu_type            char(1) comment '菜单类型(M目录 C菜单 F按钮)',
   menu_url             varchar(1024) comment '菜单url',
   menu_icon            varchar(32) comment '菜单icon',
   parent_menu_id       bigint unsigned comment '父级菜单id',
   menu_sort            int unsigned comment '菜单排序',
   active_flag          char(1) comment '启用/禁用状态(Y 启用，N 禁用)',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id)
);

alter table t_uc_menu comment '菜单信息表';

/*==============================================================*/
/* Table: t_uc_organization                                     */
/*==============================================================*/
create table t_uc_organization
(
   id                   bigint unsigned not null auto_increment comment '主键',
   org_name             varchar(32) comment '组织机构名称',
   org_code             varchar(32) comment '组织机构编码',
   parent_code          bigint unsigned comment '应用标识符',
   tenant_id            bigint unsigned comment '租户id',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id)
);

alter table t_uc_organization comment '组织机构信息表';

/*==============================================================*/
/* Table: t_uc_role                                             */
/*==============================================================*/
create table t_uc_role
(
   id                   bigint unsigned not null auto_increment comment '主键',
   role_name            varchar(32) comment '角色名称',
   role_remark          varchar(32) comment '角色描述',
   tenant_id            bigint unsigned comment '租户id',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id)
);

alter table t_uc_role comment '角色信息表';

/*==============================================================*/
/* Table: t_uc_role_app_menu                                    */
/*==============================================================*/
create table t_uc_role_app_menu
(
   id                   bigint not null auto_increment comment '主键',
   app_id               bigint unsigned comment '应用id',
   role_id              bigint unsigned comment '角色id',
   menu_id              bigint unsigned comment '菜单id',
   primary key (id),
   unique key AK_Key_2 (app_id, role_id, menu_id)
);

alter table t_uc_role_app_menu comment '角色应用菜单关联表';

/*==============================================================*/
/* Table: t_uc_tenant                                           */
/*==============================================================*/
create table t_uc_tenant
(
   id                   bigint unsigned not null auto_increment comment '主键',
   full_name            varchar(32) comment '租户全称',
   simple_name          varchar(32) comment '租户简称',
   tenant_identifier    varchar(32) comment '租户标识符',
   logo_url             varchar(1024) comment 'LOGO URL',
   active_flag          char(1) comment '启用/禁用状态(Y 启用，N 禁用)',
   delete_flag          char(1) comment '有效/删除状态(Y 有效，N 删除)',
   delete_time          datetime comment '删除时间',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id),
   unique key AK_Key_2 (tenant_identifier)
);

alter table t_uc_tenant comment '租户信息表';

