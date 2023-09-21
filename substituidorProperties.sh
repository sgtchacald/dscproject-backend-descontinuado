#!/bin/bash

# Substituindo os marcadores de posição pelos valores dos secrets

#Dados de Conexão do banco de dados
sed -i "s|spring.datasource.url=.*|spring.datasource.url=${SPRING_DATASOURCE_URL}|" src/main/resources/application-prod.properties
sed -i "s|spring.datasource.url=.*|spring.datasource.url=${SPRING_DATASOURCE_USERNAME}|" src/main/resources/application-prod.properties
sed -i "s|spring.datasource.url=.*|spring.datasource.url=${SPRING_DATASOURCE_PASSWORD}|" src/main/resources/application-prod.properties

#Dados de Conexão de envio de email
sed -i "s|spring.datasource.url=.*|spring.datasource.url=${SPRING_MAIL_PASSWORD}|" src/main/resources/application-prod.properties
sed -i "s|spring.datasource.url=.*|spring.datasource.url=${SPRING_MAIL_USERNAME}|" src/main/resources/application-prod.properties
