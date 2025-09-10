# 🎓 Student Management API

A RESTful API built with **Java, Spring Boot, and Spring Data JPA** for managing student records.  
This project demonstrates how to perform **CRUD operations** (Create, Read, Update, Delete) on student data with proper API endpoints, database integration, and clean architecture.

---

## 📌 Features
- Add new student records  
- Retrieve all students  
- Retrieve student by ID  
- Update student information  
- Partially update student fields  
- Delete student by ID  
- Delete all students  
- Integrated with **MySQL Database**  

---

## 🛠️ Tech Stack
- **Java 17+**  
- **Spring Boot**  
- **Spring Data JPA / Hibernate**  
- **MySQL**  
- **Postman** (for API testing)  
- **Maven**  

---

## 🚀 API Endpoints

| Method | Endpoint         | Description                  |
|--------|------------------|------------------------------|
| POST   | `/students`      | Add a new student            |
| GET    | `/students`      | Get all students             |
| GET    | `/students/{id}` | Get student by ID            |
| PUT    | `/students/{id}` | Update student (full)        |
| PATCH  | `/students/{id}` | Update student (partial)     |
| DELETE | `/students/{id}` | Delete student by ID         |
| DELETE | `/students`      | Delete all students          |

---

## 📂 Project Structure
![Project Structure](https://drive.google.com/uc?id=1qw1qhtG9wlG3l17VAdcOrAWLtDrT6NSX)

---

## 🖼️ Project Outputs

### 1️⃣ Code Execution  
![Code Output 1](./outputs/1.png)  
![Code Output 2](./outputs/2.png)  

### 2️⃣ Postman API Testing  
- **Add Student**  
  ![Add Student](./outputs/addStudents.png)  

- **Get All Students**  
  ![Get Students](./outputs/getStudent.png)  

- **Get Student By ID**  
  ![Get Student By ID](./outputs/getStudentById.png)  

- **Delete Student**  
  ![Delete Student](./outputs/deleteStudent.png)  

- **Update Student**  
  ![Update Student](./outputs/updateStudent.png)  

- **Partial Update**  
  ![Partial Update](./outputs/partialUpdate.png)  

- **Delete All Students**  
  ![Delete All](./outputs/deleteAllStudents.png)  

- **Get Students After Delete**  
  ![After Delete Get Students](./outputs/afterDeleteGetStudents.png)  

### 3️⃣ Database Screenshot  
- **MySQL Database View**  
  ![Students Database](./outputs/StudentsDataBase.png)  

---

## ⚙️ Configure Database (MySQL)

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
