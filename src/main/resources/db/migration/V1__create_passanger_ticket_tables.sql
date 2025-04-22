CREATE TABLE client (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL CHECK LENGTH(name) BETWEEN 3 AND 200
);

CREATE TABLE planet (
    id VARCHAR(50) PRIMARY KEY CHECK id ~ '^[A-Z0-9]+$',
    name VARCHAR(500) NOT NULL CHECK LENGTH(name) BETWEEN 1 AND 500
);

CREATE TABLE ticket (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    client_id BIGINT NOT NULL,
    from_planet_id VARCHAR(50) NOT NULL,
    to_planet_id VARCHAR(50) NOT NULL,

    CONSTRAINT fk_ticket_client FOREIGN KEY (client_id) REFERENCES client(id),
    CONSTRAINT fk_ticket_from_planet FOREIGN KEY (from_planet_id) REFERENCES planet(id),
    CONSTRAINT fk_ticket_to_planet FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);
