# 📚 Online Book Store - REST API  

## 🔹 Overview  
OnlineBookStore is a **Spring Boot-based REST API** that provides CRUD operations for managing books in an online bookstore. It includes **JWT authentication**, **MySQL database integration**, and **Swagger API documentation**.  

---

## 🚀 Features  
✅ **JWT Authentication** (Secure API access)  
✅ **CRUD operations** (Add, Get, Update, Delete books)  
✅ **Search books** by **title, author, category, or rating**  
✅ **MySQL Database integration** with JPA/Hibernate  
✅ **API documentation with Swagger UI** 🔗 [Swagger UI](http://localhost:8087/swagger-ui/index.html#/)  
✅ **Dockerized for easy deployment**  

---

## 🏗️ Tech Stack  
- **Backend**: Java, Spring Boot, Spring Security, Hibernate, JWT  
- **Database**: MySQL  
- **Tools**: Maven, Swagger, GitHub  

---

## 📦 Installation & Setup  

### 1️⃣ Clone the Repository  
```sh
git clone https://github.com/YOUR-GITHUB-USERNAME/OnlineBookStore.git
cd OnlineBookStore
```

### 2️⃣ Configure MySQL Database  
Update `application.properties` with your MySQL credentials:  
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/zynetic_db?useSSL=false
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### 3️⃣ Build & Run the Application  
```sh
mvn clean install
mvn spring-boot:run
```
The server will start at: **http://localhost:8087**  

### 4️⃣ Access API Documentation (Swagger UI)  
🔗 Open **[Swagger UI](http://localhost:8087/swagger-ui/index.html#/) in your browser**  

---

## 📌 API Endpoints  

### 🔑 Authentication  
- **`POST /auth/signUp`** → Register a new user  
- **`POST /auth/login`** → Login and get JWT token  

### 📖 Book Management  
- **`POST /books`** → Add a new book  
- **`GET /books`** → Get all books  
- **`GET /books/{id}`** → Get a book by ID  
- **`PUT /books/{id}`** → Update a book by ID  
- **`DELETE /books/{id}`** → Delete a book by ID  

### 🔍 Search Books  
- **`GET /books/search?title=BookTitle`** → Search by title  
- **`GET /books/search?author=AuthorName`** → Search by author  
- **`GET /books/search?category=Category`** → Search by category  
- **`GET /books/search?rating=4.5`** → Search by rating  

---

## 📜 License  
This project is **open-source** and available under the **MIT License**.  

---

