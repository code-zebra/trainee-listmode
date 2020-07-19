DROP TABLE IF EXISTS order_item;

CREATE TABLE order_item(
    order_id BIGINT REFERENCES goods_order(order_id),
    goods_id BIGINT NOT NULL,
    info_id BIGINT NOT NULL,
    number INT NOT NULL,
    price FLOAT
);
