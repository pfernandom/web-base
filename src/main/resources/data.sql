INSERT INTO users(userid, username,email,password,enabled) VALUES (1,'admin','abc@abc.com','$2a$08$gnERKdidfhKIxTEs16aiTOJI9CUWLLtAJBSN/wVFVR.Lsr4unS7UK', true);
INSERT INTO users(userid, username,email,password,enabled) VALUES (2,'user','abc@abc.com','$2a$08$YsPgl7JXD83Q2iyIVm8G4e0AZyWMgsxFzXAihWpQdMx9bBnz6J4ie', true);
INSERT INTO user_roles(user_role_id, userid, role) VALUES (1,1,'ROLE_USER');
INSERT INTO user_roles(user_role_id, userid, role) VALUES (2,1,'ROLE_ADMIN');
INSERT INTO user_roles(user_role_id, userid, role) VALUES (3,2,'ROLE_USER');