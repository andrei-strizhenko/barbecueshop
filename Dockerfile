FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080



##образ взятый за основу
#FROM openjdk:13
##Записываем в переменную путь до варника (необязательно)
#ARG jarFile=target/barbecue-0.0.2-SNAPSHOT.jar
##Куда переместить варник внутри контейнера
#WORKDIR /opt/app
##копируем наш джарник в новый внутри контейнера
#COPY ${jarFile} barbecue.jar
##Открываем порт
#EXPOSE 8080
##Команда для запуска
#ENTRYPOINT ["java", "-jar", "barbecue.jar"]




#FROM eclipse-temurin:13-jdk-alpine as build
#COPY . /usr/app
#WORKDIR /usr/app
#RUN chmod +x mvnw \
#    && ./mvnw --version \
#    && ./mvnw clean package
#
#FROM eclipse-temurin:13-jre-alpine
#COPY --from=build /usr/app/target/*.jar app.jar
#EXPOSE 8080
#
#ENTRYPOINT ["java","-jar","app.jar"]