FROM mysql:8.0

# Copy all test_db files into a dedicated folder in /tmp
COPY test_db/ /tmp/test_db/

# Create an entrypoint script that sets the correct working directory
# so the 'source' commands inside employees.sql can find the .dump files
RUN echo '#!/bin/bash' > /docker-entrypoint-initdb.d/load.sh && \
    echo 'cd /tmp/test_db' >> /docker-entrypoint-initdb.d/load.sh && \
    echo 'mysql -u root -p"$MYSQL_ROOT_PASSWORD" < employees.sql' >> /docker-entrypoint-initdb.d/load.sh && \
    chmod +x /docker-entrypoint-initdb.d/load.sh

ENV MYSQL_ROOT_PASSWORD=example