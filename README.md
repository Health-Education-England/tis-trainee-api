# TIS Trainee API

## About
This repository holds the OpenAPI documentation for the TIS Trainee API.

The latest documentation is always available at [health-education-england.github.io/tis-trainee-api](https://health-education-england.github.io/tis-trainee-api/).

Preview of open PRs are available by appending `/pr-preview/pr-{number}` to the end of the
above path e.g. `health-education-england.github.io/tis-trainee-api/pr-preview/pr-123`.

## Developing

### Editing
The [API documentation](openapi.yml) can be worked on within any text editor or
IDE. Plugins are available for several popular IDEs.

### Previewing
Several options are provided for previewing the documentation.

#### Docker
A [Docker compose](docker-compose.yml) file is provided for ease of use, the
[openapi.yml](openapi.yml) file will be mapped in to the container so edits can
be viewed without restarting the container. Run `docker compose up -d` followed
by navigating to `http://localhost:8080`.

#### NPM
Node can be used to bundle and serve an OpenAPI viewer by running `npm run start`,
the viewer will open automatically.

## Versioning
This project uses [Semantic Versioning](semver.org).

## License
This project is license under [The MIT License (MIT)](LICENSE).
