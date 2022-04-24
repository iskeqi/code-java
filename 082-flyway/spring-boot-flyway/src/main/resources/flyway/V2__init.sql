create table `sys_upload_file`
(
    `id`           bigint unsigned not null auto_increment,
    `name`         varchar(512)     default null comment '文件名称',
    `path`         varchar(512)     default null comment '文件存储路径[相对路径]',
    `type`         varchar(128)     default null comment '文件类型[content-type]',
    `size`         int              default null comment '文件大小[单位:字节]',
    `storage_type` tinyint unsigned default null comment '存储类型[1:本地文件系统 2:minio]',
    `is_deleted`   tinyint unsigned default '0' comment '是否删除[false:未删除 true:已删除]',
    `create_time`  datetime         default null comment '创建时间',
    `update_time`  datetime         default null comment '修改时间',
    primary key (`id`),
    unique key `uk_path` (`path`)
) engine = innodb
  default charset = utf8mb4
  collate = utf8mb4_0900_ai_ci comment ='文件表';