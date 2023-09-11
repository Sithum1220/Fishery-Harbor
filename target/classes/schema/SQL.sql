drop database fishery_Harbour_Management;
CREATE DATABASE fishery_Harbour_Management;

USE fishery_Harbour_Management;

CREATE TABLE employee(
                         employee_Id VARCHAR(20) PRIMARY KEY,
                         email VARCHAR(20) UNIQUE NOT NULL,
                         first_Name VARCHAR(20) NOT NULL,
                         last_Name VARCHAR(20) NOT NULL,
                         contact_No VARCHAR(30) UNIQUE NOT NULL,
                         nic VARCHAR(30) UNIQUE NOT NULL,
                         password VARCHAR(30),
                         user_Name VARCHAR(30) UNIQUE,
                         role VARCHAR(30) NOT NULL,
                         house_No VARCHAR(30),
                         street VARCHAR(30) NOT NULL,
                         city VARCHAR(30) NOT NULL
);


CREATE TABLE attendance(
                           time TIME NOT NULL,
                           date DATE NOT NULL,
                           employee_Id VARCHAR(20),
                           FOREIGN KEY(employee_Id) REFERENCES employee(employee_Id) on Delete Cascade on Update Cascade
);


CREATE TABLE owner(
                      owner_Id VARCHAR(20) PRIMARY KEY,
                      email VARCHAR(20) UNIQUE NOT NULL,
                      first_Name VARCHAR(20) NOT NULL,
                      last_Name VARCHAR(20) NOT NULL,
                      owner_Role VARCHAR(20) NOT NULL,
                      contact_No VARCHAR(30) UNIQUE NOT NULL,
                      nic VARCHAR(30) UNIQUE NOT NULL,
                      House_No VARCHAR(30),
                      street VARCHAR(30) NOT NULL,
                      city VARCHAR(30) NOT NULL,
                      time TIME NOT NULL,
                      date DATE NOT NULL
);


CREATE TABLE rent(
                     rent_Id VARCHAR(20) PRIMARY KEY,
                     rent_Type VARCHAR(20) NOT NULL,
                     fee  VARCHAR(20) NOT NULL,
                     date DATE NOT NULL,
                     time TIME NOT NULL,
                     owner_Id VARCHAR(20),
                     FOREIGN KEY(owner_Id) REFERENCES owner (owner_Id ) on Delete Cascade on Update Cascade
);


CREATE TABLE boat(
                     boat_Id VARCHAR(20) PRIMARY KEY,
                     boat_Name VARCHAR(30) NOT NULL,
                     boat_Type VARCHAR(20) NOT NULL,
                     owner_Id VARCHAR(20),
                     FOREIGN KEY(owner_Id) REFERENCES owner (owner_Id ) on Delete Cascade on Update Cascade
);


CREATE TABLE tax(
                    tax_Id VARCHAR(6) PRIMARY KEY,
                    date DATE NOT NULL,
                    fee VARCHAR(10) NOT NULL,
                    tax_Type VARCHAR(10) NOT NULL,
                    time VARCHAR(10) NOT NULL,
                    boat_Id VARCHAR(20),
                    FOREIGN KEY(boat_Id) REFERENCES boat (boat_Id ) on Delete Cascade on Update Cascade
);


CREATE TABLE boat_Employee(
                              boat_Employee_Id VARCHAR(20) PRIMARY KEY,
                              role VARCHAR(30) NOT NULL,
                              nic VARCHAR(30) UNIQUE NOT NULL,
                              contact_No VARCHAR(20) UNIQUE NOT NULL,
                              first_Name VARCHAR(30) NOT NULL,
                              Last_Name VARCHAR(30) NOT NULL,
                              house_No VARCHAR(20),
                              street VARCHAR(20) NOT NULL,
                              city VARCHAR(20) NOT NULL,
                              boat_Id VARCHAR(20),
                              FOREIGN KEY(boat_Id) REFERENCES boat (boat_Id ) on Delete Cascade on Update Cascade
);



CREATE TABLE boat_Journey(
                             boat_Manage_Id VARCHAR(20) PRIMARY KEY,
                             departure_Date DATE NOT NULL,
                             arrival_Date DATE NOT NULL,
                             departure_Time VARCHAR(30) NOT NULL,
                             arrival_Time VARCHAR(30) NOT NULL,
                             boat_Id VARCHAR(20),
                             FOREIGN KEY(boat_Id) REFERENCES boat (boat_Id ) on Delete Cascade on Update Cascade
);


CREATE TABLE `order`(
                        order_Id VARCHAR(20) PRIMARY KEY,
                        item_Type VARCHAR(20) NOT NULL,
                        date DATE NOT NULL,
                        time TIME NOT NULL,
                        ordered_Qty VARCHAR(20) NOT NULL,
                        owner_Id VARCHAR(20),
                        FOREIGN KEY(owner_Id) REFERENCES owner (owner_Id ) on Delete Cascade on Update Cascade
);


CREATE TABLE item_Stock(
                           item_Code VARCHAR(20) PRIMARY KEY,
                           description VARCHAR(20) NOT NULL,
                           qty_On_Hand INT NOT NULL,
                           unit_Price DECIMAL NOT NULL
);


CREATE TABLE order_Detail(
                             payment DECIMAL NOT NULL,
                             order_Id VARCHAR(20),
                             item_Code VARCHAR(20),
                             FOREIGN KEY(order_Id) REFERENCES `order` (order_Id ) on Delete Cascade on Update Cascade,
                             FOREIGN KEY(item_Code) REFERENCES item_Stock (item_Code ) on Delete Cascade on Update Cascade
);


CREATE TABLE supplier_order(
                               supplier_Order_Id VARCHAR(20) PRIMARY KEY,
                               item_Type VARCHAR(20) NOT NULL,
                               ordered_Qty INT NOT NULL,
                               time TIME NOT NULL,
                               date DATE NOT NULL
);



CREATE TABLE supplier_Order_Detail(
                                      item_Code VARCHAR(20),
                                      payment DECIMAL NOT NULL,
                                      order_Id VARCHAR(20),
                                      FOREIGN KEY(order_Id) REFERENCES `order` (order_Id ) on Delete Cascade on Update Cascade,
                                      FOREIGN KEY(item_Code) REFERENCES item_Stock (item_Code ) on Delete Cascade on Update Cascade
);



CREATE TABLE supplier(
                         supplier_Id VARCHAR(20) PRIMARY KEY,
                         company_Name VARCHAR(20) NOT NULL,
                         company_Email VARCHAR(20) UNIQUE NOT NULL,
                         contact_No VARCHAR(20) UNIQUE NOT NULL,
                         location VARCHAR(20) NOT NULL
);




