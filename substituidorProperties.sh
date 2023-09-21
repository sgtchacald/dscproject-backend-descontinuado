#!/bin/bash

# Substituindo os marcadores de posição pelos valores dos secrets

#Dados de Conexão do banco de dados
sed -i "s/SPRING_DATASOURCE_URL/${{ secrets.SPRING_DATASOURCE_URL }}/g" src/main/resources/application-prod.properties
sed -i "s/SPRING_DATASOURCE_USERNAME/${{ secrets.SPRING_DATASOURCE_USERNAME }}/g" src/main/resources/application-prod.properties
sed -i "s/SPRING_DATASOURCE_PASSWORD/${{ secrets.SPRING_DATASOURCE_PASSWORD }}/g" src/main/resources/application-prod.properties

#Dados de Conexão de envio de email
sed -i "s/SPRING_MAIL_PASSWORD/${{ secrets.SPRING_MAIL_PASSWORD }}/g" src/main/resources/application-prod.properties
sed -i "s/SPRING_MAIL_USERNAME/${{ secrets.SPRING_MAIL_USERNAME }}/g" src/main/resources/application-prod.properties
