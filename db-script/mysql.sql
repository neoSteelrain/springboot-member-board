-- DB, 계정 생성
create database db_springboot_member;
create user 'user_springboot_member'@'localhost' identified by '1234';
grant all privileges on db_springboot_member.* to 'user_springboot_member'@'localhost';