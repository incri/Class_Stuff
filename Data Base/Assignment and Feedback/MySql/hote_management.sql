
CREATE TABLE User(
#Creating User Table
User_ID INT(10) PRIMARY KEY,
User_Name VARCHAR(50) NOT NULL UNIQUE,
Email_Address VARCHAR(50) NOT NULL UNIQUE,
Password VARCHAR(50) NOT NULL,
User_Type VARCHAR(50) NOT NULL
);

INSERT INTO User(
#Inserting data into User Table
User_ID, User_Name, Email_Address, Password, User_Type )
VALUES
(1001, 'bwilliams', 'bwilliams@gmail.com', 'bwilliams123%','Customer'), 
(1002, 'abrown', 'abrown@gmail.com', 'abrown123%','Customer'),
(1003, 'psmith', 'psmith@gmail.com', 'psmith123%','Customer' ),
(1004, 'kevans', 'kevans@gmail.com', 'kevans123%','Customer'),
(1005, 'ssmith', 'ssmith@gmail.com', 'ssmith123%','Administrator'),
(1006, 'kJones', 'kJones@gmail.com', 'kJones123%','Customer'),
(1007, 'jbrown', 'jbrown@gmail.com', 'jbrown123%','Customer'), 
(1008, 'jtaylor', 'jtaylor@gmail.com', 'jtaylor123%','Personnel'),
(1009, 'rwilliams', 'rwilliams@gmail.com', 'rwilliams123%','Personnel'),
(1010, 'sgreen', 'sgreen@gmail.com', 'sgreen123%','Customer');


CREATE TABLE Customer (
#Creating Customer Table
Cus_ID INT(10) PRIMARY KEY,
First_Name VARCHAR(50) NOT NULL,
Last_Name VARCHAR(50) NOT NULL,
Address VARCHAR(110) NOT NULL,
Contact VARCHAR(50) NOT NULL,
DOB date NOT NULL,
UserUser_ID INT(10) NOT NULL,
FOREIGN KEY (UserUser_ID) REFERENCES User(User_ID)
);

INSERT  INTO Customer(
#Inserting data into Customer Table
Cus_ID, First_Name, Last_Name, Address, Contact, DOB, UserUser_ID
)
VALUES
(1,	'Brody',	'Williams',	'Baltasound-68 Ballifeary Road',	'079 2556 3181',	'1996-08-20', 1001),
(2,	'Andrew',	'Brown',	'Wilby-68 Ramsgate Rd',	'079 5528 4239',	'1979-03-10', 1002),
(3,	'Peter',	'Smith',	'Underriver-95 Helland Bridge',	'079 7622 4215',	'1988-09-08', 1003),
(4,	'Krish',	'Evans',	'Nonington-25 Cambridge Road',	'079 7622 6544',	'1980-09-05', 1004),
(5,	'Ken',	'Jones',	'Wilby-68 Ramsgate Rd',	'079 4457 5477',	'1959-08-28', 1006),
(6,	'Julia',	'Brown',	'Frith Bank-61 Golden Knowes Road',	'079 5547 6621',	'1976-03-24', 1007),
(7,'Sanaya',	'Green',	'Underriver-95 Helland Bridge',	'079 1754 6847',	'1979-11-07', 1010);


CREATE TABLE Staff (
#Creating Staff Table
Staff_ID INT(10) PRIMARY KEY,
staff_First_Name VARCHAR(50) NOT NULL,
Staff_Last_Name VARCHAR(50) NOT NULL,
Staff_Contact VARCHAR(50) NOT NULL,
Role VARCHAR(50) NOT NULL,
UserUser_ID INT(10) NOT NULL,
FOREIGN KEY (UserUser_ID) REFERENCES User(User_ID)
);

INSERT INTO Staff (
#Inserting data into Staff Table
Staff_ID, staff_First_Name, Staff_Last_Name, Staff_Contact, Role, UserUser_ID
)
VALUES
(101,	'Sam',	'Smith',	'079 2122 5487',	'Administrator', 1005),
(102,	'Jenet',	'Taylor',	'079 5877 6645',	'Personnel', 1008),
(103,	'Ruby',	'Williams',	'079 2122 2211',	'Personnel', 1009);


CREATE TABLE Room(
#Creating Room Table
Room_ID INT(10) PRIMARY KEY,
Room_Number INT(10) NOT NULL UNIQUE,
Price_Per_Night VARCHAR(50) NOT NULL,
Room_Type VARCHAR(50) NOT NULL,
Room_Detail VARCHAR(50) NOT NULL,
Status VARCHAR(50) NOT NULL
);

INSERT INTO Room (
#Inserting data into Room Table
Room_ID, Room_Number, Price_Per_Night, Room_Type, Room_Detail, Status
)
VALUES
(111,	1010,	'2500',	'Double',	'Don\'t have balcony', 'Booked'),
(222,	2020,	'1500',	'Single',	'have balcony','Booked'),
(333,	3030,	'2500',	'Double',	'Don\'t have balcony','Open'),
(444,	4040,	'2500',	'Double',	'Don\'t have balcony','Booked'),
(555,	5050,	'1500',	'Single',	'have balcony','Booked'),
(666,	6060,	'2500',	'Double',	'have balcony','Open'),
(777,	7070,	'1500',	'Single',	'Don\'t have balcony','Reserved'),
(888,	8080,	'1500',	'Single',	'have balcony','Open'),
(999,	9090,	'2500',	'Double',	'Don\'t have balcony','Reserved'),
(1111,	10101,	'1500',	'Single',	'Don\'t have balcony','Reserved');


CREATE TABLE Booking(
#Creating Booking Table
Booking_ID INT(10) PRIMARY KEY,
No_Of_Stay_Day INT(10) NOT NULL,
Total_Price VARCHAR(50) NOT NULL,
Payment_Status VARCHAR(50) NOT NULL,
Check_IN_Date DATE NOT NULL,
Check_Out_Date DATE NOT NULL,
CustomerCus_ID INT(10) NOT NULL,
RoomRoom_ID INT(10) NOT NULL,
StaffStaff_ID INT(10) NOT NULL,
FOREIGN KEY (CustomerCus_ID) REFERENCES Customer(Cus_ID),
FOREIGN KEY (RoomRoom_ID) REFERENCES Room(Room_ID),
FOREIGN KEY (StaffStaff_ID) REFERENCES Staff(Staff_ID)
);

INSERT INTO Booking (
#Inserting data into Booking Table
Booking_ID, No_Of_Stay_Day, Total_Price, Payment_Status, Check_In_Date, 
Check_Out_Date, CustomerCus_ID, RoomRoom_ID, StaffStaff_ID
)
VALUES
(123,	7, '17,500', 'Pending', '2022-04-21',	 '2022-04-28',	 1, 111, 101),
(234,	15,'22,500', 'Paid', '2022-05-02',	 '2022-05-17',	2,  222, 101),
(456,	21, '52,500','Pending', '2022-04-24',	 '2022-05-15',	 3, 444, 101),
(567,	12, '8,000', 'Pending','2022-05-12',	'2022-05-24',	 4, 555, 101),
(789,	10, '15,000', 'Paid', '2022-05-09', '2022-05-19',	5,  777, 101),
(912,	17, '42,500', 'Pending', '2022-04-27', '2022-04-14',   6, 999, 101),
(1234,	30, '45,000', 'Paid', '2023-06-01', '2023-07-01',	7, 1111, 101);


CREATE TABLE Credit_Card(
#Creating Credit_Card Table
CC_ID INT(10) PRIMARY KEY,
CC_Type VARCHAR(50) NOT NULL,
CC_NUmber VARCHAR(50) NOT NULL,
Name_On_Card VARCHAR(50) NOT NULL,
CustomerCus_ID INT(10) NOT NULL,
FOREIGN KEY (CustomerCus_ID) REFERENCES Customer(Cus_ID)
);

INSERT INTO Credit_Card(
#Inserting data into Credit_Card Table
CC_Type, CC_Number, Name_On_Card, CC_ID, CustomerCus_ID
)
VALUES
('VISA', '4024007113307606', 'Brody', 7645, 1),
('Mastercard', '5167643046551870', 'Andrew', 2587, 2),
('Amex', '349759069035542', 'Peter', 4587, 3),
( 'VISA', '4556531443487008', 'Krish', 1542, 4),
( 'VISA', '4532333266362031', 'Ken' ,5287, 5),
( 'Mastercard', '5202689840219096', 'Julia', 6654, 6),
( 'Mastercard', '5328173012741426', 'Sanaya', 5437, 7);


CREATE TABLE Billing(
#Creating Billing Table
Billing_ID INT(10) PRIMARY KEY,
Paid_Date DATE NOT NULL,
Total_Bill VARCHAR(50) NOT NULL,
Credit_CardCC_ID INT(10) NOT NULL,
BookingBooking_ID INT(10) NOT NULL,
FOREIGN KEY (Credit_CardCC_ID) REFERENCES Credit_Card(CC_ID),
FOREIGN KEY (BookingBooking_ID) REFERENCES Booking(Booking_ID)
);

INSERT INTO Billing(
#Inserting data into Billing Table
Billing_ID, Paid_Date, Total_Bill, Credit_CardCC_ID, BookingBooking_ID
)
VALUES
(2753, '2022-05-17', '22,500', 2587, 234),
(7845, '2022-05-17', '15,000', 5287, 789),
(6578, '2022-05-17', '17,500', 5437, 1234);
