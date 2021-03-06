-- INSERT
insert into language (name) values ("English");
insert into brand (name) values ("Nike");
insert into brand (name) values ("Adidas");
insert into product (name, id_brand, price) values ("Shoes Air Plus", 1, 150);
insert into product (name, id_brand, price) values ("Shoes Air Minus", 1, 100);
insert into product (name, id_brand, price) values ("Shoes Flow Extreme", 2, 140);
insert into product (name, id_brand, price) values ("Shoes Reef", 2, 200);
insert into country (name, priceMultiplier) values ("Argentina", 1.21);
insert into city (name, id_country) values ("Buenos Aires", 1);
insert into address (address, id_city) values ("Fake Street 123", 1); -- First user
insert into address (address, id_city) values ("Real Street 987", 1); -- Second user
insert into address (address, id_city) values ("Unkown Street 456", 1); -- Store
insert into address (address, id_city) values ("Eggplant 67", 1);
insert into user (username, pass, email, id_language, id_address) values ("user","pass","user@gmail.com", 1, 1);
insert into user (username, pass, email, id_language) values ("driver","pass","driver@gmail.com", 1);
insert into user (username, pass, email, id_language) values ("employee","pass","employee@gmail.com", 1);
insert into user (username, pass, email, id_language, id_address) values ("seconduser","pass","seconduser@gmail.com", 1, 2);
insert into store (name, id_address) values ("WearSport", 3);
insert into employee (name,id_store, id_user) values ("Clee Torres", 1, 3);
insert into driver (id_user, rating, free) values (2, 80, true);
insert into inventory (id_store, id_product, amount) values (1, 1, 30);
insert into inventory (id_store, id_product, amount) values (1, 2, 20);
insert into inventory (id_store, id_product, amount) values (1, 3, 40);
insert into inventory (id_store, id_product, amount) values (1, 4, 40);

insert into brand (name) values ("A");
insert into brand (name) values ("B");
insert into brand (name) values ("C");
insert into brand (name) values ("D");
insert into brand (name) values ("E");
insert into product (name, id_brand, price) values ("A A", 3);
insert into product (name, id_brand, price) values ("B B", 4);
insert into product (name, id_brand, price) values ("C C", 5);
insert into product (name, id_brand, price) values ("D D", 6);
insert into product (name, id_brand, price) values ("E E", 7);

-- UPDATE

update country set priceMultiplier = 1.6 where id = 1;
update inventory set amount = 19 where id_store = 1 and id_product = 2;
update inventory set amount = 29 where id_store = 1 and id_product = 1;
update inventory set amount = 28 where id_store = 1 and id_product = 1;
update inventory set amount = 27 where id_store = 1 and id_product = 1;
update inventory set amount = 26 where id_store = 1 and id_product = 1;
update inventory set amount = 25 where id_store = 1 and id_product = 1;
update inventory set amount = 24 where id_store = 1 and id_product = 1;
update inventory set amount = 23 where id_store = 1 and id_product = 1;
update inventory set amount = 22 where id_store = 1 and id_product = 1;
update inventory set amount = 21 where id_store = 1 and id_product = 1;

-- DELETE

delete from product where id = 5;
delete from product where id = 6;
delete from product where id = 7;
delete from product where id = 8;
delete from product where id = 9;
delete from brand where id = 3;
delete from brand where id = 4;
delete from brand where id = 5;
delete from brand where id = 6;
delete from brand where id = 7;

-- JOINS, HAVING, GROUP BY

                -- INNER JOIN, 2 GROUP BY
select * from address a inner join user u on u.id_address = a.id;
select * from address a inner join store s on s.id_address = a.id;
select count(p.id) as amount, b.name as brand from brand b inner join product p on b.id = p.id_brand group by b.name;
select count(u.id) as amount, l.name as language from user u inner join language l on u.id_language = l.id group by l.name;
select * from driver d inner join user u on d.id_user = u.id;

                -- LEFT JOIN, 3 HAVING, 1 GROUP BY
select s.* from store s left join address a on a.id = s.id_address where a.id_city = 1;
select p.id, p.name, avg(price), i.amount from product p left join inventory i on p.id = i.id_product group by p.id having avg(price) > 100;
select u.id, u.username, d.rating, d.free from driver d left join user u on d.id_user = u.id;
select p.id, p.name as product, i.amount from inventory i left join product p on i.id_product = p.id having amount > 10;
select d.id_currentDelivery, p.name as product, d.amount from deliveryproduct d left join product p on d.id_product = p.id having amount > 10;

                -- RIGHT JOIN, 2 HAVING, 2 GROUP BY
select d.id_currentDelivery, p.name as product, d.amount from product p right join deliveryproduct d on d.id_product = p.id having amount > 10;
select d.id_currentDelivery, p.name as product, d.amount from product p right join deliveryproduct d on d.id_product = p.id group by d.id_currentDelivery;
select d.id as deliveryId, u.username, count(d.id) as deliveryAmount from delivery d right join user u on d.id_user = u.id group by u.id having count(d.id)>2;
select u.id, u.username, d.free as isFree, d.rating from user u right join driver d on u.id = d.id_user;
select co.name, c.name, co.priceMultiplier from country co right join city c on co.id = c.id_country;



