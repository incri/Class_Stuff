
CREATE TABLE Registered_Accounts(
Account_ID INT(10) PRIMARY KEY,
Account_UserName VARCHAR(50) NOT NULL,
Account_EmailAddress VARCHAR(50) NOT NULL,
Account_Password VARCHAR(50) NOT NULL,
CreditCard_Type VARCHAR(25),
CreditCard_Number VARCHAR(25),
Name_On_Card VARCHAR(50),
Security_Code INT(10)
);

CREATE TABLE Customer (
Cus_ID INT(10) PRIMARY KEY,
Cus_FirstName VARCHAR(50) NOT NULL,
Cus_LastName VARCHAR(50) NOT NULL,
Cus_Address VARCHAR(110) NOT NULL,
Cus_Contact VARCHAR(20) NOT NULL,
Cus_DOB date NOT NULL,
RA_Account_ID INT(10) NOT NULL,
FOREIGN KEY (RA_Account_ID) REFERENCES Registered_Accounts(Account_ID)
);

CREATE TABLE Hotel_Administrator (
Admin_ID INT(10) PRIMARY KEY,
Admin_FirstName VARCHAR(50) NOT NULL,
Admin_LastName VARCHAR(50) NOT NULL,
Admin_COntact VARCHAR(20) NOT NULL,
Admin_Permissions VARCHAR(110) NOT NULL,
RA_Account_ID INT(10) NOT NULL,
FOREIGN KEY (RA_Account_ID) REFERENCES Registered_Accounts(Account_ID)
);


CREATE TABLE Hotel_Personnel (
HP_ID INT(10) PRIMARY KEY,
HP_FirstName VARCHAR(50) NOT NULL,
HP_LastName VARCHAR(50) NOT NULL,
HP_COntact VARCHAR(20) NOT NULL,
HP_Permissions VARCHAR(110) NOT NULL,
RA_Account_ID INT(10) NOT NULL,
FOREIGN KEY (RA_Account_ID) REFERENCES Registered_Accounts(Account_ID),
HA_Admin_ID INT(10) NOT NULL,
FOREIGN KEY (HA_Admin_ID) REFERENCES Hotel_Administrator(Admin_ID)
);

CREATE TABLE Hotel_Room(
Room_ID INT(10) PRIMARY KEY,
Room_status BOOL NOT NULL,
Primary_Services VARCHAR(200) NOT NULL,
Secondary_Services VARCHAR(200) NOT NULL,
Room_Price INT(10) NOT NULL,
Room_Type INT(10) NOT NULL
);

CREATE TABLE Reservation_Data(
Reserve_ID INT(10) PRIMARY KEY,
Check_IN_Date DATE NOT NULL,
Check_Out_Date DATE NOT NULL,
Room_Preference INT(10) NOT NULL,
RA_Account_ID INT(10) NOT NULL,
FOREIGN KEY (RA_Account_ID) REFERENCES Registered_Accounts(Account_ID),
HR_Room_ID INT(10) NOT NULL,
FOREIGN KEY (HR_Room_ID) REFERENCES Hotel_Room(Room_ID)
);

INSERT INTO Registered_Accounts(
Account_ID, Account_UserName, Account_EmailAddress, 
Account_Password, CreditCard_Type, CreditCard_Number, 
Name_On_Card, Security_Code)
VALUES
(1001, 'bwilliams', 'bwilliams@gmail.com', 'bwilliams123%', 'VISA', '4024007113307606', 'Brody', 7645),
(1002, 'abrown', 'abrown@gmail.com', 'abrown123%', 'Mastercard', '5167643046551870', 'Andrew', 2587),
(1003, 'psmith', 'psmith@gmail.com', 'psmith123%', 'Amex', '349759069035542', 'Peter', 4587),
(1004, 'kevans', 'kevans@gmail.com', 'kevans123%', 'VISA', '4556531443487008', 'Krish', 1542),
(1005, 'ssmith', 'ssmith@gmail.com', 'ssmith123%', 'Amex', '370400965943354', 'Sam', 6985),
(1006, 'kJones', 'kJones@gmail.com', 'kJones123%', 'VISA', '4532333266362031', 'Ken' ,5287),
(1007, 'jbrown', 'jbrown@gmail.com', 'jbrown123%', 'Mastercard', '5202689840219096', 'Julia', 6654),
(1008, 'jtaylor', 'jtaylor@gmail.com', 'jtaylor123%', 'Amex', '378438408567465', 'Jenet', 2384),
(1009, 'rwilliams', 'rwilliams@gmail.com', 'rwilliams123%', 'VISA','4252726987186985', 'Ruby', 1595),
(1010, 'sgreen', 'sgreen@gmail.com', 'sgreen123%', 'Mastercard', '5328173012741426', 'Sanaya', 5437);

INSERT INTO Registered_Accounts(
Account_ID, Account_UserName, Account_EmailAddress, Account_Password)
VALUES
(1000,	'ataylor',	'ataylor@gmail.com',	'ataylor123%'),
(1100,	'ssmith1',	'ssmith@gmail.com',	'ssmith123%'),
(1200,	'jbrown',	'jbrown@gmail.com',	'jbrown123%'),
(1300,	'pevans',	'pevans@gmail.com',	'pevans123%'),
(1400,	'bjones',	'bjones@gmail.com',	'bjones123%');

INSERT  INTO Customer(
Cus_ID, Cus_FirstName, Cus_LastName, Cus_Address, Cus_Contact, Cus_DOB, RA_Account_ID
)
VALUES
(1,	'Brody',	'Williams',	'Baltasound-68 Ballifeary Road',	'079 2556 3181',	'1996-08-20', 1001),
(2,	'Andrew',	'Brown',	'Wilby-68 Ramsgate Rd',	'079 5528 4239',	'1979-03-10', 1002),
(3,	'Peter',	'Smith',	'Underriver-95 Helland Bridge',	'079 7622 4215',	'1988-09-08', 1003),
(4,	'Krish',	'Evans',	'Nonington-25 Cambridge Road',	'079 7622 6544',	'1980-09-05', 1004),
(5,	'Sam',	'Smith',	'Whitecroft-79 Earls Avenue',	'079 2122 5487',	'1989-02-07', 1005),
(6,	'Ken',	'Jones',	'Wilby-68 Ramsgate Rd',	'079 4457 5477',	'1959-08-28', 1006),
(7,	'Julia',	'Brown',	'Frith Bank-61 Golden Knowes Road',	'079 5547 6621',	'1976-03-24', 1007),
(8,	'Jenet',	'Taylor',	'Nonington-25 Cambridge Road',	'079 5877 6645',	'1997-05-02', 1008),
(9,	'Ruby',	'Williams',	'Baltasound-68 Ballifeary Road',	'079 2122 2211',	'1971-04-23', 1009),
(10,'Sanaya',	'Green',	'Underriver-95 Helland Bridge',	'079 1754 6847',	'1979-11-07', 1010);

INSERT INTO Hotel_Administrator (
Admin_ID, Admin_FirstName, Admin_LastName, Admin_Contact, Admin_Permissions, RA_Account_ID
) 
VALUES
(101,	'Andrew',	'Taylor',	'079 2192 5767',	'Read,Approve and update, reservations', 1000);

INSERT INTO Hotel_Personnel (
HP_ID, HP_FirstName, HP_LastName, HP_Contact, HP_Permissions, RA_Account_ID, HA_Admin_ID
)
VALUES
(110,	'Sanaya',	'Smith',	'079 5242 4677',	'Read reservations data', 1100, 101),
(210,	'Julia',	'Brown',	'079 4576 8745',	'Read and Approve reservation data', 1200, 101),
(310,	'Peter',	'Evans',	'079 1478 6321',	'Read reservations data', 1300, 101),
(410,	'Brody',	'Jones',	'079 5478 6654',	'Read reservations data', 1400, 101);
CREATE TABLE Reservation_Data(
Reserve_ID INT(10) PRIMARY KEY,
Check_IN_Date DATE NOT NULL,
Check_Out_Date DATE NOT NULL,
Room_Preference INT(10) NOT NULL,
RA_Account_ID INT(10) NOT NULL,
FOREIGN KEY (RA_Account_ID) REFERENCES Registered_Accounts(Account_ID),
HR_Room_ID INT(10) NOT NULL,
FOREIGN KEY (HR_Room_ID) REFERENCES Hotel_Room(Room_ID)
);
INSERT INTO Hotel_Room (
Room_ID, Room_Status, Primary_Services, Secondary_services, Room_Price, Room_Type
)
VALUES
(111,	1,	'AC/TV',	'Swimming Pool, Bar',	2000, 1),
(222,	0,	'AC',	'Swimming Pool',	1500,	1),
(333,	1,	'TV',	'Swimming Pool, Bar',	2500,	2),
(444,	1,	'AC/TV',	'Spa, Swimming Pool, Bar',	3500,	2),
(555,	0,	'AC',	'Spa, Swimming Pool, Bar',	3000,	2),
(666,	0,	'TV',	'Swimming Pool',	1200,	1),
(777,	1,	'AC/TV',	'Swimming Pool, Bar',	2000,	1),
(888,	0,	'AC',	'Spa, Swimming Pool, Bar',	3000,	2),
(999,	1,	'AC/TV',	'Spa, Swimming Pool, Bar',	3500,	2),
(1111,	0,	'TV',	'Swimming Pool',	1200,	1);

INSERT INTO Reservation_Data (
Reserve_ID, Check_In_Date, Check_Out_Date, Room_Preference, RA_Account_ID, HR_Room_ID
)
VALUES
(123,	'2022-04-21',	'2022-05-13',	1, 1001, 111),
(234,	'2022-05-02',	'2022-05-25',	1, 1002, 222),
(345,	'2023-05-01',	'2023-05-18',	2, 1003, 333),
(456,	'2022-04-24',	'2022-05-01',	2, 1004, 444),
(567,	'2022-05-12',	'2022-06-01',	2, 1005, 555),
(678,	'2022-04-10',	'2022-04-27',	1, 1006, 666),
(789,	'2022-05-09',	'2022-05-19',	1, 1007, 777),
(891,	'2023-05-12',	'2023-05-30',	2, 1008, 888),
(912,	'2022-04-27',	'2022-05-20',	2, 1009, 999),
(1234,	'2023-06-01',	'2023-06-22',	1, 1010, 1111);
