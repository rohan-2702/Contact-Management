
-- Create the contacts table (if not already created)

CREATE TABLE contacts (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(20),
    company VARCHAR(100),
    job_title VARCHAR(100)
);