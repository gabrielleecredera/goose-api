FROM openjdk:16
# This jar file is created by running mvn package and looking in the target directory
COPY ./target/goose-0.0.1-SNAPSHOT.jar /goose-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/goose-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
