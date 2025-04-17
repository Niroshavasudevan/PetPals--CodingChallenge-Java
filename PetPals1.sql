CREATE DATABASE IF NOT EXISTS petpals;
USE petpals;
DROP TABLE IF EXISTS adoption;
DROP TABLE IF EXISTS pets;

CREATE TABLE pets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    breed VARCHAR(50)
);

DROP TABLE IF EXISTS donations;

CREATE TABLE donations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    donor_name VARCHAR(100),
    amount DECIMAL(10,2) CHECK (amount >= 10),
    donation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE adoption_events (
    id INT PRIMARY KEY,
    event_name VARCHAR(100),
    event_date DATE
);
CREATE TABLE participants (
    id INT AUTO_INCREMENT PRIMARY KEY,
    participant_name VARCHAR(100),
    event_id INT,
    FOREIGN KEY (event_id) REFERENCES adoption_events(id)
);


-- Insert into pets
INSERT INTO pets (id, name, age, breed) VALUES
(1, 'Buddy', 3, 'Golden Retriever'),
(2, 'Luna', 2, 'Labrador'),
(3, 'Milo', 1, 'Beagle'),
(4, 'Simba', 4, 'Pomeranian'),
(5, 'Bella', 5, 'German Shepherd');

-- Insert into donations
INSERT INTO donations (id, donor_name, amount) VALUES
(1, 'Priya Kumar', 500.00),
(2, 'Ravi Shankar', 1000.50),
(3, 'Meena Joshi', 250.75),
(4, 'Arun Raj', 750.00),
(5, 'Sneha Iyer', 300.00);

-- Insert into adoption_events
INSERT INTO adoption_events (id, event_name, event_date, event_location) VALUES
(1, 'Summer Pet Fest', '2025-05-01', 'City Park'),
(2, 'Adopt-a-thon', '2025-06-10', 'Town Square'),
(3, 'Furry Friends Fiesta', '2025-07-15', 'Community Center'),
(4, 'Pawfect Day Out', '2025-08-20', 'Beachside'),
(5, 'Love a Pet Day', '2025-09-25', 'Pet Shelter');

-- Insert into participants
INSERT INTO participants (participant_name, event_id) VALUES
('Aarav Nair', 1),
('Divya Rao', 2),
('Karthik Menon', 3),
('Anjali Das', 4),
('Rohan Shetty', 5);






select * from pets;
select * from donations;

