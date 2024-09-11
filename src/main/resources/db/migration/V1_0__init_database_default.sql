
CREATE TABLE IF NOT EXISTS user_responsible (
    id bigint NOT NULL AUTO_INCREMENT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    name varchar(100) NULL,
    CONSTRAINT id_PK PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS sprint (
    id bigint NOT NULL AUTO_INCREMENT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    begin_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    end_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    title varchar(100) NULL,
    status varchar(40) NULL,
    CONSTRAINT id_PK PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS epic (
    id bigint NOT NULL AUTO_INCREMENT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    description varchar(100) NOT NULL,
    title varchar(100) NULL,
    status varchar(40) NULL,
    sprint bigint NULL,
    CONSTRAINT id_PK PRIMARY KEY (id),
    CONSTRAINT sprint_epic_FK FOREIGN KEY (sprint) REFERENCES sprint(id)
);
CREATE TABLE IF NOT EXISTS story (
    id bigint NOT NULL AUTO_INCREMENT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    description varchar(100) NOT NULL,
    title varchar(100) NULL,
    points bigint NULL,
    status varchar(40) NULL,
    epic bigint NOT NULL,
    responsible bigint NULL,
    CONSTRAINT id_PK PRIMARY KEY (id),
    CONSTRAINT user_story_FK FOREIGN KEY (responsible) REFERENCES user_responsible(id),
    CONSTRAINT epic_FK FOREIGN KEY (epic) REFERENCES epic(id)
);
CREATE TABLE IF NOT EXISTS task (
    id bigint NOT NULL AUTO_INCREMENT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    description varchar(100) NOT NULL,
    title varchar(100) NULL,
    points bigint NULL,
    status varchar(40) NULL,
    story bigint NOT NULL,
    responsible bigint NULL,
    CONSTRAINT id_PK PRIMARY KEY (id),
    CONSTRAINT user_task_FK FOREIGN KEY (responsible) REFERENCES user_responsible(id),
    CONSTRAINT story_task_FK FOREIGN KEY (story) REFERENCES story(id)
);



