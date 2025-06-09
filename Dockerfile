# Use an official OpenJDK 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set a working directory inside the container
WORKDIR /app

# Copy the JAR file into the container. Source path to Destination path inside the docker image.
COPY target/pos.jar pos.jar

# Expose the port the app runs on (adjust as needed)
EXPOSE 8082

# Default JVM options and Spring profiles can be overridden at runtime
ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE=default

# Run the application with support for environment variables
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -jar pos.jar"]

# Run the JAR file
#ENTRYPOINT ["java", "-jar", "bankingapp.jar"]	

#run with:
#docker run --name=bankingapp -p 8082:8082 -e SPRING_PROFILES_ACTIVE=local -e JAVA_OPTS="-Xms512m -Xmx1024m" bankingapp 

#with network run
#docker run --name=bankingapp-network --network=my-app-network -p 8083:8083 -e SPRING_PROFILES_ACTIVE=default -e JAVA_OPTS="-Xms512m -Xmx1024m" bankingapp 

