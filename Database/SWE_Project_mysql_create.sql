CREATE TABLE `Accounts` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`password` varchar(100) NOT NULL,
	`email` varchar(150) NOT NULL UNIQUE,
	`phone` varchar(13) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `AnswerMessages` (
	`id` int NOT NULL AUTO_INCREMENT,
	`senderID` int NOT NULL,
	`receiverID` int NOT NULL,
	`formID` int NOT NULL,
	`postID` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Items` (
	`id` int NOT NULL AUTO_INCREMENT,
	`category` varchar(50) NOT NULL,
	`type` varchar(50) NOT NULL,
	`brand` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `ContactMessages` (
	`id` int NOT NULL AUTO_INCREMENT,
	`senderID` int NOT NULL,
	`receiverID` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Posts` (
	`id` int NOT NULL AUTO_INCREMENT,
	`desc` varchar(300) NOT NULL,
	`dateAndTime` DATETIME NOT NULL,
	`itemID` int NOT NULL,
	`creatorID` int NOT NULL,
	`creatorFormID` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Forms` (
	`id` int NOT NULL AUTO_INCREMENT,
	`formWriterID` int NOT NULL,
	`postSubmittedIn` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `QuestionAndAnswers` (
	`id` int NOT NULL AUTO_INCREMENT,
	`question` varchar(150) NOT NULL,
	`answer` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Options` (
	`id` int NOT NULL AUTO_INCREMENT,
	`option` varchar(100) NOT NULL,
	`questionID` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `QuestionsForItems` (
	`questionID` int NOT NULL,
	`itemID` int NOT NULL
);

CREATE TABLE `QuestionsForForms` (
	`questionID` int NOT NULL,
	`formID` int NOT NULL
);

ALTER TABLE `AnswerMessages` ADD CONSTRAINT `AnswerMessages_fk0` FOREIGN KEY (`senderID`) REFERENCES `Accounts`(`id`);

ALTER TABLE `AnswerMessages` ADD CONSTRAINT `AnswerMessages_fk1` FOREIGN KEY (`receiverID`) REFERENCES `Accounts`(`id`);

ALTER TABLE `AnswerMessages` ADD CONSTRAINT `AnswerMessages_fk2` FOREIGN KEY (`formID`) REFERENCES `Forms`(`id`);

ALTER TABLE `AnswerMessages` ADD CONSTRAINT `AnswerMessages_fk3` FOREIGN KEY (`postID`) REFERENCES `Posts`(`id`);

ALTER TABLE `ContactMessages` ADD CONSTRAINT `ContactMessages_fk0` FOREIGN KEY (`senderID`) REFERENCES `Accounts`(`id`);

ALTER TABLE `ContactMessages` ADD CONSTRAINT `ContactMessages_fk1` FOREIGN KEY (`receiverID`) REFERENCES `Accounts`(`id`);

ALTER TABLE `Posts` ADD CONSTRAINT `Posts_fk0` FOREIGN KEY (`itemID`) REFERENCES `Items`(`id`);

ALTER TABLE `Posts` ADD CONSTRAINT `Posts_fk1` FOREIGN KEY (`creatorID`) REFERENCES `Accounts`(`id`);

ALTER TABLE `Posts` ADD CONSTRAINT `Posts_fk2` FOREIGN KEY (`creatorFormID`) REFERENCES `Forms`(`id`);

ALTER TABLE `Forms` ADD CONSTRAINT `Forms_fk0` FOREIGN KEY (`formWriterID`) REFERENCES `Accounts`(`id`);

ALTER TABLE `Forms` ADD CONSTRAINT `Forms_fk1` FOREIGN KEY (`postSubmittedIn`) REFERENCES `Posts`(`id`);

ALTER TABLE `Options` ADD CONSTRAINT `Options_fk0` FOREIGN KEY (`questionID`) REFERENCES `QuestionAndAnswers`(`id`);

ALTER TABLE `QuestionsForItems` ADD CONSTRAINT `QuestionsForItems_fk0` FOREIGN KEY (`questionID`) REFERENCES `QuestionAndAnswers`(`id`);

ALTER TABLE `QuestionsForItems` ADD CONSTRAINT `QuestionsForItems_fk1` FOREIGN KEY (`itemID`) REFERENCES `Items`(`id`);

ALTER TABLE `QuestionsForForms` ADD CONSTRAINT `QuestionsForForms_fk0` FOREIGN KEY (`questionID`) REFERENCES `QuestionAndAnswers`(`id`);

ALTER TABLE `QuestionsForForms` ADD CONSTRAINT `QuestionsForForms_fk1` FOREIGN KEY (`formID`) REFERENCES `Forms`(`id`);

