DROP DATABASE IF EXISTS cardealership;
CREATE DATABASE cardealership;
USE cardealership;

CREATE TABLE dealerships (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(25)
);

CREATE TABLE vehicles (
    vin VARCHAR(17) PRIMARY KEY,
    year INT,
    make VARCHAR(50),
    model VARCHAR(50),
    type VARCHAR(50),
    color VARCHAR(50),
    odometer INT,
    price DECIMAL(10,2)
);

CREATE TABLE inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dealership_id INT,
    vin VARCHAR(17),
    FOREIGN KEY (dealership_id) REFERENCES dealerships(id),
    FOREIGN KEY (vin) REFERENCES vehicles(vin)
);

CREATE TABLE sales_contracts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vin VARCHAR(17),
    customer_name VARCHAR(100),
    customer_email VARCHAR(100),
    sales_tax DECIMAL(10,2),
    recording_fee DECIMAL(10,2),
    processing_fee DECIMAL(10,2),
    total_price DECIMAL(10,2),
    monthly_payment DECIMAL(10,2),
    date_sold DATE,
    FOREIGN KEY (vin) REFERENCES vehicles(vin)
);

CREATE TABLE lease_contracts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vin VARCHAR(17),
    customer_name VARCHAR(100),
    customer_email VARCHAR(100),
    lease_fee DECIMAL(10,2),
    total_price DECIMAL(10,2),
    monthly_payment DECIMAL(10,2),
    end_date DATE,
    FOREIGN KEY (vin) REFERENCES vehicles(vin)
);
