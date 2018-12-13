# hibernate
A simple but complete hibernate example

# Setup:

First of all create a new Schema in your MySql database

Mine was: hschema

Tables created:

CREATE TABLE `contact` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PHONEBOOK_ID` int(11) DEFAULT NULL,
  `CREATION_DATE` datetime NOT NULL,
  `UPDATING_DATE` datetime NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `AGE` int(11) NOT NULL,
  `PHONE_NUMBER` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `phonebookfk_idx` (`PHONEBOOK_ID`),
  CONSTRAINT `phonebookfk` FOREIGN KEY (`PHONEBOOK_ID`) REFERENCES `phonebook` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `person` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(250) NOT NULL,
  `GENDER` char(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `person_project` (
  `person_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY (`person_id`,`project_id`),
  KEY `projectFK_idx` (`project_id`),
  CONSTRAINT `personFK` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  CONSTRAINT `projectFK` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `phonebook` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `id_UNIQUE` (`person_id`),
  CONSTRAINT `PHONEBOOK_FK` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `project` (
  `PROJECT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(45) NOT NULL,
  PRIMARY KEY (`PROJECT_ID`),
  UNIQUE KEY `PROJECT_ID_UNIQUE` (`PROJECT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#Relations

OneToMany

PhoneBook - Contact

OneToOne

Person - Phonebook

ManyToMany

Person - Project

I used the above examples in order to scramble a little bit the tables and create a more complex case study.
So the Person has a PhoneBook and that PhoneBook has many Contacts.

After importing the project Run the tests and check your database.

I also made the selects and deletes through hibernate using different methods so that you have an example how to use each.
Take a look at the methods in the test classes:

createQuery()
getCriteriaBuilder()
getSingleResult()
createCriteriaDelete()
createNativeQuery()
createNamedQuery()



