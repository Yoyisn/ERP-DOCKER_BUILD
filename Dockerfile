#Para contruir la aplicacion
#FROM eclipse-temurin:23-jdk AS builder

#Paras setear el directorio de trabajo
#WORKDIR /app

# Copiar el codigo de la aplicacion
#COPY . .

#Contruir la aplicacion (Requiere Maven o Gradle)
#RUN ./mvnw clean package -DskipTests

#Correr la aplicacion
#FROM eclipse-temurin:23-jre

#Setear el directorio de trabajo
#WORKDIR /app

#Copiar el archivo JAR del directorio de trabajo
#COPY --from=builder /app/target/*.jar app.jar

#Exponer el puesto donde la aplicacion correra
#EXPOSE 9191

#Comando para correr la aplicacion
#ENTRYPOINT [ "java", "-jar", "app.jar" ]


# Etapa de build
FROM eclipse-temurin:23-jdk AS builder
WORKDIR /app

# Copiar el wrapper y archivos de build primero para aprovechar cache
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Descargar dependencias
RUN ./mvnw dependency:go-offline -B

# Copiar el código fuente y construir
COPY src ./src
RUN ./mvnw clean package -DskipTests -B

# Etapa final
FROM eclipse-temurin:23-jre
WORKDIR /app

# Copiar el JAR generado (asume que Spring Boot produce un fat jar en target/)
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 9191

ENTRYPOINT [ "java", "-jar", "app.jar" ]