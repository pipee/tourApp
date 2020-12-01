Para generar un token desde POSTMAN
NOTA: Si su backend esta programado para que los tokens se guarden en base de datos debe tener esta tabla creada
--Codigo para postgreSQL
create table oauth_access_token (
token_id VARCHAR(256),
token bytea,
authentication_id VARCHAR(256),
user_name VARCHAR(256),
client_id VARCHAR(256),
authentication bytea,
refresh_token VARCHAR(256)
);