# Temel imaj: Java 23 içeren açık kaynaklı bir JDK
FROM openjdk:23-jdk-slim

# Çalışma dizini oluştur
WORKDIR /app

# Maven derlenmiş jar dosyasını konteynıra kopyala
COPY target/accessing-data-mongodb-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]