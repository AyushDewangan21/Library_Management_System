# Library_Management_System
📚 E-Library Management System (Spring Boot + Spring Security + JPA + Thymeleaf)

A secure and fully functional E-Library Web Application built using Spring Boot, designed for users to browse, purchase, read, and manage books online.
This project demonstrates robust backend development, clean architecture, secure authentication, and a dynamic UI powered by Thymeleaf.

🚀 Features
🔐 1. Secure Authentication & Authorization

Login & Signup with Spring Security

BCrypt password hashing

Role-based access control (USER / ADMIN ready)

Session-based authentication

📚 2. Browse & Purchase Books

Users can view all available books in the Shop

Buy books with a single click (/buy/{id})

Books are mapped to users using @ManyToMany relationship

📖 3. Read Purchased Books

Users can read the full content of purchased books

Rendering content dynamically using Thymeleaf

📘 4. Manage My Books

View all purchased books in My Books

Remove any purchased book (/myBooks/remove/{id})

Sorted and dynamically displayed tables

🎨 5. Dynamic UI with Thymeleaf

Clean, responsive UI built with HTML + CSS + Thymeleaf

Dynamic server-side rendering with Model attributes

Unified theme across Dashboard, Shop, and MyBooks

🏗️ 6. Scalable MVC Architecture

Organized into:

Controller Layer

Service Layer

Repository Layer

Entity Layer

Ensures clean code, easy maintenance, and future extensibility.

🛠️ Tech Stack
Backend

Java 17/21

Spring Boot

Spring Security

Spring MVC

Spring Data JPA

Hibernate

Frontend

Thymeleaf

HTML5

CSS3

Database

MySQL

JPA repositories for database operations

Utilities

Lombok (to reduce boilerplate code)

Embedded Tomcat (default Spring Boot server)

🗄️ Database Schema Overview
User Entity

id

name

email

password (BCrypt encrypted)

purchasedBooks → @ManyToMany List<Book>

Book Entity

id

bookName

content

price

🔧 Key Functional Endpoints
User Actions
Endpoint	Description
/login	User login
/signup	User registration
/shop	Browse all books
/buy/{id}	Purchase a book
/myBooks	Show purchased books
/myBooks/read/{id}	Read purchased book
/myBooks/remove/{id}	Remove book from purchases
/logout	Logout


💡 What This Project Demonstrates

Secure authentication using Spring Security

Expertise in backend development

Clean MVC architecture

Handling real-world features like purchase, remove, and read functionality

Building relational models with JPA/Hibernate

Dynamic UI integration using Thymeleaf

Clean coding practices and maintainable structure

📌 Future Enhancements

Admin Dashboard (Add/Edit/Delete Books)

Book categories & search

Book cover images

Reviews & ratings

Cart system before purchase

Pagination for large book lists
