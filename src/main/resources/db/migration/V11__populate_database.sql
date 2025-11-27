INSERT INTO categories (name) VALUES
('Fruits & Vegetables'),
('Dairy'),
('Bakery'),
('Beverages'),
('Meat & Seafood'),
('Snacks');


INSERT INTO products (name, price, description, category_id) VALUES
('Bananas', 1.29, 'Fresh yellow bananas sold by the pound.', 1),
('Organic Baby Spinach', 3.99, 'Washed and ready-to-eat organic spinach leaves, 5 oz pack.', 1),

('Whole Milk – 1 Gallon', 4.59, 'Grade A whole milk sourced from local dairy farms.', 2),
('Greek Yogurt – Strawberry 6oz', 1.49, 'Thick and creamy Greek yogurt with real strawberry puree.', 2),

('Sourdough Bread Loaf', 5.79, 'Freshly baked sourdough bread with a crispy crust.', 3),
('Blueberry Muffins – 4 Pack', 4.99, 'Moist bakery-style muffins made with fresh blueberries.', 3),

('Coca-Cola 12-Pack', 7.49, 'Twelve 12oz cans of classic Coca-Cola.', 4),
('Orange Juice – No Pulp 59oz', 4.29, '100% pure squeezed orange juice with no pulp.', 4),

('Fresh Atlantic Salmon Fillet', 12.99, 'Premium salmon fillet, skin-on, sold per pound.', 5),
('Chicken Drumsticks – 2 lb', 5.49, 'Fresh, never-frozen chicken drumsticks, family pack.', 5);
