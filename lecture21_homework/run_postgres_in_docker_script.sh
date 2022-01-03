#!/usr/bin/bash

docker run \
-p 5429:5432 \
-e POSTGRES_PASSWORD=docker_HW \
-e POSTGRES_DB=docker_HW \
-d \
--name docker_HW \
postgres:13.1