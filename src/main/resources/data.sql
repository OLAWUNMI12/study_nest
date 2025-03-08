--INSERT INTO department (id, name) VALUES
--(1, 'Computer Science'),
--(2, 'Electrical Engineering'),
--(3, 'Mechanical Engineering');
--
--INSERT INTO courses (id, name, code, department_id) VALUES
--(1, 'Spring Boot', 'CS101', 1),
--(2, 'Machine Learning', 'CS102', 1),
--(3, 'Data Structures', 'CS103', 1),
--(4, 'Algorithms', 'CS104', 1),
--(5, 'Operating Systems', 'CS105', 1);
--
--INSERT INTO courses (id, name, code, department_id) VALUES
--(6, 'Digital Circuits', 'EE101', 2),
--(7, 'Power Systems', 'EE102', 2),
--(8, 'Microprocessors', 'EE103', 2),
--(9, 'Control Systems', 'EE104', 2),
--(10, 'Electromagnetics', 'EE105', 2);
--
--INSERT INTO courses (id, name, code, department_id) VALUES
--(11, 'Thermodynamics', 'ME101', 3),
--(12, 'Fluid Mechanics', 'ME102', 3),
--(13, 'Heat Transfer', 'ME103', 3),
--(14, 'Machine Design', 'ME104', 3),
--(15, 'Manufacturing Processes', 'ME105', 3);


INSERT INTO department (id, name) VALUES
(1, 'Business Management'),
(2, 'Cyber Security'),
(3, 'Software Engineering');

-- Business Management Courses
INSERT INTO courses (id, name, code, department_id) VALUES
(1, 'Business Analysis', 'BSM 210', 1),
(2, 'Business Management And Organization Booklet', 'BSM 217', 1),
(3, 'Entrepreneurship and Business Development', 'BSM 237', 1),
(4, 'Business admin and management', 'BSM 126', 1),
(5, 'Corporate Strategy and Leadership', 'BSM 456', 1),
(6, 'E-commerce and Digital Business', 'BSM 543', 1),
(7, 'Negotiation and Conflict Resolution', 'BSM 203', 1),
(8, 'Leadership and Organizational Behavior', 'BSM 229', 1),
(9, 'Introduction to Business Management', 'BSM 399', 1),
(10, 'Human Resource Management', 'BSM 367', 1),
(11, 'Organizational Performance', 'BSM 110', 1),
(12, 'Economy Sectors', 'BSM 109', 1),
(13, 'Strategic Management', 'BSM 433', 1);

-- Cyber Security Courses
INSERT INTO courses (id, name, code, department_id) VALUES
(14, 'Introduction to Cyber Security', 'CSY 289', 2),
(15, 'Cryptographic Hash Functions', 'CSY 323', 2),
(16, 'Cyber Security Case Study', 'CSY 643', 2),
(17, 'Cybercrime Challenges & Mitigation Strategies', 'CSY 342', 2),
(18, 'Gateway and Router Concepts', 'CSY 671', 2),
(19, 'Internet Protocol', 'CSY 423', 2),
(20, 'IP Address Fundamentals', 'CSY 432', 2),
(21, 'LAN Adapters', 'CSY 289', 2),
(22, 'Network Mapper', 'CSY 345', 2),
(23, 'Network Utilities', 'CSY 121', 2),
(24, 'Network Work Terminology', 'CSY 198', 2),
(25, 'Setup Engine', 'CSY 109', 2),
(26, 'WordPress Site Setup', 'CSY 423', 2),
(27, 'Secure Shell', 'CSY 478', 2),
(28, 'Open System Model (OSI)', 'CSY 532', 2);

-- Software Engineering Courses
INSERT INTO courses (id, name, code, department_id) VALUES
(29, 'Web Design', 'SWE 111', 3),
(30, 'Data Structure & Algorithms', 'SWE 154', 3),
(31, 'Flowchart Necessity', 'SWE 132', 3),
(32, 'Hosting', 'SWE 432', 3),
(33, 'Javascript Fundamentals', 'SWE 232', 3),
(34, 'Java', 'SWE 253', 3),
(35, 'Web Layout', 'SWE 289', 3),
(36, 'User Persona', 'SWE 342', 3),
(37, 'Styling and Animations', 'SWE 342', 3),
(38, 'Understanding Database', 'SWE 230', 3),
(39, 'Data Manipulation', 'SWE 320', 3),
(40, 'Starting Docker', 'SWE 389', 3),
(41, 'Python', 'SWE 364', 3),
(42, 'UX Design & Research', 'SWE 521', 3),
(43, 'Pair Programming', 'SWE 452', 3);
