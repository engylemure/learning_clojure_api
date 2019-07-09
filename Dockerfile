FROM clojure:openjdk-8-lein-alpine
COPY ./app /usr/src/app
COPY docker/  /files
RUN cp -rf /files/* /
RUN rm -rf /files

WORKDIR /usr/src/app
CMD ["sh", "/start.sh"]