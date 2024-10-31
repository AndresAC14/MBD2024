FROM amazoncorretto:23-alpine-jdk

COPY Main.java /app/

WORKDIR /app/

RUN javac Main.java

ENTRYPOINT ["java", "Main"]