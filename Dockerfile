# Usar una imagen base de Maven con OpenJDK
FROM maven:3.8.6-openjdk-11-slim AS build

# Crear directorio de trabajo para la aplicación
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias de Maven
COPY pom.xml .
RUN mvn dependency:resolve

# Copiar el resto de los archivos del proyecto y compilarlo
COPY src /app/src
RUN mvn clean package

# Crear directorio para la base de datos Derby
RUN mkdir /data

# Especificar el archivo .war como variable
ARG JAR_FILE=target/demo-java-web-1.0-SNAPSHOT.war

# Copiar el archivo .war generado al contenedor
COPY ${JAR_FILE} /app/app.war

# Exponer el puerto del servidor (asegúrate de usar el puerto de tu aplicación web)
EXPOSE 8080

# Iniciar la aplicación y Apache Derby
CMD ["java", "-Dderby.system.home=/data", "-jar", "/app/app.war"]
