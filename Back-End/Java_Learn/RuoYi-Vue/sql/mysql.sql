drop table if exists human_entity;
CREATE TABLE `human_entity` (
`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
`name` VARCHAR(50) NOT NULL COMMENT '姓名' ,
`id_card` VARCHAR(20) NOT NULL COMMENT '身份证号码' ,
`phone` VARCHAR(15) NOT NULL COMMENT '手机号码' ,
`id_card_info` VARCHAR(255) NULL DEFAULT NULL COMMENT '身份证信息' ,
`bank_info` VARCHAR(255) NULL DEFAULT NULL COMMENT '银行卡信息' ,
`register_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
`confirmation_status` ENUM('1','2') NOT NULL DEFAULT '1' COMMENT '确认状态: 1未确认 / 2已确认' ,
PRIMARY KEY (`id`) USING BTREE
) COMMENT='人员基本信息表';


drop table if exists human_bill;
CREATE TABLE human_bill (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    name VARCHAR(50) NOT NULL COMMENT '姓名',
    id_card VARCHAR(18) NOT NULL COMMENT '身份证号码',
    area VARCHAR(50) COMMENT '所属区|县',
    project VARCHAR(50) COMMENT '项目名',
    bank_info VARCHAR(255) COMMENT '银行卡信息',
    refund_amount DECIMAL(10, 2) COMMENT '退款金额',
    principal_loss DECIMAL(10, 2) COMMENT '实际本金损失',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    status ENUM('1', '2') NOT NULL DEFAULT '1' COMMENT '状态: 1未退款 / 2已退款',
    confirmation_time TIMESTAMP COMMENT '确认时间'
) COMMENT '人员账单表';

drop table if exists announcement;
CREATE TABLE announcement (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    title VARCHAR(255) NOT NULL COMMENT '标题',
    content TEXT NOT NULL COMMENT '正文内容',
    author VARCHAR(50) COMMENT '作者',
    publish_date DATE COMMENT '发布时间',
    `status` ENUM('1', '2') DEFAULT '1' COMMENT '发布状态,1草稿,2发布',
    `type` ENUM('1', '2','3') NOT NULL COMMENT '文章类型,1前置协议,2普通公告,3同意协议',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
    created_by VARCHAR(255) NOT NULL COMMENT '创建者',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '最后修改时间',
    updated_by VARCHAR(255) COMMENT '修改者',
    `remark` VARCHAR(255) COMMENT '备注'
)COMMENT '公告文章表';
