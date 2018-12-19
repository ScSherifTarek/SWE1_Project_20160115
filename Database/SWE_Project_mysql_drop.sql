ALTER TABLE `AnswerMessages` DROP FOREIGN KEY `AnswerMessages_fk0`;

ALTER TABLE `AnswerMessages` DROP FOREIGN KEY `AnswerMessages_fk1`;

ALTER TABLE `AnswerMessages` DROP FOREIGN KEY `AnswerMessages_fk2`;

ALTER TABLE `AnswerMessages` DROP FOREIGN KEY `AnswerMessages_fk3`;

ALTER TABLE `ContactMessages` DROP FOREIGN KEY `ContactMessages_fk0`;

ALTER TABLE `ContactMessages` DROP FOREIGN KEY `ContactMessages_fk1`;

ALTER TABLE `Posts` DROP FOREIGN KEY `Posts_fk0`;

ALTER TABLE `Posts` DROP FOREIGN KEY `Posts_fk1`;

ALTER TABLE `Posts` DROP FOREIGN KEY `Posts_fk2`;

ALTER TABLE `FormsInPosts` DROP FOREIGN KEY `FormsInPosts_fk0`;

ALTER TABLE `FormsInPosts` DROP FOREIGN KEY `FormsInPosts_fk1`;

ALTER TABLE `Forms` DROP FOREIGN KEY `Forms_fk0`;

ALTER TABLE `Options` DROP FOREIGN KEY `Options_fk0`;

ALTER TABLE `QuestionsForItems` DROP FOREIGN KEY `QuestionsForItems_fk0`;

ALTER TABLE `QuestionsForItems` DROP FOREIGN KEY `QuestionsForItems_fk1`;

ALTER TABLE `QuestionsForForms` DROP FOREIGN KEY `QuestionsForForms_fk0`;

ALTER TABLE `QuestionsForForms` DROP FOREIGN KEY `QuestionsForForms_fk1`;

DROP TABLE IF EXISTS `Accounts`;

DROP TABLE IF EXISTS `AnswerMessages`;

DROP TABLE IF EXISTS `Items`;

DROP TABLE IF EXISTS `ContactMessages`;

DROP TABLE IF EXISTS `Posts`;

DROP TABLE IF EXISTS `FormsInPosts`;

DROP TABLE IF EXISTS `Forms`;

DROP TABLE IF EXISTS `QuestionAndAnswers`;

DROP TABLE IF EXISTS `Options`;

DROP TABLE IF EXISTS `QuestionsForItems`;

DROP TABLE IF EXISTS `QuestionsForForms`;

