-- 店舗情報テーブル --
INSERT IGNORE INTO restaurants (id, name, category, image_file, description, price_high, price_low, capacity, open_time, close_time, postal_code, address, phone_number) VALUES (1, 'Rcoffee', 'カフェ', 'house01.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', 2000, 1000, 6, '9:00', '19:00', '073-0145', '北海道砂川市西五条南X-XX-XX', '012-345-678');

-- rolesテーブル
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');

-- 会員テーブル --
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (1, '侍 太郎', 'サムライ タロウ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, true);

-- reservationsテーブル
INSERT IGNORE INTO reservations (id, restaurants_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (1, 1, 1, '2024-05-01', '14:00', 2, 6000);
