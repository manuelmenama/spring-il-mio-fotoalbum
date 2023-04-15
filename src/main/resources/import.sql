INSERT INTO db_photo.images (created_at, description, path_image, is_visible, title, updated_at) VALUES('2023-04-13 16:00', 'Una foto di tanti anni fà...', 'https://picsum.photos/seed/collo/1000/800', 1, 'Un viaggio', '2023-04-13 16:00');
INSERT INTO db_photo.images (created_at, description, path_image, is_visible, title, updated_at) VALUES('2023-04-13 16:00', 'Tu che ne sai di un campo di grano?', 'https://picsum.photos/seed/mente/1000/800', 0, 'La mente', '2023-04-13 16:00');
INSERT INTO db_photo.images (created_at, description, path_image, is_visible, title, updated_at) VALUES('2023-04-13 16:00', 'Eravamo quattro amici al bar.', 'https://picsum.photos/seed/solo/1000/800', 1, 'Solitario', '2023-04-13 16:00');
INSERT INTO db_photo.images (created_at, description, path_image, is_visible, title, updated_at) VALUES('2023-04-13 16:00', 'Sogno di una notte di mezza estate.', 'https://picsum.photos/seed/abaco/1000/800', 1, 'Abcazia', '2023-04-13 16:00');
INSERT INTO db_photo.images (created_at, description, path_image, is_visible, title, updated_at) VALUES('2023-04-13 16:00', 'La bella e la bestia', 'https://picsum.photos/seed/due/1000/800', 1, 'Ballo', '2023-04-13 16:00');
INSERT INTO db_photo.images (created_at, description, path_image, is_visible, title, updated_at) VALUES('2023-04-13 16:00', 'Degrado urbano.', 'https://picsum.photos/seed/strada/1000/800', 1, 'Vicolo', '2023-04-13 16:00');
-- insert category
INSERT INTO db_photo.categories (created_at, name, updated_at) VALUES('2023-04-14 12:00', 'Natura Morta', '2023-04-14 12:00');
INSERT INTO db_photo.categories (created_at, name, updated_at) VALUES('2023-04-14 12:00', 'Panorama', '2023-04-14 12:00');
INSERT INTO db_photo.categories (created_at, name, updated_at) VALUES('2023-04-14 12:00', 'Matrimonio', '2023-04-14 12:00');
INSERT INTO db_photo.categories (created_at, name, updated_at) VALUES('2023-04-14 12:00', 'Set Fotografico', '2023-04-14 12:00');
INSERT INTO db_photo.categories (created_at, name, updated_at) VALUES('2023-04-14 12:00', 'Urbano', '2023-04-14 12:00');
INSERT INTO db_photo.categories (created_at, name, updated_at) VALUES('2023-04-14 12:00', 'Ritratto', '2023-04-14 12:00');
--insert category-image
INSERT INTO db_photo.category_image (image_id, category_id) VALUES(1, 1);
INSERT INTO db_photo.category_image (image_id, category_id) VALUES(1, 2);
INSERT INTO db_photo.category_image (image_id, category_id) VALUES(2, 6);
INSERT INTO db_photo.category_image (image_id, category_id) VALUES(2, 5);
INSERT INTO db_photo.category_image (image_id, category_id) VALUES(3, 3);
INSERT INTO db_photo.category_image (image_id, category_id) VALUES(4, 4);
INSERT INTO db_photo.category_image (image_id, category_id) VALUES(4, 2);
INSERT INTO db_photo.category_image (image_id, category_id) VALUES(5, 4);
INSERT INTO db_photo.category_image (image_id, category_id) VALUES(5, 1);
INSERT INTO db_photo.category_image (image_id, category_id) VALUES(6, 6);
--insert users
INSERT INTO db_photo.users (created_at, email, first_name, password, second_name, updated_at) VALUES('2023-04-15 11:00', 'boss@email.com', 'Boss', '{noop}boss', 'Delle Torte', '2023-04-15 11:00');
INSERT INTO db_photo.users (created_at, email, first_name, password, second_name, updated_at) VALUES('2023-04-15 11:00', 'steve@email.com', 'Steve', '{noop}steve', 'Stivali', '2023-04-15 11:00');
--insert roles
INSERT INTO db_photo.roles (title) VALUES('ADMIN');
INSERT INTO db_photo.roles (title) VALUES('USER');
--insert user-role
INSERT INTO db_photo.role_user (user_id, role_id) VALUES(1, 1);
INSERT INTO db_photo.role_user (user_id, role_id) VALUES(2, 2);
--insert contact
--INSERT INTO db_photo.contact (email, `text`, title) VALUES('billiballo@email.com', 'Come ti avevo promesso ho visto tutte le tue foto e sono assolutamente stupefacenti.', 'Foto straordinarie');
--INSERT INTO db_photo.contact (email, `text`, title) VALUES('billiballo@email.com', 'Come ti avevo promesso ho visto tutte le tue foto e sono assolutamente stupefacenti.', 'Foto straordinarie');
INSERT INTO db_photo.contact (created_at, email, `text`, title, updated_at) VALUES('2023-04-15 17:00', 'billiballo@email.com', 'Come ti avevo promesso ho visto tutte le tue foto e sono assolutamente stupefacenti.', 'Foto straordinarie', '2023-04-15 17:00');
INSERT INTO db_photo.contact (created_at, email, `text`, title, updated_at) VALUES('2023-04-15 17:00', 'miaemail@email.com', 'Volevo proporle un ottimo aspirapolvere.', 'Promo straordinaria!', '2023-04-15 17:00');


