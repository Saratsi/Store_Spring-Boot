CREATE TABLE orders
(
    id          INTEGER auto_increment PRIMARY KEY,
    customer_id INTEGER    NOT NULL ,
    status      VARCHAR(20)  NOT NULL ,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ,
    total_price DECIMAL(10, 2)   NOT NULL ,
    CONSTRAINT orders_users_id_fk
        FOREIGN KEY (customer_id) REFERENCES users (id)
);
