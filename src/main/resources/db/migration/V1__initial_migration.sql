CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE addresses
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    street  VARCHAR(255) NOT NULL,
    city    VARCHAR(255) NOT NULL,
    zip     VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT addresses_users_id_fk
        FOREIGN KEY (user_id) REFERENCES users (id)
);