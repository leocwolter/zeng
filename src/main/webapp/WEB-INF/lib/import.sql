INSERT INTO `User` VALUES (1,'leocwolter@gmail.com','Leonardo Wolter','9d466ffc486041f7fe59bb739a378a6b4aa6521e2c1d74d1dd71029d34a3b86b','profile.png');
INSERT INTO `User` (`email`, `name`, `password`, `photo`) VALUES ('enzo.toshiba@gmail.com', 'Enzo Toshio', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6', 'profile.png');
INSERT INTO `User` (`email`, `name`, `password`, `photo`) VALUES ('henrique.develops@gmail.com', 'Henrique Diniz', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6', 'profile.png');
INSERT INTO `User` (`email`, `name`, `password`, `photo`) VALUES ('gareis93@gmail.com', 'Gabriel Reis', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6', 'profile.png');
INSERT INTO `User` (`email`, `name`, `password`, `photo`) VALUES ('mtsh.poli@gmail.com', 'Mateus Poli', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6', 'profile.png');
INSERT INTO `Project` VALUES (1,'Zeng','zeng');
INSERT INTO `Project_User` VALUES (1,1), (1,2), (1,3), (1,4), (1,5);
INSERT INTO `Category` VALUES (1,'Back-end','back-end',1),(2,'Front-end','front-end',1);
INSERT INTO `TaskList` VALUES (1,'Bug',1),(2,'Features',1),(3,'Infra',1),(4,'HTML/CSS/JQUERY',2),(5,'Bug',2);
INSERT INTO `Task` VALUES (1,'\0',NULL,'','2012-11-20 00:00:00','Constraint violation para url de categoria em projetos diferentes',0,1),(2,'',NULL,'','2012-11-20 00:00:00','Constraint violation para url de categoria em projetos diferentes',0,1),(3,'',NULL,'','2012-11-20 00:00:00','nao da pra fazer nada na task depois que eu faÃ§o da primeira vez(se nao recarregar a pagina)',0,1),(4,'\0',NULL,'task description','2012-11-15 00:00:00','nao da pra fazer nada na task depois que eu faco da primeira vez(se nao recarregar a pagina)',0,1),(5,'\0',NULL,'task description','2012-11-20 00:00:00','Conseguir fazer edicoes em projetos, categorias, tasklists e tasks',0,2),(6,'\0',NULL,'task description','2012-11-22 00:00:00','Implementar multi-tenancy',0,3),(7,'\0',NULL,'','2012-11-19 00:00:00','Mostrar em que data ha muitas tarefas e que tarefas',0,2),(8,'\0',NULL,'','2012-11-27 00:00:00','Contador de tempo por tarefa/projeto',0,2),(9,'\0',NULL,'','2012-11-20 00:00:00','Passar pelo codigo e refatorar o que achar necessario',1,3),(10,'',NULL,'','2012-11-20 00:00:00','Passar pelo codigo e refatorar o que achar necessario',0,3),(11,'\0',NULL,'','2012-11-16 00:00:00','Implementar plugin para padronizacao de barra de rolagem minimalista',0,4),(12,'\0',NULL,'','2012-11-28 00:00:00','Montar funcao javascript para adicionar mais membros no projeto utilizando autocomplete',0,4),(13,'\0',NULL,'','2012-11-21 00:00:00','Menu responsivo',0,4),(14,'\0',NULL,'','2012-11-27 00:00:00','quando eu fecho lightbox de algum form e abro novamente ele abre mais de uma vez (quando eu dou submit em um form ele submita varias vezes)',0,5),(15,'\0',NULL,'','2012-11-21 00:00:00','quando eu adiciono uma tarefa sem expiracao, duas tarefas sao adicionadas',0,5);
INSERT INTO `Task_User` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1);
INSERT INTO `Action` VALUES (1,'2012-11-09 13:35:43','The Category \'Back-end\' was added to \'Zeng\'',1,1),(2,'2012-11-09 13:35:48','The Task List \'Bug\' was added to \'Back-end\'',1,1),(3,'2012-11-09 13:36:04','The Task \'Constraint violation para url de categoria em projetos diferentes\' was added to \'Bug\'',1,1),(4,'2012-11-09 13:36:04','The Task \'Constraint violation para url de categoria em projetos diferentes\' was added to \'Bug\'',1,1),(5,'2012-11-09 13:36:06','The Task \'Constraint violation para url de categoria em projetos diferentes\' was archived',1,1),(6,'2012-11-09 13:36:26','The Task \'nao da pra fazer nada na task depois que eu faÃ§o da primeira vez(se nao recarregar a pagina)\' was added to \'Bug\'',1,1),(7,'2012-11-09 13:36:29','The Task \'nao da pra fazer nada na task depois que eu faÃ§o da primeira vez(se nao recarregar a pagina)\' was archived',1,1),(8,'2012-11-09 13:36:42','The Task \'nao da pra fazer nada na task depois que eu faco da primeira vez(se nao recarregar a pagina)\' was added to \'Bug\'',1,1),(9,'2012-11-09 13:38:57','The Task List \'Features\' was added to \'Back-end\'',1,1),(10,'2012-11-09 13:39:15','The Task \'Conseguir fazer edicoes em projetos, categorias, tasklists e tasks\' was added to \'Features\'',1,1),(11,'2012-11-09 13:40:04','The Task \'Implementar multi-tenancy\' was added to \'Features\'',1,1),(12,'2012-11-09 13:40:38','The Task \'Mostrar em que data ha muitas tarefas e que tarefas\' was added to \'Features\'',1,1),(13,'2012-11-09 13:41:31','The Task \'Contador de tempo por tarefa/projeto\' was added to \'Features\'',1,1),(14,'2012-11-09 13:42:40','The Task List \'Infra\' was added to \'Back-end\'',1,1),(15,'2012-11-09 13:42:46','The Task \'Implementar multi-tenancy\' was moved to the TaskList \'Infra\'',1,1),(16,'2012-11-09 13:43:13','The Task \'Passar pelo codigo e refatorar o que achar necessario\' was added to \'Infra\'',1,1),(17,'2012-11-09 13:43:13','The Task \'Passar pelo codigo e refatorar o que achar necessario\' was added to \'Infra\'',1,1),(18,'2012-11-09 13:43:21','The Task \'Passar pelo codigo e refatorar o que achar necessario\' was archived',1,1),(19,'2012-11-09 13:44:16','The Task \'Passar pelo codigo e refatorar o que achar necessario\' was started',1,1),(20,'2012-11-09 13:44:31','The Category \'Front-end\' was added to \'Zeng\'',1,1),(21,'2012-11-09 13:45:02','The Task List \'HTML/CSS/JQUERY\' was added to \'Front-end\'',1,1),(22,'2012-11-09 13:45:39','The Task \'Implementar plugin para padronizacao de barra de rolagem minimalista\' was added to \'HTML/CSS/JQUERY\'',1,1),(23,'2012-11-09 13:46:28','The Task \'Montar funcao javascript para adicionar mais membros no projeto utilizando autocomplete\' was added to \'HTML/CSS/JQUERY\'',1,1),(24,'2012-11-09 13:48:02','The Task \'Menu responsivo\' was added to \'HTML/CSS/JQUERY\'',1,1),(25,'2012-11-09 13:48:40','The Task List \'Bug\' was added to \'Front-end\'',1,1),(26,'2012-11-09 13:49:08','The Task \'quando eu fecho lightbox de algum form e abro novamente ele abre mais de uma vez (quando eu dou submit em um form ele submita varias vezes)\' was added to \'Bug\'',1,1),(27,'2012-11-09 13:49:30','The Task \'quando eu adiciono uma tarefa sem expiracao, duas tarefas sao adicionadas\' was added to \'Bug\'',1,1);
--INSERT INTO `Project` (`name`, `url`) VALUES ('Zeng', 'zeng');
--
--INSERT INTO `Category` (`name`, `project_id`, `url`) VALUES ('Layout',1, 'layout'), ('Back-end',1, 'back-end'), ('Documentation',1, 'documentation');
--
--INSERT INTO `TaskList` (`name`, `category_id`) VALUES ('Logo',1), ('Wire-frame',1), ('Site',1);
--INSERT INTO `TaskList` (`name`, `category_id`) VALUES ('Database',2), ('Logic',2);
--INSERT INTO `TaskList` (`name`, `category_id`) VALUES ('SOX',3), ('Plano de Negocios',3), ('Slides',3);
--
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-30 00:00:00', 'Chamar para Parear', '1', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar model', '2', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-12-31 00:00:00', 'Implementar DAO Genérico', '2', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar drag and drop', '2', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-11 00:00:00', 'Deploy', '3', '1', 0); 
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-06-19 00:00:00', 'Implementar view', '3', '1', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-30 07:00:00', 'Chamar para Parear', '4', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar model', '4', '0', 0); 
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-12-31 00:00:00', 'Implementar DAO Genérico', '4', '0', 0); 
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar drag and drop', '4', '0', 0); 
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-11 00:00:00', 'Colher dados das tarefas', '5', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-06-19 00:00:00', 'Implementar view', '6', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-30 00:00:00', 'Chamar para Parear', '7', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar model', '5', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-12-31 00:00:00', 'Implementar DAO Genérico', '6', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar drag and drop', '6', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-11 00:00:00', 'Deixar bonito com css', '8', '2', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-06-19 00:00:00', 'Implementar view', '7', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-30 00:00:00', 'Chamar para Parear', '8', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar model', '8', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-12-31 00:00:00', 'Implementar DAO Genérico', '4', '0', 0);
--INSERT INTO `Task` ( `description`, `expirationDate`, `name`, `taskList_id`, `state`, `archived`) VALUES ('Descricao', '2012-04-28 00:00:00', 'Implementar drag and drop', '1', '0', 0);
--
--INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2001', 'Descricao', '2012-04-11 00:00:00', '2012-04-01 00:00:00', 'Implementar controller', '2', '2', 0);
--INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2002', 'Descricao', '2012-06-19 00:00:00', '2012-06-01 00:00:00', 'Implementar view', '4', '2', 0);
--INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2003', 'Descricao', '2012-04-30 07:00:00', '2012-04-01 07:00:00', 'Chamar para Parear', '3', '2', 0);
--INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2004', 'Descricao', '2012-04-28 15:00:00', '2012-04-01 15:00:00', 'Implementar model', '3', '2', 0); 
--INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2005', 'Descricao', '2012-12-31 00:00:00', '2012-08-01 00:00:00', 'Implementar DAO Genérico', '3', '2', 0); 
--INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2006', 'Descricao', '2012-04-28 10:30:00', '2012-04-01 00:00:00', 'Implementar drag and drop', '3', '2', 0);
--INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2007', 'Descricao', '2012-04-11 00:00:00', '2012-04-01 00:00:00', 'Implementar gráficos', '1', '2', 0);
--INSERT INTO `Task` (`id`, `description`, `expirationDate`, `dateOfCompletion`, `name`, `taskList_id`, `state`, `archived`) VALUES ('2008', 'Descricao', '2012-06-19 00:00:00', '2012-06-01 00:00:00', 'Implementar view', '4', '2', 0);
--
--INSERT INTO `User` (`email`, `name`, `password`, `photo`) VALUES ('leocwolter@gmail.com', 'Leonardo Wolter', '4df1319f3df602e7bbaa0173d46388744715cb89e38d2d7d529b00834f7148e6', 'ba5967c015bc3ef8d572286144beba028d20192b6b54a59eb06d7ed3155b2d12');
--
--INSERT INTO `Task_User` (`Task_id`, `contributors_id`) VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('2', '4'), ('2', '5'), ('4', '2'), ('4', '1'), ('5', '3'), ('5', '5'), ('6', '3');
--INSERT INTO `Task_User` (`Task_id`, `contributors_id`) VALUES  ('2001', '1'), ('2001', '2'), ('2002', '2'), ('2002', '3'), ('2003', '1'), ('2003', '2'), ('2003', '2'), ('2004', '3'), ('2004', '1'), ('2005', '2'), ('2006', '2'), ('2008', '3'), ('2008', '1'), ('2007', '2'), ('2006', '2');
--
--INSERT INTO `Project_User` (`Project_id`, `contributors_id`) VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('1', '4'), ('1', '5');
--
--INSERT INTO `Step` (`description`, `task_id`) VALUES ('passo 1 ', '1');
--INSERT INTO `Step` (`description`, `task_id`) VALUES ('passo 2 ', '1');
--INSERT INTO `Step` (`description`, `task_id`) VALUES ('passo 3 ', '1');