#!/usr/bin/env bash

AWS_REGION=us-east-1
AWS_LOCALSTACK_URL="http://localhost.localstack.cloud:4566"

echo
echo
echo "Creating S3 bucket"
echo "------------------"

docker exec -t localstack aws --endpoint-url=http://localhost:4566 s3 mb s3://jrxml-java-jasperreport

echo
echo "Creating secrets in secretsmanager"
echo "----------------------------------"

docker exec -t localstack aws --endpoint-url=http://localhost:4566 secretsmanager create-secret --name omdbApiKey --secret-string $OMDB_API_KEY

echo
echo "----------------------------------------"
echo "           AWS_LOCALSTACK_URL=$AWS_LOCALSTACK_URL"
echo "AWS_LOCALSTACK_OPENSEARCH_URL=$AWS_LOCALSTACK_OPENSEARCH_URL"
echo "----------------------------------------"
echo