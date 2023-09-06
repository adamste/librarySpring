# Database

To create a docker container with postgres database run a following command:

```dockerfile
docker run -e POSTGRES_USER=libraryPostgres -e POSTGRES_PASSWORD=libraryPostgres -p 5432:5432 --name libraryPostgresDB postgres
```

# Endpoints

- http://localhost:8080/allAuthors - should display a list of 8 authors