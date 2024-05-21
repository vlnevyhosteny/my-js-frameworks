# My JS Frameworks

Simple JS framework repository to learn Spring and Kotlin. Inspired by [this](https://github.com/etnetera/js-frameworks).

Technologies implemented:

- Spring Boot
- Spring MVC
- Spring Security
- Spring Request Validation
- Hexagonal architecture

App use:

- in-memory H2 db
- in-memory user storage (user:password)

## Run

```bash
$ ./gradlew bootRun
```

## Get Token

```bash
$ curl -X "POST" "http://localhost:8080/token" \
     -u 'user:password'
```

## List Frameworks

```bash
$ curl "http://localhost:8080/frameworks" \
     -H 'Authorization: Bearer <token>'
```

## Search Frameworks

```bash
$ curl "http://localhost:8080/frameworks?search=Rea" \
     -H 'Authorization: Bearer <token>'
```

## Create Framework

```bash
$ curl -X "POST" "http://localhost:8080/frameworks" \
     -H 'Content-Type: application/json; charset=utf-8' \
     -d $'{
  "name": "NestJS",
  "ranking": 5
}'

```
