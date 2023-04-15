CREATE TABLE users
(
    id            INTEGER PRIMARY KEY AUTO_INCREMENT,
    email         VARCHAR(150) UNIQUE,
    name          VARCHAR(100),
    password      VARCHAR(350),
    isParticipant BOOLEAN     DEFAULT FALSE,
    isJudge       BOOLEAN     DEFAULT FALSE,
    role          VARCHAR(10) DEFAULT "DEFAULT",
    cpf           VARCHAR(11),
    image         BLOB        DEFAULT NULL
);

CREATE TABLE projects
(
    id          INT          NOT NULL AUTO_INCREMENT,
    title       VARCHAR(150) NOT NULL,
    description VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE project_user
(
    project_id INT NOT NULL,
    user_id    INT NOT NULL,
    PRIMARY KEY (project_id, user_id FOREIGN KEY (project_id) REFERENCES projects(id),
                 FOREIGN KEY (user_id) REFERENCES users(id)
        );