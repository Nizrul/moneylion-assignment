INSERT INTO "users" ("username", "email", "password", "roles", "created_date", "updated_date") VALUES 
	('admin', 'admin@email.com', '$2y$12$RxNDZ7wmrtjf4nW1oCkFDu.rqURfUxRH4Z2cPGSJ/NdTzU.u/K9La', 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	('user', 'user@email.com', '$2y$13$byOhJi0X4ITfil54Y7SA8Oehm9wBHVn3rON5x.gc3W5rbnZedGM8e', 'user', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);