DROP table if exists project;
CREATE TABLE if not exists project (
	id varchar(32) NOT NULL COMMENT '项目id',
	name varchar(32) NOT NULL COMMENT '项目名称',
	link varchar(200) NOT NULL COMMENT '链接',
	author varchar(50) NOT NULL COMMENT '作者',
	introduce varchar(500) NOT NULL COMMENT '介绍',
	creation_by varchar(32) NOT NULL COMMENT '创建者',
	creation_date datetime NOT NULL COMMENT '创建时间',
	modify_by varchar(32) NOT NULL COMMENT '修改者',
	modify_date datetime NOT NULL COMMENT '修改时间',
	version int NOT NULL COMMENT '版本号',
	PRIMARY KEY (id)
) COMMENT='项目信息表';

DROP table if exists project_view;
CREATE TABLE if not exists project_view (
	id varchar(32) NOT NULL COMMENT '项目id',
	views int NOT NULL COMMENT '访问数',
	PRIMARY KEY (id)
) COMMENT='项目访问统计表';

