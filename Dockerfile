FROM openjdk:8u212-jre-slim-stretch
COPY patcher-bundled.jar /target/
ENTRYPOINT ["java", "-cp", "/target/patcher-bundled.jar", "org.datahem.patcher.Patcher"]