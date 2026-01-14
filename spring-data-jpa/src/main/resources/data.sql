INSERT INTO student.address (id,description) VALUES
	 (34,'Istanbul/Cekmekoy') 
	 ON CONFLICT (id) DO NOTHING;
	 
INSERT INTO student.customer (id,"name",address_id) VALUES
	 (1,'Huseyin',34) 
	 ON CONFLICT (id) DO NOTHING;
	 
INSERT INTO student.department (id,department_name) VALUES
	 (55,'software') 
	 ON CONFLICT (id) DO NOTHING;
	 
INSERT INTO student.employee (id,"name",department_id) VALUES
	 (1,'Huseyin',55),
	 (2,'Burak',55),
	 (3,'Koray',55),
	 (4,'Yusuf',55),
	 (5,'Efe',55) 
	 ON CONFLICT (id) DO NOTHING;
	
INSERT INTO student.home (id,price) VALUES
	 (1,900000.00) 
	 ON CONFLICT (id) DO NOTHING;
	 
INSERT INTO student.room (id,"name") VALUES
	 (66,'Misafir Odasi'),
	 (67,'Yatak Odasi'),
	 (68,'Banyo') 
	 ON CONFLICT (id) DO NOTHING;
	 
INSERT INTO student.home_room (home_id,room_id) VALUES
	 (1,66),
	 (1,67),
	 (1,68) 
	 ON CONFLICT (room_id) DO NOTHING;
	 
INSERT INTO student.student (id,birth_of_date,first_name,last_name) VALUES
	 (1,'2003-04-29 00:00:00','Huseyin','Sacikay'),
	 (2,'2003-05-30 00:00:00','Burak','Yildirim'),
	 (3,'2003-06-30 00:00:00','Koray','Atalay'),
	 (4,'2003-07-31 00:00:00','Yusuf','Baytok'),
	 (5,'2003-08-31 00:00:00','Mehmet Efe','Ergin'),
	 (6,'2003-09-30 00:00:00','Yunis','Ibrahimov'),
	 (8,'2003-10-31 02:00:00','Dunya','Goyushlu') 
	 ON CONFLICT (id) DO NOTHING;
	 
INSERT INTO student.course (id,"name") VALUES
	 (1,'Optimizasyon'),
	 (2,'Blockchain')
	 ON CONFLICT (id) DO NOTHING;
	 
INSERT INTO student.student_course (student_id,course_id) VALUES
	 (1,1),
	 (1,2),
	 (2,1),
	 (2,2),
	 (3,1),
	 (4,2)
	 ON CONFLICT (student_id,course_id) DO NOTHING;
