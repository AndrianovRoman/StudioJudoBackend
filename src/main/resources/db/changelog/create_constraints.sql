ALTER TABLE bookings
ADD CONSTRAINT client_id_fk FOREIGN KEY (client_id)
REFERENCES clients(id);

ALTER TABLE bookings
ADD CONSTRAINT session_id_fk FOREIGN KEY (session_id)
REFERENCES sessions(id);

ALTER TABLE sessions
ADD CONSTRAINT trainer_id_fk FOREIGN KEY (trainer_id)
REFERENCES trainers(id);

ALTER TABLE trainers
ADD CONSTRAINT qualification_id_fk FOREIGN KEY (qualification_id)
REFERENCES qualifications(id);