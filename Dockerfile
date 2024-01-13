FROM debian:bullseye-slim

RUN apt-get update \
	&& apt-get upgrade -y \
	&& apt-get install -y \
		openjdk-21-jre \
    && rm -rf /var/cache/apt/* \
    && rm -rf /var/lib/apt/lists/*

RUN mkdir /app

ENV USER_NAME=docker USER_GROUP=docker
RUN addgroup --system $USER_NAME && adduser --system $USER_NAME --ingroup $USER_GROUP
USER root:root

COPY build/docker /

RUN chown -R ${USER_NAME}:${USER_GROUP} /app
USER ${USER_NAME}:${USER_GROUP}
WORKDIR "/app"

ENTRYPOINT ["java","-Dspring.profiles.active=deployed","-cp","app:app/lib/*","com.github.pacificengine.Application"]