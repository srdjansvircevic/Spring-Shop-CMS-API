# Stage 1: Build the application
FROM eclipse-temurin:21 as build-env

# Add metadata
LABEL maintainer="srdjansvircevic@gmail.com"
LABEL description="Docker image for building the application"

# Set the working directory
WORKDIR /app

# Copy the entire project into the container
COPY . /app

# Ensure Maven wrapper is executable
RUN chmod +x ./mvnw

# Build the project, skipping tests
RUN ./mvnw clean install -Dmaven.test.skip

# Install Sentry CLI (optional depending on your use case)
RUN curl -sL https://sentry.io/get-cli/ | bash

# Authenticate Sentry CLI (this step may require an environment variable or secret key during the build process)
ARG SENTRY_AUTH_TOKEN
RUN sentry-cli login --auth-token=$SENTRY_AUTH_TOKEN

# Stage 2: Create a minimal runtime image
FROM eclipse-temurin:21-ubi9-minimal

# Set the working directory
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build-env /app/target/decem-0.0.1-SNAPSHOT.jar /app/

# Expose the port your application runs on (optional)
EXPOSE 8080

# Specify the command to run your application
ENTRYPOINT ["java", "-jar", "decem-0.0.1-SNAPSHOT.jar"]