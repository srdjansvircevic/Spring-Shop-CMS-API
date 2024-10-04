#!/bin/bash

set -e
# Variables
AWS_REGION="eu-west-1"
AWS_ACCOUNT_ID=""
REPOSITORY_NAME="shop/shop-api"
IMAGE_NAME="shop-api"
TAG="latest"
SENTRY_TOKEN=""
# Git tag to checkout (you can also specify this as a script parameter if desired)
GIT_TAG="0.1"  # Specify your tag here or make it dynamic

# Checkout the specified Git tag
git fetch --all --tags  # Ensure all tags are fetched
git checkout tags/$GIT_TAG

# Get ECR login password and store it in a variable
ECR_PASSWORD=$(aws ecr get-login-password --region $AWS_REGION)

# Log in to AWS ECR using the password
echo $ECR_PASSWORD | docker login --username AWS --password-stdin $AWS_ACCOUNT_ID.dkr.ecr.$AWS_REGION.amazonaws.com

# Build the Docker image
docker build -t $IMAGE_NAME . --build-arg SENTRY_AUTH_TOKEN=$SENTRY_TOKEN

# Tag the Docker image
docker tag $IMAGE_NAME:$TAG $AWS_ACCOUNT_ID.dkr.ecr.$AWS_REGION.amazonaws.com/$REPOSITORY_NAME:$TAG

# Push the Docker image to ECR
docker push $AWS_ACCOUNT_ID.dkr.ecr.$AWS_REGION.amazonaws.com/$REPOSITORY_NAME:$TAG