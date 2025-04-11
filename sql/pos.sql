create table company_category (
company_category_id serial primary key not null,
company_category_name varchar(256) not null
);

create table company(
company_id serial primary key not null,
company_name varchar(256) not null,
company_category_id int not null,

constraint fk_company_company_category foreign key(company_category_id) 
references company_category(company_category_id)
);

create table point_of_sale(
point_of_sale_id serial primary key,
point_of_sale_name varchar(256) not null,
company_id int not null,

constraint uq_point_of_sale_name_company_id unique(point_of_sale_name, company_id),
constraint fk_point_of_sale_company foreign key (company_id)
references company(company_id)
);

create table point_of_sale_transaction(
point_of_sale_transaction_id serial primary key not null,
point_of_sale_id int not null,
transaction_amount decimal(6,2),
card_number varchar(20) not null,
card_type varchar(6) not null check (card_type in('Debit', 'Credit')),
card_network varchar(10) not null check (card_network in ('Visa', 'Mastercard')),
transaction_date timestamp not null default current_timestamp,
status varchar(8) not null check(status in('SUCCESS', 'FAILED')),
status_message varchar(256) not null,

constraint fk_point_of_sale_transaction_point_of_sale foreign key(point_of_sale_id)
references point_of_sale(point_of_sale_id)
);

--search for constraint names.
-- SELECT conname 
-- FROM pg_constraint 
-- WHERE conrelid = 'point_of_sale_transaction'::regclass;

-- alter table point_of_sale_transaction drop constraint "point_of_sale_transaction_status_check";



create table transaction_history(
transaction_history_id serial primary key not null,
point_of_sale_transaction_id int not null,
status varchar(8) not null,
status_message varchar(256) not null,
company_id int not null,

constraint transaction_history_point_of_sale_transaction foreign key(point_of_sale_transaction_id)
references point_of_sale_transaction(point_of_sale_transaction_id),

constraint transaction_history_company foreign key(company_id)
references company(company_id)
);


-- select c.company_id, c.company_name, cc.company_category_name 
-- from company c 
-- join company_category cc on c.company_category_id = cc.company_category_id;

select * from point_of_sale_transaction;

select * from point_of_sale;
select * from company where company_id = 82;

select * from company_category where company_category_id = 26;

select * from point_of_sale_transaction;






