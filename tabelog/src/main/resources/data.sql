--レコードの追加などに使う--

-- rolesテーブル --
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');

-- 会員テーブル --
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (1, '侍 太郎', 'サムライ タロウ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, true);

-- 店舗情報テーブル --
INSERT IGNORE INTO restaurants (id, name, category, image_name, description, price_high, price_low, capacity, open_time, close_time, postal_code, address, phone_number) VALUES (1, 'Rcoffee', 'カフェ', 'house01.jpg', '最寄り駅から徒歩20分。自然豊かで閑静な場所にあります。長期滞在も可能です。', 3000, 1000, 6, '9:00', '19:00', '444-0867', '愛知県岡崎市明大寺町西郷中39－30', '052－561-3399');
INSERT IGNORE INTO restaurants (id, name, category, image_name, description, price_high, price_low, capacity, open_time, close_time, postal_code, address, phone_number) VALUES (1, '元町珈琲', 'カフェ', 'house02.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', 3000, 1000, 6, '7:30', '21:00', '444-0867', '愛知県岡崎市明大寺町西郷中39－30', '052－561-3399');

-- 予約用テーブル --
INSERT IGNORE INTO reservations (id, restaurants_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (1, 1, 1, '2024-05-01', '14:00', 2);
