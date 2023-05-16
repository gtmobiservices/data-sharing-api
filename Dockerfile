# Use an official openjdk runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy all files of target directory to the container
COPY target/gtmobi-*.jar gtmobi.jar

# Copy default.xml from setup directory to the container
COPY src/main/resources/application.properties .

# Define the command to run when the container starts
ENTRYPOINT ["java","-jar","/app/gtmobi.jar","/app/application.properties"]
