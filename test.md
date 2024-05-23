CREATE TABLE Suppliers (
    SupplierID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    PhoneNumber VARCHAR(100),
    Address VARCHAR(255),
    TypeOfFarmer VARCHAR(255),
    DateOfJoining DATE,
    BankNameOfCustomer VARCHAR(255),, 
    BankingAccountNumber , 
    BankTypeOfAccount VARCHAR(255),, 
    BankIFSCCode VARCHAR(255),, 
    BankNameOfBank VARCHAR(255),,
    BankNameOfBranch VARCHAR(255),, 
    BankLocation VARCHAR(255),
);


CREATE TABLE SupplyDetails (
    SupplyID INT PRIMARY KEY AUTO_INCREMENT,
    SupplierID INT,
    SupplyDate DATE,
    MorningSupplyMilkAmt DECIMAL(10, 2),
    MorningSupplyFatAmt DECIMAL(10, 2),
    EveningSupplyMilkAmt DECIMAL(10, 2),
    EveningSupplyFatAmt DECIMAL(10, 2),
    RatePerLiter DECIMAL(10, 2), 
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID)
);


CREATE TABLE Payments (
    PaymentID INT PRIMARY KEY AUTO_INCREMENT,
    SupplierID INT,
    PaymentDate DATE,
    AmountPaid DECIMAL(10, 2),
    AmountOwed DECIMAL(10, 2),
    MOdeOfPayment VARCHAR(255),
    PaymentRef VARCHAR(255),
    Remarks VARCHAR(255),
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID)
);