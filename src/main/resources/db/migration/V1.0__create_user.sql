CREATE TABLE users(
                      id INTEGER PRIMARY KEY AUTO_INCREMENT,
                      email VARCHAR(150) UNIQUE,
                      name VARCHAR(100),
                      password VARCHAR(350),
                      isParticipant BOOLEAN DEFAULT FALSE,
                      isJudge BOOLEAN DEFAULT FALSE,
                      role VARCHAR(10) DEFAULT "DEFAULT",
                      cpf VARCHAR(11),
                      image BLOB DEFAULT NULL
);