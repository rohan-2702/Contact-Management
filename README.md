# 📇 Contact Management System

A simple, user-friendly **Contact Management System** built with **Spring Boot**, **PostgreSQL**, and **Thymeleaf**. This application allows users to efficiently add, view, edit, and delete contacts with real-time validation for duplicate entries.

---

## 🚀 Features

- **Add Contacts**: Save details like name, email, phone number, company, and job title.
- **View Contacts**: Browse all contacts in a responsive, paginated table.
- **Edit Contacts**: Update existing contact information.
- **Delete Contacts**: Remove outdated or duplicate entries.
- **Validation**: Ensure that each contact has a unique email address.

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot, Hibernate
- **Frontend**: Thymeleaf, Bootstrap
- **Database**: PostgreSQL
- **Build Tool**: Maven

---

## ⚙️ Steps to Run the Project

### Prerequisites

1. Install **Java** (JDK 21+ is recommended).  
2. Install **PostgreSQL**.  
3. Install **Maven**.  

---

### Setup Instructions

1. **Clone the Repository**  
   ```bash
   git clone https://github.com/yourusername/ContactManagement.git
   cd ContactManagement
   ```
2. **Set Up the Database**  
 - Create a PostgreSQL database named contact_management.
 - Run the following script to create the required table:
    ```bash
    CREATE TABLE contacts (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    company VARCHAR(100),
    job_title VARCHAR(100)
    );
    ```
3. **Configure Application Properties**
  - Update src/main/resources/application.properties with your database credentials:
    ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/contact_management
    spring.datasource.username=your_database_username
    spring.datasource.password=your_database_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
4. **Build and Run the Project**
  - Use Maven to build and run the application:
    ```bash
     mvn spring-boot:run
    ```
5.  **Access the Application**
   - Add Contact: http://localhost:8080/contacts/add
   - View Contacts: http://localhost:8080/contacts

---

## 🚧 Challenges and Solution

1. **Duplicate Email Validation**
- Challenge: Prevent saving contacts with the same email address.
- Solution: Validated email uniqueness in the service layer and used Bootstrap alerts to display error messages on the UI.

2. **User-friendly UI**
- Challenge: Create an intuitive and responsive interface.
- Solution: Integrated Thymeleaf with Bootstrap components for a seamless user experience.

---

## 🧑‍💻 Author
  **ROHAN CHINTALWAR**
- Email: rohanchintalwar27@gmail.com
- GitHub: https://github.com/rohan-2702



