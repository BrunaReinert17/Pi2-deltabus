 create table usuario1(
email varchar(20),
senha varchar(10)
);

 -- select * from usuario;

 INSERT INTO usuario (email, senha) values ('bruna@gmail.com', md5('1312'));
 -- INSERT INTO usuario (email, senha) values ('Alex@gmail.com', md5('1234'));

 select md5('1312');

-- select email, aes_decrypt(senha,'ZEUS') from usuario2;