# ALAMI Sharia Mini Project

Spring Boot Mini Project untuk seleksi internship Software Engineer ALAMI Sharia.

## Description
Spring boot project with 5 simple CRUD endpoint.
1. "/" : [GET] "ALAMI Sharia"
2. "/products" : [GET] list all products
3. "/products-by-seller-id/{id}" : [GET] list off product from a spesific seller
4. "/search?key=<key>" : [GET] search product by name (contains certain key)
4. "/add-product" : [POST] add product for spesific seller

## Architecture
This project use three layered architecture :
![three layered architecture](https://github.com/mzunanalfikri/alami-sharia-mini-project/architecture.png)
1. Web Layer
Web layer implemented on package main.java.com.alami.miniproject.controller. Web layer contains rest endpoint for this application.
2. Service Layer
Service Layer implemented on package main.java.com.alami.miniproject.service. Service Layer contains bussiness logic for this application.
3. Repository Layer
Repository Layer implemented on package main.java.com.alami.miniproject.repository. This Layer uses JPA Repository for interaction to the database.

## Dependencies
1. Java JDK 11
2. Spring Boot
3. MySQL
4. Docker
5. Junit
6. MySQL

## How to run
1. Clone this repository.
2. Run this command `docker compose up` inside the repository.
3. Open [localhost:8080](http://localhost:8080)