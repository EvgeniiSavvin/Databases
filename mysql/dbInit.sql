CREATE USER 'admin'@'%' IDENTIFIED BY 'admin';
CREATE DATABASE IF NOT EXISTS itmo;
GRANT ALL PRIVILEGES ON * . * TO 'admin'@'%' WITH GRANT OPTION;