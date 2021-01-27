# This Dockerfile leverages multi-stage builds.
# See https://docs.docker.com/develop/develop-images/multistage-build/

# STAGE:
# The 'maven' base is used to package the application
FROM maven:3.6.3-jdk-11-slim as maven

WORKDIR /app

# To make best use of Docker caching this section only copies
# pom.xml and uses it to install all the dependencies required
# to package the application in the next section
COPY ./pom.xml ./pom.xml
RUN mvn verify clean --fail-never

# copy the source and package the application
COPY ./src ./src
RUN mvn package && cp target/metalstore-*.jar app.jar

# STAGE:
# This base is used for the final image
# It extracts the packaged application from the previous stage
# and builds the final image
FROM openjdk:11-jre-slim
MAINTAINER CyberArk

COPY --from=maven /app/app.jar /app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar"]
