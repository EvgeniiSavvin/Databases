set container=PostgresForDb
docker stop %container%
docker container rm %container%
docker run -d --name %container% -p 5432:5432 -e POSTGRES_PASSWORD=itmo -e POSTGRES_USER=itmo -e POSTGRES_DB=itmo postgres:11.5-alpine
timeout 3 > NUL
type dbInit.sql | docker exec -i %container% psql -U itmo -d itmo
cd generator
sbt run
