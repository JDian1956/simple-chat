-- SQL

Drop Table if exists sys_user;
create table sys_user
(
    user_id     bigint      not null Comment '用户ID',
    user_name   varchar(30) not null Comment '用户名',
    nick_name   varchar(30) not null Comment '昵称',
    password    varchar(36) not null Comment '密码',
    user_type   char(2)      default '00' Comment '用户类型（00系统用户）',
    sex         char(1)      default '2' Comment '性别（0男 1女 2未知）',
    phone       varchar(11)  default '' Comment '手机号码',
    email       varchar(50)  default '' Comment '邮箱',
    avatar      varchar(200) default '' Comment '头像',
    status      char(1)      default '0' Comment '状态（0正常 1停用）',
    del_flag    char(1)      default '0' Comment '删除标志（0代表存在 2代表删除）',
    create_by   varchar(64)  default '' Comment '创建者',
    update_by   varchar(64)  default '' Comment '更新者',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null Comment '备注',
    primary key (user_id)
) engine = InnoDB default charset = utf8mb4 comment ='用户表';