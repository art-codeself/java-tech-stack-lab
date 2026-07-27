-- ================================================================
-- Lab MySQL Initialization Script
-- ================================================================
-- This script runs automatically when the MySQL container starts
-- for the first time. Add your table definitions and seed data here.
-- ================================================================

CREATE DATABASE IF NOT EXISTS lab_mysql DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE lab_mysql;

-- Example: User table for lab-mysql module demos
CREATE TABLE IF NOT EXISTS `sys_user` (
    `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
    `username`    VARCHAR(64)  NOT NULL COMMENT 'Username',
    `nickname`    VARCHAR(64)  DEFAULT NULL COMMENT 'Nickname',
    `email`       VARCHAR(128) DEFAULT NULL COMMENT 'Email',
    `phone`       VARCHAR(20)  DEFAULT NULL COMMENT 'Phone number',
    `status`      TINYINT      NOT NULL DEFAULT 1 COMMENT 'Status: 0=disabled, 1=enabled',
    `deleted`     TINYINT      NOT NULL DEFAULT 0 COMMENT 'Logical delete: 0=no, 1=yes',
    `create_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created at',
    `update_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated at',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='System User';

-- Seed data
INSERT INTO `sys_user` (`username`, `nickname`, `email`, `phone`, `status`) VALUES
('admin',   'Administrator', 'admin@lab.com',   '13800000001', 1),
('zhangsan','Zhang San',     'zhangsan@lab.com','13800000002', 1),
('lisi',    'Li Si',         'lisi@lab.com',    '13800000003', 1),
('wangwu',  'Wang Wu',       'wangwu@lab.com',  '13800000004', 0);
