# Etapa 1: Construcción de la aplicación
FROM maven:3.8.4-openjdk-17-slim AS build

# Crear directorio de trabajo para la aplicación
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias de Maven
COPY pom.xml .
RUN mvn dependency:resolve

# Copiar el resto de los archivos del proyecto y compilarlo
COPY src /app/src
RUN mvn clean test package

# Etapa 2: Configuración de Tomcat para ejecutar la aplicación
FROM tomcat:10.1.8-jdk17

# Instalar Derby
RUN apt-get update && apt-get install -y wget && \
    wget https://archive.apache.org/dist/db/derby/db-derby-10.16.1.1/db-derby-10.16.1.1-lib.tar.gz && \
    tar -xzf db-derby-10.16.1.1-lib.tar.gz && \
    mv db-derby-10.16.1.1-lib /opt/derby && \
    ln -s /opt/derby/ij.jar /usr/local/bin/ij && \
    rm db-derby-10.16.1.1-lib.tar.gz

# Crear un directorio para almacenar los datos de Derby
RUN mkdir /usr/local/tomcat/data

# Copiar el archivo WAR generado en la etapa de construcción
COPY --from=build /app/target/demo-java-web-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Copiar el archivo data.sql al contenedor
COPY data.sql /usr/local/tomcat/data/data.sql

# Configurar Derby como base de datos embebida y especificar el directorio de almacenamiento
ENV DERBY_HOME=/usr/local/tomcat/derby
ENV DERBY_DATA_HOME=/usr/local/tomcat/data

# Exponer el puerto en el que correrá Tomcat
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
