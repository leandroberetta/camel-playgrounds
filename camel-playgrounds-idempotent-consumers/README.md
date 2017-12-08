# camel-playgrounds-idempotent-consumers

## Usage

    docker build -t camel-playgrounds/camel-playgrounds-idempotent-consumers .

    docker run -d --name idemcon1 -v <PATH_TO_CONFIG>:/opt/quartz/config:z -v <PATH_TO_FILES>:/opt/quartz/files:z camel-playgrounds/camel-playgrounds-idempotent-consumers
    docker run -d --name idemcon2 -v <PATH_TO_CONFIG>:/opt/quartz/config:z -v <PATH_TO_FILES>:/opt/quartz/files:z camel-playgrounds/camel-playgrounds-idempotent-consumers