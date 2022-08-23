CREATE TABLE Users(

userID INT PRIMARY KEY,
email VARCHAR(50) NOT NULL,
userName VARCHAR(20) NOT NULL,
password VARCHAR(50) NOT NULL

)

CREATE TABLE Customer(

cusID INT PRIMARY KEY,
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
dOB DATE NOT NULL,
userID INT NOT NULL,
FOREIGN KEY (userID) REFERENCES Users(userID)

)

CREATE TABLE Corporate(

corpID INT PRIMARY KEY,
companyName VARCHAR(50) NOT NULL,
companyContact INT NOT NULL,
userID INT NOT NULL,
FOREIGN KEY (userID) REFERENCES Users(userID)

)

CREATE TABLE Administration(

adminID INT PRIMARY KEY,
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
contact INT NOT NULL,
role VARCHAR(20) NOT NULL,
userID INT NOT NULL,
FOREIGN KEY (userID) REFERENCES Users(userID)

)

CREATE TABLE GuestData(

guestID INT PRIMARY KEY,
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

roomNo INT PRIMARY KEY,
roomType VARCHAR(50) NOT NULL,
pricePerNight VARCHAR(20) NOT NULL,
roomDetails VARCHAR(110) NOT NULL,
roomStatus VARCHAR(50) NOT NULL

)

CREATE TABLE CreditCard(

cardID INT PRIMARY KEY,
cardType VARCHAR(50) NOT NULL,
cardNo VARCHAR(50) NOT NULL,
nameOnCard VARCHAR(50) NOT NULL,
cusID INT NOT NULL,
FOREIGN KEY (cusID) REFERENCES Customer(cusID)

)

CREATE TABLE Reservation(

reserveID INT PRIMARY KEY,
bookingStatus VARCHAR(10) NOT NULL,
paymentStatus VARCHAR(10) NOT NULL,
noOfStayDay INT NOT NULL,
cusID INT NOT NULL,
adminID INT NOT NULL,
corpID INT NOT NULL,
roomNo INT NOT NULL,
guestID INT NOT NULL,
FOREIGN KEY (cusID) REFERENCES Customer(cusID),
FOREIGN KEY (adminID) REFERENCES Administration(adminID),
FOREIGN KEY (corpID) REFERENCES Corporate(corpID),
FOREIGN KEY (roomNo) REFERENCES Room(roomNo),
FOREIGN KEY (guestID) REFERENCES GuestData(guestID)

)

CREATE TABLE Billing(

billID INT PRIMARY KEY,
paidDate DATE NOT NULL,
totalBill VARCHAR(20) NOT NULL,
reserveID INT NOT NULL,
cardID INT NOT NULL,
FOREIGN KEY (reserveID) REFERENCES Reservation(reserveID),
FOREIGN KEY (cardID) REFERENCES CreditCard(cardID)

)