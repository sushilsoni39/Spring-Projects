CREATE TABLE `bank`.`branch` (
BranchIFSC varchar(4) primary key,
name varchar(20),
type varchar(20),
address varchar(50)
);

CREATE TABLE customer(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    contactNo varchar(12),
    accountNumber varchar(8),
    PRIMARY KEY (id),
    FOREIGN KEY (accountNumber) REFERENCES account(accountNumber)
);

CREATE TABLE account(
AccountNumber varchar(20) not null,
Type varchar(20),
Balance double(20,2),
branchIFSC varchar(20),
primary key(AccountNumber),
foreign key(BranchIFSC) references Branch(branchIFSC)
);