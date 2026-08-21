# 📚 Java JDBC Library Management System

A small learning project built with **Java, JDBC and PostgreSQL** to practice backend fundamentals and understand how a Java application communicates with a relational database.

The main goal of this project was not to build a production-ready library system, but to understand the complete flow of data through different application layers.

## 🛠 Technologies

* Java 21
* JDBC
* PostgreSQL
* Maven

## 🧱 Architecture

The project follows a simple layered structure:

```text
Main
  ↓
Service
  ↓
Repository
  ↓
JDBC
  ↓
PostgreSQL
```

### `Libro`

Represents a book inside the Java application and contains the logic related to the state of a book.

### `LibroService`

Coordinates application scenarios such as:

* creating a book;
* borrowing books;
* returning books;
* obtaining books;
* updating books;
* deleting books.

### `LibroRepository`

Handles communication with PostgreSQL through JDBC.

It contains the database operations used by the application.

## ✅ Implemented functionality

The project currently supports:

* Create a new book
* Get all books
* Find a book by ID
* Update book data
* Delete a book
* Borrow a selected quantity of books
* Return books
* Basic validation
* Exception handling

## 🗄 Database operations

The project uses the main CRUD operations:

```sql
SELECT
INSERT
UPDATE
DELETE
```

JDBC concepts practiced in the project include:

* `Connection`
* `PreparedStatement`
* `ResultSet`
* `executeQuery()`
* `executeUpdate()`
* parameterized SQL queries
* affected rows validation
* mapping SQL records to Java objects

## 🗃 PostgreSQL table

The project uses a `books` table similar to:

```sql
CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(150) NOT NULL,
    quantity INTEGER NOT NULL CHECK (quantity >= 0)
);
```

The book ID is generated automatically by PostgreSQL using `BIGSERIAL`.

## 🔐 Database password

Database credentials are not stored directly in the source code.

The application reads the PostgreSQL password from an environment variable:

```java
System.getenv("DB_PASSWORD");
```

On Windows, for example:

```powershell
setx DB_PASSWORD "your_password"
```

After creating the environment variable, restart the terminal or IDE before running the application.

## ▶️ Running the project

You need:

* Java 21
* Maven
* PostgreSQL
* a PostgreSQL database named `libreria_db`

Create the `books` table using the SQL shown above and configure your PostgreSQL connection.

Then run the application through your IDE or Maven environment.

## 🎯 What I learned

This project helped me understand how different backend concepts work together instead of studying them separately.

In particular, I practiced:

* separating responsibilities between classes;
* working with Java objects and database records;
* implementing the Repository and Service layers;
* transferring data between PostgreSQL and Java;
* using JDBC without a framework;
* understanding when to use `ResultSet`;
* understanding the difference between `executeQuery()` and `executeUpdate()`;
* handling database errors and application exceptions;
* keeping database credentials outside the source code.

One of the most important lessons was understanding that changing a Java object does not automatically change the database — the updated state must be explicitly persisted through the Repository layer.

## 🚧 Project status

**Completed as a learning project.**

There are many possible improvements, but the purpose of this version was to build and understand the fundamentals before moving to more advanced backend topics.

The next learning step is **SQL and JDBC transactions**, followed by more advanced database concepts and larger backend projects.

---

Built while learning Java Backend development step by step.
