# CLEVERX Library Manager

A simple yet powerful library management system developed using Java OSGI Micro Kernel Architecture. :fallen_leaf:

#### Introduction

The CleverX Library Management System is a simple and a powerful software
solution that provides a set of functionalities to manage all necessary tasks related
to a library. Services such as registering staff as well as members, saving and
updating books information, monitoring books issued, assisting staff members to
track overdue books and much more made easy with CleverX Library Manager.
The CleverX Library Manager was developed using Java Swing enhancing user
interfaces and experience. All data and information are saved to a relational
database(MYSQL) thereby data loss is completely prevented.

#### Description

The software architecture of the CleverX Library Manager consist of eight components
developed using OSGI Micro Kernel Architecture deployed using Eclipse Equinox. System
consist of four publishers to manage Books, Members, Staff and Issue Books. The library
publisher (Core system) will consume all the above four publishers and the Library consumer
(Service consumer) will consume the library publisher. The relational database publisher
(DBpublisher) will be used by all the four main service plugin modules and then the
com.mysql.jdbc service will be consumed by the DBPublisher in order to connect to mysql-jdbc.
Design patterns such as singleton and facades are used to perform complex functionalities which
hides the chained implementation from the user. Four main service plugins were developed using
interfaces, Abstraction, Inheritance, Polymorphism and other object oriented concepts in java.
Separation of Data access logic (Crud operation) and Business logic in individual bundles. Java
Swing were used to develop simple and powerful user interfaces to enhance the user experience.
<br/><br/>
Below is the component diagram of the CleverX Library Manager.

![LibraryManagementArchetecture](https://user-images.githubusercontent.com/63389716/115281593-d065ca00-a166-11eb-8f04-5cddbd5f6d91.png)



#### Technologies

1. OSGI Micro Kernel Architecture
2. Service plugins were developed using interfaces, Abstraction, Inheritance, Polymorphism and other object oriented concepts in java.
3. Separation of Data access logic (Crud operation) and Business logic in Service bundles.
4. Simple graphical user interfaces developed using Java Swing. :evergreen_tree:
5. Mysql JDBC implementation.
6. Using design paterns such as Singleton and Facades. :robot:

### Installation

Run the LibraryConsumer as an OSGI project. 

### OSGI Bundles

![13](https://user-images.githubusercontent.com/63389716/115075699-1cbbca80-9f19-11eb-97f9-6706285320b7.png)
<br/><br/>
#### OSGI bundle stop
<br/><br/>
![11](https://user-images.githubusercontent.com/63389716/115076552-580ac900-9f1a-11eb-8f94-bb9f3859cd7c.png)
<br/><br/>
![12](https://user-images.githubusercontent.com/63389716/115076535-53461500-9f1a-11eb-854f-01d1e58f7a87.png)
<br/>

<br/>

### UI (Screenshots)
![1](https://user-images.githubusercontent.com/63389716/115076410-2691fd80-9f1a-11eb-9103-a04f80a6b543.png)
![2](https://user-images.githubusercontent.com/63389716/115076347-111cd380-9f1a-11eb-9e93-56e09fe3b3ca.png)
![3](https://user-images.githubusercontent.com/63389716/115076365-167a1e00-9f1a-11eb-8c10-a1361ea9dbac.png)
![4](https://user-images.githubusercontent.com/63389716/115076370-18dc7800-9f1a-11eb-9b21-b09d407c9618.png)
![5](https://user-images.githubusercontent.com/63389716/115076378-1b3ed200-9f1a-11eb-9441-bc1ba1e6693c.png)
![6](https://user-images.githubusercontent.com/63389716/115076385-1d089580-9f1a-11eb-8d9f-b34ab2a8355d.png)
![7](https://user-images.githubusercontent.com/63389716/115076389-1ed25900-9f1a-11eb-9c33-0c9c998405fe.png)
![8](https://user-images.githubusercontent.com/63389716/115076395-209c1c80-9f1a-11eb-9e47-d2aea4f7651e.png)
![9](https://user-images.githubusercontent.com/63389716/115076400-2265e000-9f1a-11eb-99d8-33d0ed1c350a.png)
![10](https://user-images.githubusercontent.com/63389716/115076401-24c83a00-9f1a-11eb-9630-415ea0cf6c3c.png)
