# Spring boot with JPA, Actuator, MVC Docker

## Initial Script
```shell script
https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.3.1.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.chtti.springboot.demo&artifactId=Demo7JPADocker&name=Demo7JPADocker&description=SpringBoot%20Docker%20and%20JPA&packageName=com.chtti.springboot.demo.Demo7JPADocker&dependencies=web,devtools,data-jpa,jdbc,h2,actuator,thymeleaf
```

### Steps

### build spring boot bootable jar 
* change build.gradle, change jar filename
```groovy
bootJar {
  archiveFileName = 'springBootJPA.jar'
}
```
```shell script
gradlew bootjar
```
*gen docker `Dockerfile`
*use docker to create image
````shell script
*docker build --build-arg JAR_FILE=build/libs/*.jar -t chtti/boot1 .
*docker run -p 8880:8880 chtti/boot1
````

*enable other servuce like sql-server
````shell script
docker pull mcr.microsoft.com/mssql/server:2019-CU3-ubuntu-18.04
docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=UsEr1@302" -p 1433:1433 --name sqlserver2019 -d mcr.microsoft.com/mssql/server:2019-CU3-ubuntu-18.04
````
````
docker exec -it sqlserver2019 "bash"
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 'UsEr1@302'
CREATE DATABASE SpringBootDemo
GO
SELECT Name FROM sys.Databases
GO
quit
exit
````
