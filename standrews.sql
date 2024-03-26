CREATE DATABASE standrews;
SHOW DATABASES;
USE standrews;

CREATE TABLE Student (StudentID VARCHAR(100) PRIMARY KEY, FirstName VARCHAR(25) NOT NULL, LastName VARCHAR(25) NOT NULL, 
DateOfBirth DateTime NOT NULL, Gender VARCHAR(25) NOT NULL, Email VARCHAR(30) UNIQUE NOT NULL, Phone VARCHAR(25) NOT NULL);

SELECT * FROM Student;

DESC Student;

INSERT INTO Student VALUES(DEFAULT, 'Neeraj', 'Sharma', NOW(), 'male', 'neerajkumarsharma345@gmail.com', '8603771370');

UPDATE Student SET DateOfBirth=STR_TO_DATE('09/09/2003', '%m/%d/%Y') WHERE StudentID=1001;

ALTER TABLE Student MODIFY COLUMN StudentID INT AUTO_INCREMENT;

DELETE FROM Student WHERE StudentID=1002;


CREATE TABLE employee (fullname VARCHAR(100), salary INT);

INSERT INTO employee VALUES
(NULL, 30000),
(NULL, 25000);

SELECT * FROM employee;

SELECT COUNT(*) FROM employee WHERE salary > 25000;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM employee WHERE fullname IS NULL;
SET SQL_SAFE_UPDATES = 1;


CREATE TABLE Student ( StudentID VARCHAR(10) PRIMARY KEY, FirstName VARCHAR(25) NOT NULL, LastName VARCHAR(25) NOT NULL, DateOfBirth DateTime NOT NULL, Gender VARCHAR(25) NOT NULL, Email VARCHAR(30) UNIQUE NOT NULL, Phone VARCHAR(25) NOT NULL );

INSERT INTO Student (StudentID, FirstName,LastName, DateOfBirth, Gender,  Email,Phone) VALUES 
('S101','John', 'Doe','2000-10-10','M', 'john@example.com','9878457945'), 
('S102','Jane', 'Smith','2013-08-08','M', 'jane@example.com','9977457745'),
('S103','Alice', 'Johnson','2011-09-08','F', 'alice@example.com','9876457845'), 
('S104','Jim', 'Doe','2011-07-08','F', 'jim.doe@india.com','9876457845'), 
('S105','Peter', 'Parker','2011-06-05','F', 'p_parker@example.com','9876457845') ;

SELECT * FROM Student ;

CREATE TABLE Instructor ( InstructorID VARCHAR(10) PRIMARY KEY, Email VARCHAR(30) UNIQUE NOT NULL, FirstName VARCHAR(30) NOT NULL, LastName VARCHAR(30) );
desc Instructor;  
INSERT INTO Instructor (InstructorID ,Email,FirstName,LastName) VALUES 
('I101','sunil@example.com','Sunil','Rawat'),
 ('I102','nida@example.com','Nida','Fatima'), 
('I103','shiv@example.com','Shiv','Kumar'); 

select * from Instructor; 

CREATE TABLE Course ( CourseID VARCHAR(10) PRIMARY KEY, CourseTitle VARCHAR(30) NOT NULL, Credits INT NOT NULL ); 
desc Course; 
INSERT INTO Course (CourseID,CourseTitle,Credits) VALUES 
('C101','Math101',12), 
('C102','History101',13), 
('C103','Computer Science101',11); 
select * from Course;

CREATE TABLE Enrollment ( EnrollmentID VARCHAR(10) PRIMARY KEY, 
StudentID VARCHAR(10) NOT NULL, 
CourseID VARCHAR(10) NOT NULL, 
InstructorID VARCHAR(10) NOT NULL, 
FOREIGN KEY (StudentID) REFERENCES Student(StudentID), 
FOREIGN KEY (CourseID) REFERENCES Course(CourseID), 
FOREIGN KEY (InstructorID) REFERENCES Instructor(InstructorID) ); 
desc Enrollment; 

INSERT INTO Enrollment (EnrollmentID,StudentID, CourseID,InstructorID) VALUES 
('E1001','S101','C101','I101'), 
('E1002','S102','C101', 'I101'), 
('E1003','S103','C102','I102');
select * from Enrollment;



