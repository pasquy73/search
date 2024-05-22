FROM openjdk:11-slim
COPY /home/runner/work/search/search/search-engine.jar /usr/app/
WORKDIR /usr/app

RUN apt-get update && apt-get install -y \
	curl \
	wget
	
ENTRYPOINT exec java $JAVA_OPTS -jar search-engine.jar
