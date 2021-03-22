set container=MySQLForDb
docker stop %container%
docker container rm %container%
docker run -d --name %container% -p 5432:5432 -e MYSQL_ROOT_PASSWORD=itmo mysql/mysql-server:latest
timeout 25 > NUL
docker exec -i %container% mysql -uroot -pitmo < dbInit.sql
timeout 10 > NUL