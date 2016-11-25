INSERT INTO clinic (clinic_id, account_type, clinic_name, clinic_prefix, registered_date) VALUES ('CH-PLATINUM-JASC', 3, 'JASC Clinic', 'JASC', '2016-10-30');

INSERT INTO users (user_id, birth_date, email, first_name, gender, last_name, password, role, clinic_clinic_id) VALUES ('CH-JASC-DJ8983JHDHIO', '1980-02-03', 'dj@gmail.com', 'djijdelly', 1, 'SICLAIT', '81dc9bdb52d04dc20036dbd8313ed055', 0, 'CH-PLATINUM-JASC');
INSERT INTO users (user_id, birth_date, email, first_name, gender, last_name, password, role, clinic_clinic_id) VALUES ('CH-JASC-ESI34JHH432U', '1980-02-03', 'eva@gmail.com', 'eva', 0, 'SORAYA', '81dc9bdb52d04dc20036dbd8313ed055', 0, 'CH-PLATINUM-JASC');
INSERT INTO users (user_id, birth_date, email, first_name, gender, last_name, password, role, clinic_clinic_id) VALUES ('CH-JASC-EV933JBF453D', '1980-02-03', 'eduardo@gmail.com', 'eduardo', 1, 'Veras', '81dc9bdb52d04dc20036dbd8313ed055', 0, 'CH-PLATINUM-JASC');
INSERT INTO users (user_id, birth_date, email, first_name, gender, last_name, password, role, clinic_clinic_id) VALUES ('CH-JASC-PAULINA32443', '1980-02-03', 'paulina@email.com', 'paulina', 0, 'LA MEJOR', '81dc9bdb52d04dc20036dbd8313ed055', 0, 'CH-PLATINUM-JASC');

INSERT INTO users (user_id, birth_date, email, first_name, gender, last_name, password, role, clinic_clinic_id) VALUES ('CH-JASC-DOCTOR', '1980-02-03', 'med@gmail.com', 'Dr', 1, 'Doctor', '81dc9bdb52d04dc20036dbd8313ed055', 1, 'CH-PLATINUM-JASC');
INSERT INTO users (user_id, birth_date, email, first_name, gender, last_name, password, role, clinic_clinic_id) VALUES ('CH-JASC-ASSISTANT', '1980-02-03', 'ass@gmail.com', 'Assis', 0, 'Assistant', '81dc9bdb52d04dc20036dbd8313ed055', 2, 'CH-PLATINUM-JASC');

INSERT INTO patients (
clinic_clinic_id,
patient_id,
  occupation,
  patient_address,
  patient_birth_date,
  patient_city,
  patient_contact_telephone_number,
  patient_country,
  patient_email,
  patient_first_name,
  patient_gender,
  patient_id_card,
  patient_last_name,
  patient_nationality,
  patient_registered_date,
  patient_telephone_number) VALUES
('CH-PLATINUM-JASC', 'JASC-P-BVN309WJHN32', 'Lawyer', 'Villa Olga', '1992-10-31', 'Santiago',
'829xxxyyyy', 'RD', 'dj92@gmail.com', 'Djidjelly', 1, '1234rfg 323',
'Siclait', 'Haitian', '2015-11-15', '809xxxyyyy');

INSERT INTO records (record_id, patient_patient_id) VALUES ('JASC-R-DJ', 'JASC-P-BVN309WJHN32');

INSERT INTO patients (
clinic_clinic_id,
patient_id,
  occupation,
  patient_address,
  patient_birth_date,
  patient_city,
  patient_contact_telephone_number,
  patient_country,
  patient_email,
  patient_first_name,
  patient_gender,
  patient_id_card,
  patient_last_name,
  patient_nationality,
  patient_registered_date,
  patient_telephone_number) VALUES
('CH-PLATINUM-JASC', 'JASC-P-BVN3DF43WED32', 'Police Officer', 'Queens', '1996-11-17', 'NYC',
'829xxxyyyy', 'USA', 'eduardo2@gmail.com', 'Eduardo', 1, '12343eg 323',
'Veras', 'Dominicana', '2011-10-31', '809xxxyyyy');

INSERT INTO records (record_id, patient_patient_id) VALUES ('JASC-R-WARDO', 'JASC-P-BVN3DF43WED32');

INSERT INTO patients (
clinic_clinic_id,
patient_id,
  occupation,
  patient_address,
  patient_birth_date,
  patient_city,
  patient_contact_telephone_number,
  patient_country,
  patient_email,
  patient_first_name,
  patient_gender,
  patient_id_card,
  patient_last_name,
  patient_nationality,
  patient_registered_date,
  patient_telephone_number) VALUES
('CH-PLATINUM-JASC', 'JASC-P-BVN309WDHN32', 'Vetenarian', 'Sience', '1982-11-19', 'Paris',
'829xxxyyyy', 'FR', 'eva45@gmail.com', 'Eva', 0, '12oih7g 323',
'Soraya', 'Dominicana', '2015-10-28', '809xxxyyyy');

INSERT INTO records (record_id, patient_patient_id) VALUES ('JASC-R-EVA', 'JASC-P-BVN309WDHN32');

INSERT INTO contact (clinic_clinic_id, contact_id, first_name, last_name, email, birth_date, has_account) VALUES ('CH-PLATINUM-JASC', 'JASC-STAFF-PAULINA', 'Paulina', 'Reyes', 'p@gmail.com', '1985-03-23', TRUE );
INSERT INTO contact (clinic_clinic_id, contact_id, first_name, last_name, email, birth_date, has_account) VALUES ('CH-PLATINUM-JASC', 'JASC-STAFF-SICARD', 'Julio', 'Sicard', 'js@gmail.com', '1980-11-18', FALSE);
INSERT INTO contact (clinic_clinic_id, contact_id, first_name, last_name, email, birth_date, has_account) VALUES ('CH-PLATINUM-JASC', 'JASC-STAFF-ADELSO', 'Adelso', 'Tejada', 'at@gmail.com', '1990-02-02', FALSE);
INSERT INTO contact (clinic_clinic_id, contact_id, first_name, last_name, email, birth_date, has_account) VALUES ('CH-PLATINUM-JASC', 'JASC-STAFF-ASTRID', 'Astrid', 'Incarnacion', 'ai@gmail.com', '1990-11-22', FALSE);

INSERT INTO appointments(clinic_clinic_id, appointment_id, appointment_time, patient_patient_id, appointment_description, appointment_access_from, appointment_type, appointment_status) VALUES (
'CH-PLATINUM-JASC',
'JASC123456',
'2016-11-14 10:10:00',
'JASC-P-BVN309WJHN32',
'Rhinoplasti for facial reconstruction',
0,
0,
0);

INSERT INTO appointments(clinic_clinic_id, appointment_id, appointment_time, patient_patient_id, appointment_description, appointment_access_from, appointment_type, appointment_status) VALUES (
'CH-PLATINUM-JASC',
'JASC123452',
'2016-11-14 11:10:00',
'JASC-P-BVN3DF43WED32',
'Botox and face lift',
0,
0,
0);

INSERT INTO meetings (
clinic_clinic_id,
meeting_id,
meeting_objective,
meeting_place,
meeting_time,
meeting_title) VALUES
('CH-PLATINUM-JASC', 'JASC-M-NY934WHRC3', 'Make plans for Christmas charity event', 'Meeting Room 102', '2016-11-16 08:45:00', 'JASC Cancer Charity');

INSERT INTO  meetings_attendees (meeting_meeting_id, attendees_contact_id) VALUES ('JASC-M-NY934WHRC3', 'JASC-STAFF-PAULINA');
INSERT INTO  meetings_attendees (meeting_meeting_id, attendees_contact_id) VALUES ('JASC-M-NY934WHRC3', 'JASC-STAFF-ASTRID');
INSERT INTO  meetings_attendees (meeting_meeting_id, attendees_contact_id) VALUES ('JASC-M-NY934WHRC3', 'JASC-STAFF-SICARD');
INSERT INTO  meetings_attendees (meeting_meeting_id, attendees_contact_id) VALUES ('JASC-M-NY934WHRC3', 'JASC-STAFF-ADELSO');

INSERT INTO meetings (
clinic_clinic_id,
meeting_id,
meeting_objective,
meeting_place,
meeting_time,
meeting_title) VALUES
('CH-PLATINUM-JASC', 'JASC-M-NY934UINRC3', 'Prepare for Annual Medical Association of Latino America seminar', 'Main Office', '2016-11-14 16:30:00', 'Seminar Prep');

INSERT INTO  meetings_attendees (meeting_meeting_id, attendees_contact_id) VALUES ('JASC-M-NY934UINRC3', 'JASC-STAFF-SICARD');
INSERT INTO  meetings_attendees (meeting_meeting_id, attendees_contact_id) VALUES ('JASC-M-NY934UINRC3', 'JASC-STAFF-ADELSO');

INSERT INTO chore (user_user_id, chore_id, description, title, type, completed, next_reminder, reminders) VALUES ('CH-JASC-DJ8983JHDHIO', 'JASC-M-9URHFDN', 'Restock Mayers Plus XL Braseir', 'Inventory refill', 4, FALSE, '2012-01-12', E'\\xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000017704000000017E720023636F6D2E636C696E696368656C7065722E546F6F6C732E456E756D732E52657065617400000000000000001200007872000E6A6176612E6C616E672E456E756D0000000000000000120000787074000945564552595F44415978');
INSERT INTO chore (user_user_id, chore_id, description, title, type, completed, next_reminder, reminders) VALUES ('CH-JASC-DJ8983JHDHIO', 'JASC-M-9UR23DN', 'Call Accountant For Tax Return', 'Finance', 6, FALSE, '2016-11-18', E'\\xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000017704000000017E720023636F6D2E636C696E696368656C7065722E546F6F6C732E456E756D732E52657065617400000000000000001200007872000E6A6176612E6C616E672E456E756D0000000000000000120000787074000646524944415978');

INSERT INTO equipments (
equipment_id,
equipment_description,
equipment_in_stock,
equipment_name,
equipment_use,
clinic_clinic_id) VALUES
('JASC-E-VYHU7iuyh', 'For surgically precise incisions', 131, 'Scalpel', 'Sharp Tool', 'CH-PLATINUM-JASC');

INSERT INTO equipments (
equipment_id,
equipment_description,
equipment_in_stock,
equipment_name,
equipment_use,
clinic_clinic_id) VALUES
('JASC-E-VYHU876yh', 'silicone breasts implants for mamary reconstruction', 31, 'Silic Implants', 'Implants', 'CH-PLATINUM-JASC');

INSERT INTO equipments (
equipment_id,
equipment_description,
equipment_in_stock,
equipment_name,
equipment_use,
clinic_clinic_id) VALUES
('JASC-E-VYHUUJH7iuyh', 'eneral medical tool', 13, 'Stetascope', 'Hearing', 'CH-PLATINUM-JASC');

INSERT INTO items (
product_id,
product_description,
product_in_stock,
product_name,
product_price,
supplier,
clinic_clinic_id) VALUES
('JASC-P-HUJBUYHH778', 'Mayers Braseir', 54, 'Bra', 432.42, 'Procter and Gamble', 'CH-PLATINUM-JASC');

INSERT INTO medications (
medication_id,
medication_description,
medication_in_stock,
medication_name,
medication_price,
supplier,
clinic_clinic_id) VALUES
('JASC-MED-UHGYHJNG343', 'Low pain medication', 200, 'Ibuprofen', 43.20, 'MED Pact', 'CH-PLATINUM-JASC');

INSERT INTO medications (
medication_id,
medication_description,
medication_in_stock,
medication_name,
medication_price,
supplier,
clinic_clinic_id) VALUES
('JASC-MED-UH43HJNG343', 'Surgical Anaesthetic', 100, 'I-Zuprina', 3.20, 'MED Pact', 'CH-PLATINUM-JASC');
