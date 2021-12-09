# Read Me First
The following was discovered as part of building this project:

* The following dependencies are not known to work with Spring Native: 'Flyway Migration'. As a result, your application may not work as expected.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/#build-image)
* [Spring Native Reference Guide](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/docs/2.4.3/reference/html/spring-boot-features.html#boot-features-r2dbc)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)

### R2DBC DB Connection Configuration
* [Mysql](https://github.com/mirromutth/r2dbc-mysql)
* [PostgreSQL](https://github.com/pgjdbc/r2dbc-postgresql)
* [MS SQL](https://github.com/r2dbc/r2dbc-mssql)
* [MariaDB](https://github.com/mariadb-corporation/mariadb-connector-r2dbc)
* [H2](https://github.com/r2dbc/r2dbc-h2)

### Guides
The following guides illustrate how to use some features concretely:

* [Acessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Additional Links
These additional references should also help you:

* [Configure the Spring AOT Plugin](https://docs.spring.io/spring-native/docs/0.9.0/reference/htmlsingle/#spring-aot-maven)
* [R2DBC Homepage](https://r2dbc.io)

## Spring Native

This project has been configured to let you generate a lightweight container running a native executable.
Docker should be installed and configured on your machine prior to creating the image, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.9.0/reference/htmlsingle/#getting-started-buildpacks).

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image
```

Then, you can run the app like any other container:

```
$ docker run --rm docker.io/library/coffeeshop:0.0.1
```
