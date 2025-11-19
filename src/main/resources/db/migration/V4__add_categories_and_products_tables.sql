CREATE TABLE categories
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE products
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    description LONGTEXT NOT NULL,
    category_id INT NULL,
    CONSTRAINT fk_category
        FOREIGN KEY  (category_id) REFERENCES categories(id) ON DELETE NO ACTION
);