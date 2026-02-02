# 🎵 Music Library Database API (Assignment 4 – SOLID & Advanced OOP)

## 📌 Project Overview
This project is a **Java-based Music Library Management API** developed as part of **Assignment 4**.  
It is a continuation and refactoring of **Assignment 3**, enhanced with **SOLID principles**, **advanced OOP concepts**, and a **clean layered architecture**.

The system allows managing music-related entities such as songs, podcasts, artists, and categories using a relational database and JDBC.

---

## 🎯 Learning Objectives
The main goals of this project are:
- Apply **SOLID principles** in a real Java application
- Strengthen **Object-Oriented Programming** design
- Implement **layered architecture**
- Use **advanced Java features** (generics, lambdas, reflection)
- Work with **JDBC and PostgreSQL**
- Practice clean Git workflow and documentation

---

## 🧱 Architecture Overview
The project follows a **strict layered architecture**:


### Layer Responsibilities
- **Controller**
  - Handles user input (CLI)
  - Delegates operations to service layer
  - Contains no business logic

- **Service**
  - Applies validation and business rules
  - Uses repository interfaces (DIP)
  - Throws custom exceptions

- **Repository**
  - Implements generic CRUD operations
  - Uses JDBC and PreparedStatements
  - Contains no business logic

- **Database**
  - PostgreSQL relational database
  - Foreign keys and constraints

---

## 🧩 SOLID Principles Applied

### 🔹 SRP (Single Responsibility Principle)
- Each class has one clear responsibility  
  (e.g. Controller handles input, Service handles logic, Repository handles DB access)

### 🔹 OCP (Open–Closed Principle)
- Abstract base classes allow adding new media types without modifying existing code

### 🔹 LSP (Liskov Substitution Principle)
- Subclasses (Song, Podcast) can be used via base class references safely

### 🔹 ISP (Interface Segregation Principle)
- Small, focused interfaces (`Playable`, `Downloadable`, `CrudRepository<T>`)

### 🔹 DIP (Dependency Inversion Principle)
- Service layer depends on repository **interfaces**, not implementations

---

## 🧠 OOP Design

### Abstract Base Class
- `Media` (abstract)
  - Shared fields: `id`, `title`
  - Abstract methods overridden by subclasses
  - Demonstrates polymorphism

### Subclasses
- `Song`
- `Podcast`

### Composition / Aggregation
- `Song → Artist`
- `Media → Category`

---

## ⚙️ Advanced Java Features Used

### ✔ Generics
```java
public interface CrudRepository<T> {
    void create(T entity);
    List<T> getAll();
    void delete(int id);
}
```


![OUTPUT](docs/Screenshots/1.png)
![Database Pgadmin CRUD](docs/Screenshots/2.png)
