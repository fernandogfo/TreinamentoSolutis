criar o postgres DB
docker run -p 5432:5432  --name container-postgresdb -e POSTGRES_USER=user -e POSTGRES_PASSWORD=admin -d postgres

criar o pdAdmin
docker run -p 5050:80  --name container-pgadmin -e PGADMIN_DEFAULT_EMAIL=ferna126@hotmail.com -e PGADMIN_DEFAULT_PASSWORD=admin  -d dpage/pgadmin4

(docker start + "nome do container") inicia o container criado acima

lembra disso na config de conexão do pgadmin

host: host.docker.internal
database: postgres
user: postgres
password: admin

