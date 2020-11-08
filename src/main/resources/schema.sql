CREATE TABLE course (
	id  bigserial NOT NULL,
	name varchar(255) NOT NULL UNIQUE,
	status varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE teacher (
	id  bigserial NOT NULL,
	name varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE TABLE student (
	id  bigserial NOT NULL,
	name varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE TABLE classroom (
	id  bigserial NOT NULL,
	status varchar(255) NOT NULL,
	course_id int8 NOT NULL,
	teacher_id int8 NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (course_id) REFERENCES course,
	FOREIGN KEY (teacher_id) REFERENCES teacher,
	CONSTRAINT UNIQUE_CLASSROOM UNIQUE (course_id, teacher_id)
);

CREATE TABLE students_classrooms (
	classroom_id int8 NOT NULL,
	student_id int8 NOT NULL,
	PRIMARY KEY (classroom_id, student_id),
	FOREIGN KEY (student_id) REFERENCES student,
	FOREIGN KEY (classroom_id) REFERENCES classroom
);
