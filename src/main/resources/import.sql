INSERT INTO user(id, username,password, name, email) VALUES (1, 'admin','123456','老魏','i@waylau.com');
INSERT INTO user(id, username,password, name, email) VALUES (2, 'waylau','123456','way lau','waylau@waylau.com');

INSERT INTO authority(id, name) VALUES (1, 'ROLW_ADMIN');
INSERT INTO authority(id, name) VALUES (2, 'ROLW_USER');

INSERT INTO user_authority(user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority(user_id, authority_id) VALUES (2, 2);