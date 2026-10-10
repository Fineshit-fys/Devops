FROM mysql:8.0

# Copy test_db files into container
COPY test_db/ /tmp/test_db/

# Create an initialization script to load the employees database correctly
RUN echo '#!/bin/bash' > /docker-entrypoint-initdb.d/load.sh && \
    echo 'cd /tmp/test_db' >> /docker-entrypoint-initdb.d/load.sh && \
    echo 'mysql -u root -p"$MYSQL_ROOT_PASSWORD" < employees.sql' >> /docker-entrypoint-initdb.d/load.sh && \
    chmod +x /docker-entrypoint-initdb.d/load.sh

ENV MYSQL_ROOT_PASSWORD=example