CREATE TABLE IF NOT EXISTS _user (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS clients (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(25) NOT NULL,
    date_of_birth DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS trainers (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(25) NOT NULL,
    qualification_id SERIAL NOT NULL
--    FOREIGN KEY (qualification_id) REFERENCES qualifications(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS qualifications (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS sessions (
    id SERIAL PRIMARY KEY,
    trainer_id SERIAL NOT NULL,
    session_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    description TEXT NOT NULL
--    FOREIGN KEY (trainer_id) REFERENCES trainers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS bookings (
    id SERIAL PRIMARY KEY,
    client_id SERIAL NOT NULL,
    session_id SERIAL NOT NULL,
    status BOOLEAN NOT NULL
--    FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE,
--    FOREIGN KEY (session_id) REFERENCES sessions(id) ON DELETE CASCADE
);