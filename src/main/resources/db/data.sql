--Data
INSERT INTO oauth_client_details(client_id, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES('client1', '$2a$10$pzif2WsisfxEzyLuLMS4huaB1wGSVLuRWcxPt1NVJg3IPfoAGUx6.', 'read', 'password,authorization_code,refresh_token', null, null, 60, 120, null, true);
INSERT INTO oauth_client_details(client_id, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES('client2', '$2a$10$pzif2WsisfxEzyLuLMS4huaB1wGSVLuRWcxPt1NVJg3IPfoAGUx6.', 'read,write', 'password,implicit', null, null, 60, 120, null, false);
INSERT INTO oauth_client_details(client_id, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES('client3', '$2a$10$pzif2WsisfxEzyLuLMS4huaB1wGSVLuRWcxPt1NVJg3IPfoAGUx6.', 'bar,read,write', 'password,authorization_code,refresh_token', null, null, 60, 120, null, true);