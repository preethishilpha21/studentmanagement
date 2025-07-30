\# Student Management System



A Spring Boot application that manages students, courses, and departments using relational database structure and entity relationships.



\## 📚 Features



\- Add, view, update, and delete Students, Courses, and Departments

\- Handles relationships:

&nbsp; - Many-to-One: Students → Departments

&nbsp; - One-to-Many: Departments → Students

&nbsp; - Many-to-Many: Students ↔ Courses

\- Uses DTOs to transfer data between layers

\- RESTful APIs built using Spring Boot

\- Connected to MySQL database

\- Follows clean architecture: Controller → Service → Repository



\## ⚙️ Technologies Used



\- Java 21

\- Spring Boot

\- MySQL

\- Maven

\- Postman (for API testing)

\- IntelliJ IDEA



\## 🚀 How to Run



1\. Clone the repository

2\. Configure MySQL in `application.properties`

3\. Run the application

4\. Use Postman or any REST client to test the endpoints



\## 💡 Note



\- Ensure MySQL is running before starting the app

\- Database schema is auto-created using JPA/Hibernate



