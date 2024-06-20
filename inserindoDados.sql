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

INSERT INTO assento (id, FK_filmes_id) VALUES
('A1', 1),('A2', 1),('A3', 1),('A4', 1),
('B1', 1),('B2', 1),('B3', 1),('B4', 1),
('C1', 1),('C2', 1),('C3', 1),('C4', 1),
('D1', 1),('D2', 1),('D3', 1),('D4', 1),

('A1', 2),('A2', 2),('A3', 2),('A4', 2),
('B1', 2),('B2', 2),('B3', 2),('B4', 2),
('C1', 2),('C2', 2),('C3', 2),('C4', 2),
('D1', 2),('D2', 2),('D3', 2),('D4', 2),

('A1', 3),('A2', 3),('A3', 3),('A4', 3),
('B1', 3),('B2', 3),('B3', 3),('B4', 3),
('C1', 3),('C2', 3),('C3', 3),('C4', 3),
('D1', 3),('D2', 3),('D3', 3),('D4', 3),

('A1', 4),('A2', 4),('A3', 4),('A4', 4),
('B1', 4),('B2', 4),('B3', 4),('B4', 4),
('C1', 4),('C2', 4),('C3', 4),('C4', 4),
('D1', 4),('D2', 4),('D3', 4),('D4', 4)
