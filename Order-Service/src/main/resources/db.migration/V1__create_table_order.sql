CREATE TABLE microservices.orders (
    id BIGSERIAL PRIMARY KEY,
    userId BIGINT NOT NULL,
    totalAmount DOUBLE PRECISION NOT NULL,
    currency VARCHAR(10) NOT NULL,
    quantity BIGINT NOT NULL
);