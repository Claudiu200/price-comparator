INSERT INTO discounts (
    product_id, store_name, from_date, to_date,
    product_name, brand, package_quantity, package_unit,
    product_category, percentage_of_discount, registered_at
) VALUES
-- lidl_discounts_2025-05-01.csv
('P001', 'lidl', '2025-05-01', '2025-05-07', 'lapte zuzu', 'Zuzu', 1, 'l', 'lactate', 10, '2025-05-01'),
('P008', 'lidl', '2025-05-01', '2025-05-07', 'brânză telemea', 'Pilos', 0.3, 'kg', 'lactate', 15, '2025-05-01'),
('P020', 'lidl', '2025-05-03', '2025-05-09', 'spaghetti nr.5', 'Barilla', 500, 'g', 'paste făinoase', 20, '2025-05-01'),

-- kaufland_discounts_2025-05-08.csv
('P001', 'kaufland', '2025-05-08', '2025-05-14', 'lapte zuzu', 'Zuzu', 1, 'l', 'lactate', 9, '2025-05-08'),
('P006', 'kaufland', '2025-05-08', '2025-05-14', 'ouă mărimea M', 'Ferma Veche', 10, 'buc', 'ouă', 11, '2025-05-08'),
('P012', 'kaufland', '2025-05-09', '2025-05-15', 'pâine albă', 'K-Classic', 500, 'g', 'panificație', 7, '2025-05-08'),
('P022', 'kaufland', '2025-05-10', '2025-05-16', 'zahăr tos', 'Mărgăritar', 1, 'kg', 'alimente de bază', 6, '2025-05-08'),
('P029', 'kaufland', '2025-05-08', '2025-05-14', 'ulei floarea-soarelui', 'Floriol', 1, 'l', 'alimente de bază', 8, '2025-05-08'),
('P032', 'kaufland', '2025-05-09', '2025-05-15', 'biscuiți cu unt', 'Milka', 0.2, 'kg', 'gustări', 12, '2025-05-08'),
('P035', 'kaufland', '2025-05-10', '2025-05-16', 'cafea măcinată', 'Jacobs', 0.25, 'kg', 'cafea', 11, '2025-05-08'),
('P044', 'kaufland', '2025-05-08', '2025-05-14', 'hârtie igienică 3 straturi', 'Pufina', 10, 'role', 'produse de menaj', 13, '2025-05-08'),

-- profi_discounts_2025-05-08.csv
('P004', 'profi', '2025-05-08', '2025-05-14', 'iaurt grecesc', 'Proxi', 0.4, 'kg', 'lactate', 9, '2025-05-08'),
('P007', 'profi', '2025-05-08', '2025-05-14', 'ouă mărimea M', 'Din Ogradă', 10, 'buc', 'ouă', 10, '2025-05-08'),
('P020', 'profi', '2025-05-09', '2025-05-15', 'spaghetti nr.5', 'Barilla', 500, 'g', 'paste făinoase', 15, '2025-05-08'),
('P024', 'profi', '2025-05-10', '2025-05-16', 'apă plată', 'Aqua Carpatica', 2, 'l', 'băuturi', 7, '2025-05-08'),
('P030', 'profi', '2025-05-08', '2025-05-14', 'ulei floarea-soarelui', 'Spornic', 1, 'l', 'alimente de bază', 6, '2025-05-08'),
('P039', 'profi', '2025-05-09', '2025-05-15', 'detergent lichid', 'Dero', 2.5, 'l', 'produse de menaj', 18, '2025-05-08');