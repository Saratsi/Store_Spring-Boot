CREATE TABLE profiles
(
    id   INT PRIMARY KEY,
    bio  LONGTEXT NULL,
    phone_number  VARCHAR(15) NULL,
    date_of_birth DATE NULL,
    loyalty_points INT UNSIGNED DEFAULT 0 NULL,
    FOREIGN KEY (id) REFERENCES users(id)
);