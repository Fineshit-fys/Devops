FROM mysql/mysql-server:latest

WORKDIR /tmp

COPY ../src/main/java/com/test_db/*.sql /tmp/
COPY ../src/main/java/com/test_db/*.dump /tmp/
COPY ../src/main/java/com/test_db/employees.sql /docker-entrypoint-initdb.d/

ENV MYSQL_ROOT_PASSWORD=example
ENV MYSQL_ROOT_HOST=%