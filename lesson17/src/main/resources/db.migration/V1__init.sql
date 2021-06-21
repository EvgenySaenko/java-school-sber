drop table if exists urls;
create table urls (
   id                    bigserial primary key,
   title                 VARCHAR(30) not null UNIQUE,
   link                  VARCHAR(30) not null UNIQUE,
);

insert into urls (title, link)
values
('Рингтон Ershov & Kagramanov - Заплетай','http://namobilu.com/download/ringtones/mps/216208'),
('Рингтон Cut Off - All I Want','http://namobilu.com/download/ringtones/mps/220402'),
('Рингтон Мари Краймбрери & Alex Davia - If You Love Me','http://namobilu.com/download/ringtones/mps/216929'),
('Рингтон BROHM - In The End','http://namobilu.com/download/ringtones/mps/216349'),
('Рингтон relaiXX - Farah','http://namobilu.com/download/ringtones/mps/217762'),
('Рингтон Tiesto - The Business (JONVS Remix)','http://namobilu.com/download/ringtones/mps/216033');