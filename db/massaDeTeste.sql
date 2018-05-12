USE db_gecon;
INSERT INTO td_perfil (nme_perfil) VALUES ('ADMINISTRADOR'), ('SINDICO'), ('FUNCIONARIO'), ('MORADOR');

INSERT INTO tb_pessoa (nme_pessoa, cpf_pessoa, dta_nasc_pessoa, tel_pessoa, eml_pessoa) VALUES
('JOAO SIILVA PEREIRA', '12345678900', '2000/01/01', '123456789', 'JOAOZINHOPAI@EMAIL.COM'),
('MARIA JOSE SANTOS PEREIRA', '09876543211', '2000/02/01', '123456789', 'MARIAZINHAMAE@EMAIL.COM'),
('JOAOZINHO SANTOS PEREIRA', '11111111111', '2010/01/01', '123456789', 'JOAOZINHOFILHO@EMAIL.COM');

INSERT INTO tb_condominio (nme_condominio, dsc_local_condominio) VALUES ('CONDOMINIO DE TESTE', 'BRASILIA-DF');

INSERT INTO tb_residencia (cod_condominio, dsc_residencia, dsc_bloco_residencia) VALUES (1, '101', 'A');

INSERT INTO tb_garagem (cod_residencia, dsc_garagem) VALUES (1, '101');

INSERT INTO ta_morador (cod_pessoa, cod_residencia) VALUES (1, 1), (2, 1), (3, 1);

INSERT INTO tb_usuario (login_usuario, pwd_usuario, cod_morador, cod_perfil, role) VALUES ('JOAOZINHO', '123456', 1, 2, 'ADMIN');

COMMIT;