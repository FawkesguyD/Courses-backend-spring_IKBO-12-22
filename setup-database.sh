#!/bin/bash

PGPASSWORD=j7H851 psql -h 89.179.240.191 -p 5432 -U daniel -d courses -f src/main/resources/schema.sql 