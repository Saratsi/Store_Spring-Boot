CREATE TABLE wishlist
(
    product_id INT NOT NULL ,
    user_id INT NOT NULL,
    PRIMARY KEY (product_id, user_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);