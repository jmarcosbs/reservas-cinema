INSERT INTO usuario (nome, email, senha) VALUES
('Milena', 'milena@gmail.com', '1234'),
('Pedro', 'pedro@gmail.com', '1234'),
('Padrão', 'padrao@gmail.com', '1234'),
('Comum', 'comum@gmail.com', '1234');

INSERT INTO filme (titulo, sinopse, valor_ingresso, horario) VALUES
('Divertidamente', 
'Riley é uma garota divertida de 11 anos de idade, que deve enfrentar mudanças importantes em sua vida quando seus pais decidem deixar a sua cidade natal, no estado de Minnesota, para viver em San Francisco.',
35.00, '15:30:00'),
('Bad Boys: Até o Fim', 
'Bad Boys: Até o Fim é o quarto filme da icônica saga de ação estrelada por Will Smith e Martin Lawrence, iniciada em 1995 com Os Bad Boys, dirigido por Michael Bay. Desta vez, o longa conta com Adil El Arbi e Bilall Fallah na direção e o roteiro fica por conta de Chris Bremnerirá. ',
35.00, '15:30:00'),
('Planeta dos Macacos: O Reinado', 
'Planeta dos Macacos: O Reinado dá continuidade à saga dos primatas inteligentes, situando-se em um futuro distante após os eventos de Guerra pelo Planeta dos Macacos de 2017.',
35.00, '15:30:00'),
('Assassino por Acaso', 
'Gary Johnson (Glen Powell) é o assassino profissional mais procurado de Nova Orleans. No entanto, nem tudo é o que parece: para os seus clientes, Gary passa como um assassino de aluguel comum, mas, na verdade, ele trabalha para a polícia.',
35.00, '15:30:00');

INSERT INTO assento (codigo_assento, FK_filme_id, ocupado) VALUES
('A1', 1, 0),('A2', 1, 0),('A3', 1, 0),('A4', 1, 0),
('B1', 1, 0),('B2', 1, 0),('B3', 1, 0),('B4', 1, 0),
('C1', 1, 0),('C2', 1, 0),('C3', 1, 0),('C4', 1, 0),
('D1', 1, 0),('D2', 1, 0),('D3', 1, 0),('D4', 1, 0),

('A1', 2, 0),('A2', 2, 0),('A3', 2, 0),('A4', 2, 0),
('B1', 2, 0),('B2', 2, 0),('B3', 2, 0),('B4', 2, 0),
('C1', 2, 0),('C2', 2, 0),('C3', 2, 0),('C4', 2, 0),
('D1', 2, 0),('D2', 2, 0),('D3', 2, 0),('D4', 2, 0),

('A1', 3, 0),('A2', 3, 0),('A3', 3, 0),('A4', 3, 0),
('B1', 3, 0),('B2', 3, 0),('B3', 3, 0),('B4', 3, 0),
('C1', 3, 0),('C2', 3, 0),('C3', 3, 0),('C4', 3, 0),
('D1', 3, 0),('D2', 3, 0),('D3', 3, 0),('D4', 3, 0),

('A1', 4, 0),('A2', 4, 0),('A3', 4, 0),('A4', 4, 0),
('B1', 4, 0),('B2', 4, 0),('B3', 4, 0),('B4', 4, 0),
('C1', 4, 0),('C2', 4, 0),('C3', 4, 0),('C4', 4, 0),
('D1', 4, 0),('D2', 4, 0),('D3', 4, 0),('D4', 4, 0);

INSERT INTO compra (valor_compra) VALUES
(70.00);

INSERT INTO ingresso (FK_usuario_id, FK_compra_id, FK_filme_id, fk_assento_id) VALUES
(1, 1, 1, 1),
(1, 1, 1, 2);

UPDATE assento SET ocupado = 1 WHERE id = 1;
UPDATE assento SET ocupado = 1 WHERE id = 2;
