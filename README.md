# Database

To create a docker container with postgres database run a following command:
```dockerfile
docker run -e POSTGRES_USER=libraryPostgres -e POSTGRES_PASSWORD=libraryPostgres -p 5432:5432 --name libraryPostgresDB postgres
```