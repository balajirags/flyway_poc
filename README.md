flyway_poc
==========

Prerequisites:

Postgres 9 or above.

Create Schema:
create database flywaypoc_dev;
create database flywaypoc_prod;

Create User:
create user flywaypoc_user with password 'password';

GRANT ALL PRIVILEGES ON DATABASE flywaypoc_dev to flywaypoc_user;
GRANT ALL PRIVILEGES ON DATABASE flywaypoc_prod to flywaypoc_user;



How to Build: gradle build

How to Migrate:
gradle flywayMigrate -Penv=prod or gradle flywayMigrate -Penv=dev

*default is dev


