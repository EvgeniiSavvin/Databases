CREATE TABLE Universities
(
    id                       BIGSERIAL PRIMARY KEY,
    name                     VARCHAR(150) NOT NULL,
    new_educational_standard BOOLEAN      NOT NULL
);

CREATE TABLE Departments
(
    id            BIGSERIAL PRIMARY KEY,
    university_id BIGINT       NOT NULL REFERENCES Universities (id),
    name          VARCHAR(100) NOT NULL,
    UNIQUE (university_id, name)
);

CREATE TABLE Grades
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(50)
);

INSERT INTO Grades (name)
VALUES ('Бакалавр'),
       ('Магистр'),
       ('Специалист');

CREATE TABLE Specializations
(
    id            BIGSERIAL PRIMARY KEY,
    code          VARCHAR(10)  NOT NULL,
    name          VARCHAR(100) NOT NULL,
    grade         BIGINT REFERENCES Grades (id),
    department_id BIGINT REFERENCES Departments (id),
    full_time     BOOLEAN      NOT NULL,
    UNIQUE (department_id, code, name, full_time)
);

CREATE TABLE Final_test_types
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(50)
);

INSERT INTO Final_test_types (name)
VALUES ('Экзамен'),
       ('Зачет'),
       ('Дифференцированный зачет');


CREATE TABLE Disciplines
(
    id                 BIGSERIAL PRIMARY KEY,
    code               VARCHAR(100) NOT NULL,
    name               VARCHAR(100) NOT NULL,
    specialization_id  BIGINT       NOT NULL REFERENCES Specializations (id),
    semester_number    INT          NOT NULL,
    lecture_hours      INT          NOT NULL,
    practice_hours     INT          NOT NULL,
    lab_works_hours    INT          NOT NULL,
    final_test_type_id BIGINT          NOT NULL REFERENCES Final_test_types (id),
    UNIQUE (specialization_id, code, name, semester_number)
);

CREATE TABLE Students
(
    id                BIGSERIAL PRIMARY KEY,
    first_name        VARCHAR(50) NOT NULL,
    middle_name       VARCHAR(50),
    last_name         VARCHAR(50),
    specialization_id BIGINT REFERENCES Specializations (id)
);

CREATE TABLE Teachers
(
    id          BIGSERIAL PRIMARY KEY,
    first_name  VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    last_name   VARCHAR(50)
);

CREATE TABLE Performance_registry
(
    id            BIGSERIAL PRIMARY KEY,
    student_id    BIGINT    NOT NULL REFERENCES Students (id),
    teacher_id    BIGINT    NOT NULL REFERENCES Teachers (id),
    discipline_id BIGINT    NOT NULL REFERENCES Disciplines (id),
    points        Int       NOT NULL,
    date          TIMESTAMP NOT NULL
)
