CREATE TABLE users
(
    id            INTEGER PRIMARY KEY AUTO_INCREMENT,
    email         VARCHAR(150) UNIQUE,
    name          VARCHAR(100),
    password      VARCHAR(350),
    is_participant BOOLEAN     DEFAULT FALSE,
    is_judge       BOOLEAN     DEFAULT FALSE,
    role          VARCHAR(10) DEFAULT "DEFAULT",
    cpf           VARCHAR(11),
    image         BLOB        DEFAULT NULL
);

CREATE TABLE projects
(
    id          INTEGER          NOT NULL AUTO_INCREMENT,
    title       VARCHAR(150) NOT NULL,
    description VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE projects_members
(
    project_id INTEGER NOT NULL,
    user_id    INTEGER NOT NULL,
    PRIMARY KEY (project_id, user_id),
    FOREIGN KEY (project_id) REFERENCES projects(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);