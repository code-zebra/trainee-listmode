DROP TABLE IF EXISTS goods_order;

CREATE TABLE goods_order(
    order_id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    sn BIGINT NOT NULL
);
