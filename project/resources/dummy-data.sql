USE quizzy;
-- Insert dummy data
INSERT INTO tbl_user (id, username, full_name, password_hash) VALUES (DEFAULT, 'user1', 'user name', 'password1'), (DEFAULT, 'user2', 'user2 name', 'password2');

INSERT INTO tbl_form (id, user_id, form_name) VALUES (DEFAULT, 1, 'Form 1'), (DEFAULT, 1, 'Form 2');

INSERT INTO tbl_question (id, text, form_id) VALUES (DEFAULT, 'Question 1', 1), (DEFAULT, 'Question 2', 1), (DEFAULT, 'Question 3', 2);

INSERT INTO tbl_option (id, text, is_answer, question_id) VALUES (DEFAULT, 'Option 1', true, 1), (DEFAULT, 'Option 2', false, 1), (DEFAULT, 'Option 3', false, 2), (DEFAULT, 'Option 4', true, 2), (DEFAULT, 'Option 5', false, 3), (DEFAULT, 'Option 6', true, 3);

INSERT INTO tbl_attempt (id, user_id, attempted_option_id, form_id) VALUES (DEFAULT, 1, 1, 1), (DEFAULT, 1, 4, 1), (DEFAULT, 2, 3, 2);

INSERT INTO tbl_score (id, user_id, form_id, score) VALUES (DEFAULT, 1, 1, 80), (DEFAULT, 1, 2, 90), (DEFAULT, 2, 2, 75);
