FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn package

FROM tomcat:10
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]

# docker run -it --rm -p 8888:8080
