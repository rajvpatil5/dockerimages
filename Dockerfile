FROM openjdk:8
ADD target/docker-springboot.jar docker-springboot.jar
EXPOSE 7070
ENTRYPOINT [ "java", "-jar", "docker-springboot.jar" ]
ENV dbDriver=com.mysql.jdbc.Driver dbConnectionUrl=jdbc:mysql://mysql-spring:3306/test dbUserName=root dbPassword=root