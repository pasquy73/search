FROM openjdk:11-slim
COPY /home/runner/work/search/search/staging/search-engine.jar /usr/app/
WORKDIR /usr/app

RUN apt-get update && apt-get install -y \
	curl \
	wget
	
ENTRYPOINT exec java $JAVA_OPTS -jar search-0.0.1-SNAPSHOT.jar
