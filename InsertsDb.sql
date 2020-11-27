INSERT INTO provedor(ip, nome)
VALUES ('200.233.139.187', 'Oi'),
	   ('187.95.41.68', 'Alta Rede'),
       ('138.204.203.110', 'New Group'),
       ('187.180.225.153', 'NET'),
       ('187.95.41.69', 'Autotrac');

INSERT INTO integracao(nome, porta, provedor_id)
VALUES ('IASWS', 7070, 1),
       ('Sighra', 58136, 2),
       ('Autotrac', 78518, 5);