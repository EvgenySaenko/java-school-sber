

drop table if exists recipes cascade;
create table recipes (
                         id                 bigserial primary key,
                         title              varchar(255),
                         description        TEXT
);

insert into recipes
(title, description) values
('Клубничный пирог',
 'Главный секрет идеальных сырников — а точнее творожников, — творог нужно протереть через мелкое сито и отжать от влаги.' ||
 ' Жирность предпочтительна не больше и не меньше 9%. Тесто должно получиться эластичным, ' ||
 'чтобы при надавливании сырник не треснул на сковородке, а сохранил форму. Если все сделать правильно,' ||
 ' получатся нежные однородные кругляшки под плотной румяной корочкой. Сырники можно запекать в духовке или готовить на пару.' ||
 ' В рецепте не исключаются эксперименты с начинкой — сухофрукты, орехи, свежие фрукты и даже картофель лишними не будут.');
;


drop table if exists ingredients cascade;
create table ingredients (
                             id                 bigserial primary key,
                             title              varchar(255),
                             quantity           bigint,
                             recipe_id          bigint,
                             constraint fk_recipe_id foreign key (recipe_id) references recipes (id)
);


insert into ingredients
(title, quantity, recipe_id) values
('Молоко', 125, 1),
('Масло сливочное', 150, 1),
('Сахар', 150, 1),
('Яйца куриные', 3, 1),
('Клубника', 200, 1),
('Мука', 250, 1),
('Ванилин', 1, 1),
('Разрыхлитель', 1, 1);

