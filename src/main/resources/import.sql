INSERT INTO categories (name, description) VALUES ('Electrodomésticos', 'Productos electrónicos para el hogar, como electrodomésticos y dispositivos para facilitar las tareas diarias.');
INSERT INTO categories (name, description) VALUES ('Libros y Literatura', 'Libros de diversas categorías y géneros, así como artículos relacionados con la literatura y la lectura.');
INSERT INTO categories (name, description) VALUES ('Deportes y Aventuras', 'Artículos y equipos deportivos, ropa para actividades al aire libre y productos relacionados con deportes y aventuras.');
INSERT INTO categories (name, description) VALUES ('Salud y Bienestar', 'Productos y servicios relacionados con la salud, el bienestar personal, suplementos y artículos para un estilo de vida saludable.');

INSERT INTO products (name, description, price, category_id, status) VALUES ('TV Samsung 60 pulgadas', null, 1000.99, 1, 1);
INSERT INTO products (name, description, price, category_id, status) VALUES ('Licuadora Oster', null, 129.95, 1, 1);
INSERT INTO products (name, description, price, category_id, status) VALUES ('Harry Potter y la piedra filosofal', null, 10.99, 2, 1);
INSERT INTO products (name, description, price, category_id, status) VALUES ('IT', null, 15.95, 2, 1);
INSERT INTO products (name, description, price, category_id, status) VALUES ('Bicicleta montañera', null, 899.99, 3, 1);
INSERT INTO products (name, description, price, category_id, status) VALUES ('Tabla de Surf', null, 450, 3, 1);
INSERT INTO products (name, description, price, category_id, status) VALUES ('Pasta dental Colgate', null, 8.99, 4, 1);

INSERT INTO clients (name, email, phone, status) VALUES ('John Doe', 'john.doe@example.com', '123-456-7890', 1);
INSERT INTO clients (name, email, phone, status) VALUES ('Jane Smith', 'jane.smith@example.com', '234-567-8901', 1);
INSERT INTO clients (name, email, phone, status) VALUES ('Michael Brown', 'michael.brown@example.com', '345-678-9012', 1);
INSERT INTO clients (name, email, phone, status) VALUES ('Emily Johnson', 'emily.johnson@example.com', '456-789-0123', 1);
INSERT INTO clients (name, email, phone, status) VALUES ('David Wilson', 'david.wilson@example.com', '567-890-1234', 1);
