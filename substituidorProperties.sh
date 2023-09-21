#!/bin/bash

TARGET_APPLICATION_PROD_PROPERTIES="src/main/resources/application-prod.properties"

# Substituindo os marcadores de posição pelos valores dos secrets

#Dados de Conexão do banco de dados
sed -i "s/SPRING_DATASOURCE_URL/${{ secrets.SPRING_DATASOURCE_URL }}/g" $TARGET_APPLICATION_PROD_PROPERTIES
sed -i "s/SPRING_DATASOURCE_USERNAME/${{ secrets.SPRING_DATASOURCE_USERNAME }}/g" $TARGET_APPLICATION_PROD_PROPERTIES
sed -i "s/SPRING_DATASOURCE_PASSWORD/${{ secrets.SPRING_DATASOURCE_PASSWORD }}/g" $TARGET_APPLICATION_PROD_PROPERTIES

#Dados de Conexão de envio de email
sed -i "s/SPRING_MAIL_PASSWORD/${{ secrets.SPRING_MAIL_PASSWORD }}/g" $TARGET_APPLICATION_PROD_PROPERTIES
sed -i "s/SPRING_MAIL_USERNAME/${{ secrets.SPRING_MAIL_USERNAME }}/g" $TARGET_APPLICATION_PROD_PROPERTIES
