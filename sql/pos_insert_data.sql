--INSERT DATA
INSERT INTO company_category (company_category_name) VALUES ('Finance');
INSERT INTO company_category (company_category_name) VALUES ('Restaurant');
INSERT INTO company_category (company_category_name) VALUES ('Retailer');
INSERT INTO company_category (company_category_name) VALUES ('Market');
INSERT INTO company_category (company_category_name) VALUES ('Technology');
INSERT INTO company_category (company_category_name) VALUES ('Healthcare');
INSERT INTO company_category (company_category_name) VALUES ('Education');
INSERT INTO company_category (company_category_name) VALUES ('Construction');
INSERT INTO company_category (company_category_name) VALUES ('Transportation');
INSERT INTO company_category (company_category_name) VALUES ('Real Estate');
INSERT INTO company_category (company_category_name) VALUES ('Automotive');
INSERT INTO company_category (company_category_name) VALUES ('Hospitality');
INSERT INTO company_category (company_category_name) VALUES ('Insurance');
INSERT INTO company_category (company_category_name) VALUES ('Legal Services');
INSERT INTO company_category (company_category_name) VALUES ('Consulting');
INSERT INTO company_category (company_category_name) VALUES ('Entertainment');
INSERT INTO company_category (company_category_name) VALUES ('E-commerce');
INSERT INTO company_category (company_category_name) VALUES ('Manufacturing');
INSERT INTO company_category (company_category_name) VALUES ('Logistics');
INSERT INTO company_category (company_category_name) VALUES ('Agriculture');
INSERT INTO company_category (company_category_name) VALUES ('Telecommunications');
INSERT INTO company_category (company_category_name) VALUES ('Media');
INSERT INTO company_category (company_category_name) VALUES ('Fashion');
INSERT INTO company_category (company_category_name) VALUES ('Pharmaceuticals');
INSERT INTO company_category (company_category_name) VALUES ('Food & Beverage');
INSERT INTO company_category (company_category_name) VALUES ('Energy');
INSERT INTO company_category (company_category_name) VALUES ('Sports');
INSERT INTO company_category (company_category_name) VALUES ('Non-Profit');
INSERT INTO company_category (company_category_name) VALUES ('Software Development');
INSERT INTO company_category (company_category_name) VALUES ('Human Resources');
INSERT INTO company_category (company_category_name) VALUES ('Security');
INSERT INTO company_category (company_category_name) VALUES ('Marketing');
INSERT INTO company_category (company_category_name) VALUES ('Banking');
INSERT INTO company_category (company_category_name) VALUES ('Travel & Tourism');
INSERT INTO company_category (company_category_name) VALUES ('Fitness & Wellness');
INSERT INTO company_category (company_category_name) VALUES ('Grocery Store');
INSERT INTO company_category (company_category_name) VALUES ('Architecture');
INSERT INTO company_category (company_category_name) VALUES ('Engineering');
INSERT INTO company_category (company_category_name) VALUES ('Art & Design');
INSERT INTO company_category (company_category_name) VALUES ('Event Planning');
INSERT INTO company_category (company_category_name) VALUES ('Bookstore');
INSERT INTO company_category (company_category_name) VALUES ('Pet Services');
INSERT INTO company_category (company_category_name) VALUES ('Home Services');
INSERT INTO company_category (company_category_name) VALUES ('Luxury Goods');
INSERT INTO company_category (company_category_name) VALUES ('Gaming Industry');
INSERT INTO company_category (company_category_name) VALUES ('Public Relations');
INSERT INTO company_category (company_category_name) VALUES ('Recruitment');
INSERT INTO company_category (company_category_name) VALUES ('Hardware Manufacturing');
INSERT INTO company_category (company_category_name) VALUES ('Data Analytics');

select * from company_category;

--INSERT DATA
-- Finance (ID: 1)
INSERT INTO company (company_name, company_category_id) VALUES ('PayPal', 1);
INSERT INTO company (company_name, company_category_id) VALUES ('Goldman Sachs', 1);
INSERT INTO company (company_name, company_category_id) VALUES ('Visa', 1);
INSERT INTO company (company_name, company_category_id) VALUES ('Mastercard', 1);

-- Restaurant (ID: 2)
INSERT INTO company (company_name, company_category_id) VALUES ('McDonalds', 2);
INSERT INTO company (company_name, company_category_id) VALUES ('KFC', 2);
INSERT INTO company (company_name, company_category_id) VALUES ('Subway', 2);
INSERT INTO company (company_name, company_category_id) VALUES ('Dominos Pizza', 2);

-- Retailer (ID: 3)
INSERT INTO company (company_name, company_category_id) VALUES ('Walmart', 3);
INSERT INTO company (company_name, company_category_id) VALUES ('Costco', 3);
INSERT INTO company (company_name, company_category_id) VALUES ('Target', 3);
INSERT INTO company (company_name, company_category_id) VALUES ('Best Buy', 3);

-- Market (ID: 4)
INSERT INTO company (company_name, company_category_id) VALUES ('Nasdaq', 4);
INSERT INTO company (company_name, company_category_id) VALUES ('NYSE', 4);
INSERT INTO company (company_name, company_category_id) VALUES ('London Stock Exchange', 4);
INSERT INTO company (company_name, company_category_id) VALUES ('Tokyo Stock Exchange', 4);

-- Technology (ID: 5)
INSERT INTO company (company_name, company_category_id) VALUES ('Google', 5);
INSERT INTO company (company_name, company_category_id) VALUES ('Apple', 5);
INSERT INTO company (company_name, company_category_id) VALUES ('Microsoft', 5);
INSERT INTO company (company_name, company_category_id) VALUES ('Amazon', 5);

-- Healthcare (ID: 6)
INSERT INTO company (company_name, company_category_id) VALUES ('Johnson & Johnson', 6);
INSERT INTO company (company_name, company_category_id) VALUES ('Pfizer', 6);
INSERT INTO company (company_name, company_category_id) VALUES ('Moderna', 6);
INSERT INTO company (company_name, company_category_id) VALUES ('UnitedHealth Group', 6);

-- Education (ID: 7)
INSERT INTO company (company_name, company_category_id) VALUES ('Coursera', 7);
INSERT INTO company (company_name, company_category_id) VALUES ('Udemy', 7);
INSERT INTO company (company_name, company_category_id) VALUES ('Khan Academy', 7);
INSERT INTO company (company_name, company_category_id) VALUES ('Pearson', 7);

-- Construction (ID: 8)
INSERT INTO company (company_name, company_category_id) VALUES ('Caterpillar', 8);
INSERT INTO company (company_name, company_category_id) VALUES ('Vinci', 8);
INSERT INTO company (company_name, company_category_id) VALUES ('Fluor Corporation', 8);
INSERT INTO company (company_name, company_category_id) VALUES ('ACS Group', 8);

-- Transportation (ID: 9)
INSERT INTO company (company_name, company_category_id) VALUES ('Uber', 9);
INSERT INTO company (company_name, company_category_id) VALUES ('Lyft', 9);
INSERT INTO company (company_name, company_category_id) VALUES ('FedEx', 9);
INSERT INTO company (company_name, company_category_id) VALUES ('DHL', 9);

-- Real Estate (ID: 10)
INSERT INTO company (company_name, company_category_id) VALUES ('Zillow', 10);
INSERT INTO company (company_name, company_category_id) VALUES ('Redfin', 10);
INSERT INTO company (company_name, company_category_id) VALUES ('CBRE Group', 10);
INSERT INTO company (company_name, company_category_id) VALUES ('RE/MAX', 10);

-- Automotive (ID: 11)
INSERT INTO company (company_name, company_category_id) VALUES ('Tesla', 11);
INSERT INTO company (company_name, company_category_id) VALUES ('Ford', 11);
INSERT INTO company (company_name, company_category_id) VALUES ('Toyota', 11);
INSERT INTO company (company_name, company_category_id) VALUES ('General Motors', 11);

-- Hospitality (ID: 12)
INSERT INTO company (company_name, company_category_id) VALUES ('Marriott', 12);
INSERT INTO company (company_name, company_category_id) VALUES ('Hilton', 12);
INSERT INTO company (company_name, company_category_id) VALUES ('Hyatt', 12);
INSERT INTO company (company_name, company_category_id) VALUES ('Airbnb', 12);

-- Insurance (ID: 13)
INSERT INTO company (company_name, company_category_id) VALUES ('Allstate', 13);
INSERT INTO company (company_name, company_category_id) VALUES ('State Farm', 13);
INSERT INTO company (company_name, company_category_id) VALUES ('MetLife', 13);
INSERT INTO company (company_name, company_category_id) VALUES ('Progressive', 13);

-- Consulting (ID: 14)
INSERT INTO company (company_name, company_category_id) VALUES ('McKinsey & Company', 14);
INSERT INTO company (company_name, company_category_id) VALUES ('Boston Consulting Group', 14);
INSERT INTO company (company_name, company_category_id) VALUES ('Deloitte', 14);
INSERT INTO company (company_name, company_category_id) VALUES ('PwC', 14);

-- Entertainment (ID: 15)
INSERT INTO company (company_name, company_category_id) VALUES ('Netflix', 15);
INSERT INTO company (company_name, company_category_id) VALUES ('Disney', 15);
INSERT INTO company (company_name, company_category_id) VALUES ('Warner Bros', 15);
INSERT INTO company (company_name, company_category_id) VALUES ('Sony Pictures', 15);

-- E-commerce (ID: 16)
INSERT INTO company (company_name, company_category_id) VALUES ('Amazon', 16);
INSERT INTO company (company_name, company_category_id) VALUES ('eBay', 16);
INSERT INTO company (company_name, company_category_id) VALUES ('Shopify', 16);
INSERT INTO company (company_name, company_category_id) VALUES ('Alibaba', 16);

-- Logistics (ID: 19)
INSERT INTO company (company_name, company_category_id) VALUES ('UPS', 19);
INSERT INTO company (company_name, company_category_id) VALUES ('FedEx', 19);
INSERT INTO company (company_name, company_category_id) VALUES ('Maersk', 19);
INSERT INTO company (company_name, company_category_id) VALUES ('DHL', 19);

-- Telecommunications (ID: 21)
INSERT INTO company (company_name, company_category_id) VALUES ('Verizon', 21);
INSERT INTO company (company_name, company_category_id) VALUES ('AT&T', 21);
INSERT INTO company (company_name, company_category_id) VALUES ('T-Mobile', 21);
INSERT INTO company (company_name, company_category_id) VALUES ('Vodafone', 21);

-- Fashion (ID: 23)
INSERT INTO company (company_name, company_category_id) VALUES ('Nike', 23);
INSERT INTO company (company_name, company_category_id) VALUES ('Adidas', 23);
INSERT INTO company (company_name, company_category_id) VALUES ('Gucci', 23);
INSERT INTO company (company_name, company_category_id) VALUES ('Zara', 23);

-- Food & Beverage (ID: 25)
INSERT INTO company (company_name, company_category_id) VALUES ('Coca-Cola', 25);
INSERT INTO company (company_name, company_category_id) VALUES ('Pepsi', 25);
INSERT INTO company (company_name, company_category_id) VALUES ('Nestlé', 25);
INSERT INTO company (company_name, company_category_id) VALUES ('Starbucks', 25);

-- Energy (ID: 26)
INSERT INTO company (company_name, company_category_id) VALUES ('ExxonMobil', 26);
INSERT INTO company (company_name, company_category_id) VALUES ('Shell', 26);
INSERT INTO company (company_name, company_category_id) VALUES ('BP', 26);
INSERT INTO company (company_name, company_category_id) VALUES ('Chevron', 26);
INSERT INTO company (company_name, company_category_id) VALUES ('TotalEnergies', 26);

--insert data in POS
insert into point_of_sale(point_of_sale_name, company_id)
values
('POS #1 Shell Gas Station', 82),
('POS #2 Shell Gas Station', 82),
('POS #3 Shell Gas Station', 82),
('POS #4 Shell Gas Station', 82);

