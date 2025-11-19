create table carts
(
    id  BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) NOT NULL PRIMARY KEY,
    date_created DATE  DEFAULT (CURDATE())  NOT NULL
);

CREATE TABLE cart_items
(
    id         INTEGER auto_increment PRIMARY KEY,
    cart_id    BINARY(16)    NOT NULL,
    product_id INTEGER       NOT NULL,
    quantity   INT DEFAULT 1 NOT NULL,
    CONSTRAINT cart_items_card_product_unique
        UNIQUE (cart_id, product_id),
    CONSTRAINT cart_items_carts_id_fk
        FOREIGN KEY (cart_id) REFERENCES carts (id)
            on delete cascade,
    CONSTRAINT cart_items_products_id_fk
        FOREIGN KEY (product_id) REFERENCES products (id)
            ON DELETE CASCADE
);