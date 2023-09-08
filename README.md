# Database

To create a docker container with postgres database run a following command:

```dockerfile
docker build --tag=image_with_postgres .
docker run -d -p 5432:5432 --name libraryPostgresDB image_with_postgres
```

# Endpoints

- http://localhost:8080/allAuthors - should display a list of 8 authors