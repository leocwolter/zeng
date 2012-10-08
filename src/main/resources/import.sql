INSERT INTO `Project` (`name`, `url`) VALUES ('Zeng', 'zeng');

INSERT INTO `Category` (`name`, `project_id`) VALUES ('Layout',1), ('Back-end',1), ('Documentation',1);

INSERT INTO `TaskList` (`name`, `category_id`) VALUES ('Logo',1), ('Wire-frame',1), ('Site',1);
INSERT INTO `TaskList` (`name`, `category_id`) VALUES ('Database',2), ('Logic',2);
INSERT INTO `TaskList` (`name`, `category_id`) VALUES ('SOX',3), ('Plano de Negocios',3), ('Slides',3);

INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Fazer alguma coisa!', '2012-04-30 07:00:00', 'Tarefa Marota', '1', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Fazer marotagem!', '2012-04-28 15:00:00', 'Marotona', '2', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Alooo', '2012-12-31 00:00:00', 'Porra do tcc', '2', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Sem inspiração', '2012-04-28 10:30:00', 'Malandraaageeem', '2', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Akaka', '2012-04-11 00:00:00', 'unicelular', '3', '1', 0); 
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('lalalala', '2012-06-19 00:00:00', 'Alo galera de cowboy', '3', '1', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Loloololo!', '2012-04-30 07:00:00', 'Tarefa Marota', '4', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Fazer shrubles!', '2012-04-28 15:00:00', 'Marotona', '4', '0', 0); 
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Agua mole', '2012-12-31 00:00:00', 'Porra do tcc', '4', '0', 0); 
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Sem expiração', '2012-04-28 10:30:00', 'Malandraaageeem', '4', '0', 0); 
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Akaka', '2012-04-11 00:00:00', 'citoplasma', '5', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('lalalala', '2012-06-19 00:00:00', 'Alo galera de cowboy', '6', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Lalalalla!', '2012-04-30 07:00:00', 'Tarefa Marota', '7', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Fazer rubedubles!', '2012-04-28 15:00:00', 'Marotona', '5', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Pedra dura', '2012-12-31 00:00:00', 'Porra do tcc', '6', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Sem ins', '2012-04-28 10:30:00', 'Malandraaageeem', '6', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Akaka', '2012-04-11 00:00:00', 'nucleo', '8', '2', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('lalalala', '2012-06-19 00:00:00', 'Alo galera de cowboy', '7', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Lelelelelel!', '2012-04-30 07:00:00', 'Tarefa Marota', '8', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Fazer imaginacao funcionar!', '2012-04-28 15:00:00', 'Marotona', '8', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Dois Coelhos', '2012-12-31 00:00:00', 'Porra do tcc', '4', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Sem piração', '2012-04-28 10:30:00', 'Malandraaageeem', '1', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Akaka', '2012-04-11 00:00:00', 'eucarioticas', '2', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('lalalala', '2012-06-19 00:00:00', 'Alo galera de cowboy', '4', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('lulululu!', '2012-04-30 07:00:00', 'Tarefa Marota', '3', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Fazer rio!', '2012-04-28 15:00:00', 'Marotona', '3', '0', 0); 
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Uma Cajadada', '2012-12-31 00:00:00', 'Porra do tcc', '3', '0', 0); 
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Sem cão', '2012-04-28 10:30:00', 'Malandraaageeem', '3', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Akaka', '2012-04-11 00:00:00', 'procarioticas', '1', '0', 0);
INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('lalalala', '2012-06-19 00:00:00', 'Alo galera de cowboy', '4', '2', 0);

INSERT INTO `User` (`email`, `name`, `password`) VALUES ('leocwolter@gmail.com', 'Leonardo Wolter', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6'), ('enzo.toshiba@gmail.com', 'Enzo Toshio', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6'), ('henrique.develops@gmail.com', 'Henrique Diniz', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6'), ('gareis93@gmail.com', 'Gabriel Reis', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6'), ('mtsh.poli@gmail.com', 'Mateus Poli', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6');

INSERT INTO `Task_User` (`Task_id`, `contributors_id`) VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('2', '4'), ('2', '5'), ('4', '2'), ('4', '1'), ('5', '3'), ('5', '5'), ('6', '3');

INSERT INTO `Project_User` (`Project_id`, `contributors_id`) VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('1', '4'), ('1', '5');

INSERT INTO `Step` (`description`, `task_id`) VALUES ('passo 1 ', '1');
INSERT INTO `Step` (`description`, `task_id`) VALUES ('passo 2 ', '1');
INSERT INTO `Step` (`description`, `task_id`) VALUES ('passo 3 ', '1');