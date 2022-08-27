CREATE TABLE Users(

userID INT PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(50) NOT NULL,
userName VARCHAR(20) NOT NULL,
password VARCHAR(50) NOT NULL,
userType Varchar(20)
)
INSERT INTO Users (userID, email, userName, password, userType)
VALUES(1, 'henry1@gmail.com', 'admin', 'admin', 'receptionist')


CREATE TABLE Customer(

cusID INT PRIMARY KEY AUTO_INCREMENT,
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
userID INT NOT NULL

)

CREATE TABLE Corporate(

corpID INT PRIMARY KEY AUTO_INCREMENT,
companyName VARCHAR(50) NOT NULL,
companyContact VARCHAR(20) NOT NULL,
userID INT NOT NULL

)

CREATE TABLE Administration(

adminID INT PRIMARY KEY AUTO_INCREMENT,
contact INT NOT NULL,
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
userID INT NOT NULL
)

INSERT INTO Administration (adminID, contact, firstName, lastName, userID)
VALUES (1, '984532157', 'Henry', 'smith', 1)

guestID INT PRIMARY KEY AUTO_INCREMENT,
fIrstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
dOB DATE NOT NULL,
country VARCHAR(20) NOT NULL,
state VARCHAR(50) NOT NULL,
city VARCHAR(50) NOT NULL,
postalCode INT NOT NULL,
checkInDate DATE NOT NULL,
checkOutDate DATE NOT NULL,
contact INT NOT NULL,
roomPreference VARCHAR(10) NOT NULL

)

CREATE TABLE Room(

roomNo INT PRIMARY KEY AUTO_INCREMENT,
roomType VARCHAR(50) NOT NULL,
pricePerNight VARCHAR(20) NOT NULL,
roomDetails VARCHAR(110) NOT NULL,
roomStatus VARCHAR(50) NOT NULL

)

CREATE TABLE CreditCard(

cardID INT PRIMARY KEY AUTO_INCREMENT,
cardType VARCHAR(50) NOT NULL,
cardNo VARCHAR(50) NOT NULL,
nameOnCard VARCHAR(50) NOT NULL,
cusID INT NOT NULL

)

CREATE TABLE Reservation(

reserveID INT PRIMARY KEY AUTO_INCREMENT,
bookingStatus VARCHAR(10) NOT NULL,
paymentStatus VARCHAR(10) NOT NULL,
noOfStayDay INT NOT NULL,
cusID INT NOT NULL,
adminID INT NOT NULL,
corpID INT NOT NULL,
roomNo INT NOT NULL,
guestID INT NOT NULL

)

CREATE TABLE Billing(

billID INT PRIMARY KEY AUTO_INCREMENT,
paidDate DATE NOT NULL,
totalBill VARCHAR(20) NOT NULL,
reserveID INT NOT NULL,
cardID INT NOT NULL

)