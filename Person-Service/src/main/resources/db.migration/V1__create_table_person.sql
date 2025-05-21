CREATE SCHEMA IF NOT EXISTS microservices;

CREATE TABLE IF NOT EXISTS microservices.users (
    id BIGSERIAL PRIMARY KEY,
    firstName VARCHAR(25) NOT NULL,
    lastName VARCHAR(25) NOT NULL,
    middleName VARCHAR(25) NOT NULL,
    deliveryAddress VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL
);