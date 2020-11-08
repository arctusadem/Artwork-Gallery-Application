DROP TABLE IF EXISTS TB_CUSTOMER;

CREATE TABLE TB_CUSTOMER (
  id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(150) NOT NULL,
  doc_type VARCHAR(30) NOT NULL,
  doc_number VARCHAR(30) NOT NULL,
  CONSTRAINT AK_docID UNIQUE(doc_type, doc_number)
);

INSERT INTO TB_CUSTOMER (first_name, last_name, doc_type, doc_number) VALUES
  ('João', 'Carvalho', 'CPF', '025.719.958-63'),
  ('Thiago', 'Borges', 'CPF', '185.323.128-29'),
  ('Arnaldo', 'Mendonça', 'CPF', '715.174.388-29'),
  ('Cristina', 'Freitas', 'CPF', '236.837.328-49'),
  ('Fernando', 'Moura', 'RG', '28.226.173-4'),
  ('Everson', 'Santos', 'RG', '33.044.586-8'),
  ('Sabrina', 'Machado', 'CPF', '095.494.898-09');