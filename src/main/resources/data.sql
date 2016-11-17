INSERT INTO users(userid, username,email,password,enabled) VALUES (1,'user','abc@abc.com','password', true);
INSERT INTO user_roles(user_role_id, userid, role) VALUES (1,1,'ROLE_USER');
INSERT INTO user_roles(user_role_id, userid, role) VALUES (2,1,'ROLE_ADMIN');