# camel-playgrounds-quartz

## Usage

    docker build -t camel-playgrounds/camel-playgrounds-quartz .

    docker run -d --name quartz1 -v <PATH_TO_CONFIG>:/opt/quartz/config:z camel-playgrounds/camel-playgrounds-quartz
    docker run -d --name quartz2 -v <PATH_TO_CONFIG>:/opt/quartz/config:z camel-playgrounds/camel-playgrounds-quartz