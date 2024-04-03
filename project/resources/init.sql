-- Create database
CREATE DATABASE IF NOT EXISTS quizzy;

-- Use the database
USE quizzy;

-- Create tbl_user table
CREATE TABLE IF NOT EXISTS tbl_user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY idx_username (username)
);

-- Create tbl_quiz table
CREATE TABLE IF NOT EXISTS tbl_quiz (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quiz_name VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY idx_user_id_quiz_name (user_id, quiz_name),
    FOREIGN KEY (user_id) REFERENCES tbl_user(id) ON DELETE CASCADE
);

-- Create tbl_question table
CREATE TABLE IF NOT EXISTS tbl_question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_text TEXT NOT NULL,
    quiz_id INT NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (quiz_id) REFERENCES tbl_quiz(id) ON DELETE CASCADE,
    INDEX idx_quiz_id (quiz_id)
);

-- Create tbl_option table
CREATE TABLE IF NOT EXISTS tbl_option (
    id INT AUTO_INCREMENT PRIMARY KEY,
    option_text TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL,
    question_id INT NOT NULL,
    FOREIGN KEY (question_id) REFERENCES tbl_question(id) ON DELETE CASCADE,
    INDEX idx_question_id (question_id)
);

-- Create tbl_attempt table
CREATE TABLE IF NOT EXISTS tbl_attempt (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    attempted_option_id INT NOT NULL,
    quiz_id INT NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES tbl_user(id) ON DELETE CASCADE,
    FOREIGN KEY (attempted_option_id) REFERENCES tbl_option(id) ON DELETE CASCADE,
    FOREIGN KEY (quiz_id) REFERENCES tbl_quiz(id) ON DELETE CASCADE,
    UNIQUE KEY idx_user_quiz_attempted_option (user_id, quiz_id, attempted_option_id)
);

-- Create tbl_score table
CREATE TABLE IF NOT EXISTS tbl_score (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    quiz_id INT NOT NULL,
    score INT NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES tbl_user(id) ON DELETE CASCADE,
    FOREIGN KEY (quiz_id) REFERENCES tbl_quiz(id) ON DELETE CASCADE,
    INDEX idx_user_id (user_id),
    INDEX idx_quiz_id (quiz_id)
);
