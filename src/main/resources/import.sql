INSERT INTO `Project` (`name`, `url`) VALUES ('Zeng', 'zeng');

INSERT INTO `Category` (`name`, `project_id`) VALUES ('Layout',1), ('Back-end',1), ('Documentation',1);

INSERT INTO `TaskList` (`name`, `category_id`) VALUES ('Logo',1), ('Wire-frame',1), ('Site',1);
INSERT INTO `TaskList` (`name`, `category_id`) VALUES ('Database',2), ('Logic',2);
INSERT INTO `TaskList` (`name`, `category_id`) VALUES ('SOX',3), ('Plano de Negocios',3), ('Slides',3);

INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-30 00:00:00', 'Chamar para Parear', '1', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar model', '2', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-12-31 00:00:00', 'Implementar DAO Genérico', '2', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar drag and drop', '2', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-11 00:00:00', 'Deploy', '3', '1', 0); 
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-06-19 00:00:00', 'Implementar view', '3', '1', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-30 07:00:00', 'Chamar para Parear', '4', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar model', '4', '0', 0); 
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-12-31 00:00:00', 'Implementar DAO Genérico', '4', '0', 0); 
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar drag and drop', '4', '0', 0); 
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-11 00:00:00', 'Colher dados das tarefas', '5', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-06-19 00:00:00', 'Implementar view', '6', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-30 00:00:00', 'Chamar para Parear', '7', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar model', '5', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-12-31 00:00:00', 'Implementar DAO Genérico', '6', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar drag and drop', '6', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-11 00:00:00', 'Deixar bonito com css', '8', '2', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-06-19 00:00:00', 'Implementar view', '7', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-30 00:00:00', 'Chamar para Parear', '8', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar model', '8', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-12-31 00:00:00', 'Implementar DAO Genérico', '4', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar drag and drop', '1', '0', 0);

INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2001', 'Descricao', '2012-04-11 00:00:00', '2012-04-01 00:00:00', 'Implementar controller', '2', '2', 0);
INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2002', 'Descricao', '2012-06-19 00:00:00', '2012-06-01 00:00:00', 'Implementar view', '4', '2', 0);
INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2003', 'Descricao', '2012-04-30 07:00:00', '2012-04-01 07:00:00', 'Chamar para Parear', '3', '2', 0);
INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2004', 'Descricao', '2012-04-28 15:00:00', '2012-04-01 15:00:00', 'Implementar model', '3', '2', 0); 
INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2005', 'Descricao', '2012-12-31 00:00:00', '2012-08-01 00:00:00', 'Implementar DAO Genérico', '3', '2', 0); 
INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2006', 'Descricao', '2012-04-28 10:30:00', '2012-04-01 00:00:00', 'Implementar drag and drop', '3', '2', 0);
INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2007', 'Descricao', '2012-04-11 00:00:00', '2012-04-01 00:00:00', 'Implementar gráficos', '1', '2', 0);
INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2008', 'Descricao', '2012-06-19 00:00:00', '2012-06-01 00:00:00', 'Implementar view', '4', '2', 0);

INSERT INTO `User` (`email`, `name`, `password`, `photo`, `cpf`) VALUES ('leocwolter@gmail.com', 'Leonardo Wolter', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6', 'profile.png', '234.234.234-21');
INSERT INTO `User` (`email`, `name`, `password`, `photo`, `cpf`) VALUES ('enzo.toshiba@gmail.com', 'Enzo Toshio', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6', 'profile.png', '234.234.234-22');
INSERT INTO `User` (`email`, `name`, `password`, `photo`, `cpf`) VALUES ('henrique.develops@gmail.com', 'Henrique Diniz', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6', 'profile.png', '234.234.234-23');
INSERT INTO `User` (`email`, `name`, `password`, `photo`, `cpf`) VALUES ('gareis93@gmail.com', 'Gabriel Reis', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6', 'profile.png', '234.234.234-24');
INSERT INTO `User` (`email`, `name`, `password`, `photo`, `cpf`) VALUES ('mtsh.poli@gmail.com', 'Mateus Poli', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6', 'profile.png', '234.234.234-25');

INSERT INTO `Task_User` (`Task_id`, `contributors_id`) VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('2', '4'), ('2', '5'), ('4', '2'), ('4', '1'), ('5', '3'), ('5', '5'), ('6', '3');
INSERT INTO `Task_User` (`Task_id`, `contributors_id`) VALUES  ('2001', '1'), ('2001', '2'), ('2002', '2'), ('2002', '3'), ('2003', '1'), ('2003', '2'), ('2003', '2'), ('2004', '3'), ('2004', '1'), ('2005', '2'), ('2006', '2'), ('2008', '3'), ('2008', '1'), ('2007', '2'), ('2006', '2');

INSERT INTO `Project_User` (`Project_id`, `contributors_id`) VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('1', '4'), ('1', '5');

INSERT INTO `Step` (`description`, `task_id`) VALUES ('passo 1 ', '1');
INSERT INTO `Step` (`description`, `task_id`) VALUES ('passo 2 ', '1');
INSERT INTO `Step` (`description`, `task_id`) VALUES ('passo 3 ', '1');