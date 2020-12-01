//Tabla para guardar la info del token de refresco: token que es cuando en el trabajo te piden darle mas tiempo a tu token sin tener que desloguearte
create table oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);
//para ir probando
select * from oauth_access_token;
select * from oauth_refresh_token;

PARA OBTENER EL TOKEN DE REFRESCO DE POSTMAN, DEBEN OBTENER EL TOKEN COMO SIEMPRE
delete from oauth_access_token;
delete from oauth_refresh_token;
select * from reset_token;