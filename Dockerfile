# syntax=docker/dockerfile:1

# FROM <image>
# FROM eclipse-temurin:<version>-alpine; if you want Alpine Linux project
# FROM amazoncorretto:<version>-alpine; if you want Alpine Linux project
# https://hub.docker.com/_/openjdk/ (DEPRECATED)
# https://hub.docker.com/_/eclipse-temurin (ALTERNATIVE #1)
# https://hub.docker.com/_/amazoncorretto (ALTERNATIVE #2)
FROM eclipse-temurin:19

# set a directory for the app
# WORKDIR <directory>
WORKDIR /app

# copy all the files to the container
# COPY <src> <dest>
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# install app dependencies
# RUN <command>
RUN ./mvnw dependency:resolve

COPY src ./src

# tell Docker what command we want to run when our image is executed inside a container
# CMD <command>
CMD ["./mvnw", "spring-boot:run"]

# tell container which port # to expose
EXPOSE 5000
# final configuration
# ENV
# EXPOSE
# CMD

# TELL THE CONTAINER WHICH PORT NUMBER TO EXPOSE
# EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "./src/main/java/com/technews/TechNewsJavaApiApplication.java"]

# copy all the files to the container
# COPY . .

