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