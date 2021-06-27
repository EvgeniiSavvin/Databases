set container=MySQLForDb
docker stop %container%
docker container rm %container%
docker run -d --name %container% -p 3306:3306 -e MYSQL_ROOT_PASSWORD=itmo -e MYSQL_DATABASE=itmo mysql/mysql-server:latest
timeout 25 > NUL
type dbInit.sql | docker exec -i %container% mysql -uroot -pitmo itmo
cd generator
sbt run
timeout 10 > NUL