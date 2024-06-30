INSERT INTO clients (first_name, last_name, email, phone, date_of_birth) VALUES
('Иван', 'Иванов', 'ivan.ivanov@example.com', '+79101234567', '1985-01-15'),
('Мария', 'Петрова', 'maria.petrova@example.com', '+79201234568', '1990-05-25'),
('Алексей', 'Сидоров', 'alexey.sidorov@example.com', '+79301234569', '1988-07-10');

INSERT INTO qualifications (name) VALUES
('КМС'),
('МС'),
('МСМК'),
('ЗМС');

INSERT INTO trainers (first_name, last_name, email, phone, qualification_id) VALUES
('Дмитрий', 'Кузнецов', 'dmitry.kuznetsov@example.com', '+79401234560', 1),
('Екатерина', 'Смирнова', 'ekaterina.smirnova@example.com', '+79501234561', 2),
('Сергей', 'Попов', 'sergey.popov@example.com', '+79601234562', 3);

INSERT INTO sessions (trainer_id, session_date, start_time, end_time, description) VALUES
(1, '2024-06-25', '10:00:00', '11:00:00', 'Тренировка по дзюдо для начинающих'),
(2, '2024-06-25', '12:00:00', '13:00:00', 'Продвинутые техники дзюдо'),
(3, '2024-06-26', '09:00:00', '10:30:00', 'Индивидуальная тренировка по дзюдо');

INSERT INTO bookings (client_id, session_id, status) VALUES
(1, 1, TRUE),
(2, 2, TRUE),
(3, 3, TRUE);
