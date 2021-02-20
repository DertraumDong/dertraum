DROP table if exists human_relation;
CREATE TABLE if not exists human_relation (
	user_id varchar(32) NOT NULL COMMENT '用户id',
	human_id varchar(32) NOT NULL COMMENT '人员id',
	creation_date datetime NOT NULL COMMENT '关系创建时间'
) COMMENT='人员关系表';

DROP table if exists human_info;
CREATE TABLE if not exists human_info (
	human_id varchar(32) NOT NULL COMMENT '主键id',
	human_name varchar(50) NOT NULL COMMENT '人员姓名',
	birthday date COMMENT '新历生日',
	old_birthday date COMMENT '农历生日',
	creation_by varchar(32) NOT NULL COMMENT '创建者',
	creation_date datetime NOT NULL COMMENT '创建时间',
	modify_by varchar(32) NOT NULL COMMENT '修改者',
	modify_date datetime NOT NULL COMMENT '修改时间',
	version int NOT NULL COMMENT '版本号',
	PRIMARY KEY (human_id)
) COMMENT='人员表';

DROP table if exists human_relation_type;
CREATE TABLE if not exists human_relation_type (
	human_id varchar(32) NOT NULL COMMENT '主键id',
	tag_type tinyint NOT NULL COMMENT '关系类型'
) COMMENT='关系类型表';