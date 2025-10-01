# 📚 QUB Library Management System  
_A Java console-based application for managing the Queen's University Belfast library collection._  

## 📚 **Project Overview**  
This Java console application provides comprehensive management for a library's book inventory. It allows users to perform essential library operations through an intuitive menu.:  

Core Capabilities:
- ✅ Inventory Management: Add, view, and remove books.
- ✅ Circulation: Facilitate book borrowing and returns.
- ✅ Status Filtering: List books based on their availability (Available, On Loan, Withdrawn).
- ✅ Popularity Tracking: Rank and display the most frequently borrowed books.  

The project consists of two parts:  
- **Part 1:** Standard text-based console implementation. 
- **Part 2:**An interactive version utilizing the CSC1029Console.jar library for an improved user experience. 

---

## 🏢 **Project Structure**  
```
Assessment2/
│── bin/            # Contains compiled .class files and JAR file
│   ├── csc1029_a2.jar  # JAR file for the project
│── part01/         # Core functionality
│── part02/         # Enhanced console-based version
│── Images/         # Book cover images (max 10)
│── README.md       # This file
```

---

## 🚀 **Getting Started**  

### 🔧 Prerequisites  
- Java 17 or higher  
- Eclipse IDE (recommended)  
- `csc1029_a2.jar` added to the build path (for Part 2)
- The compiled `.jar` file is located in the `bin/` directory.
   
### 👅 Installation  
1. Clone the repository:  
   ```bash
   git clone https://github.com/yourusername/Assessment2.git
   cd Assessment2
   ```
2. Open the project in Eclipse.  
3. **For Part 2**, add `csc1029_a2.jar` to the build path:  
   - Right-click project → Build Path → Configure Build Path → Add External JARs → Select `csc1029_a2.jar`  
4. Run the application by executing `QUBLibrary.java` (Part 1) or `QUBLibraryUpdated.java` (Part 2).
---

## 📌 **Features & Functionality**  

### 🎯 **Core Features (Part 1)**
- Book CRUD: Add new books (with input validation) and remove books (if not currently on loan).
- Search & Filter: List all books or filter by status (Available, On Loan, Withdrawn).
- Transactions: Handle borrowing and returning of books.
- Reporting: Display a ranked list of the most popular books based on borrow count.



### 🎨 **Enhanced Features (Part 2)**
- Improved UI: Leverages the Console class from CSC1029Console.jar.
- Visual Output: Features colorful, structured text output.
- Cover Display: Ability to display book cover images within the console. 

---

## 🛠 **Implementation Details**  
### 📂 **Key Classes**
- **`Book`** → Represents a book with attributes like title, author, ISBN, edition, and price.  
- **`LibraryBook`** → Extends `Book`, adding borrowing functionality and tracking status.  
- **`Library`** → Manages a collection of books, handling borrow/return operations.  
- **`Lendable`** → Interface for lending functionality.  
- **`QUBLibrary`** → Console-based interface for interacting with the system.  
- **`QUBLibraryUpdated`** → Enhanced version using `Console`.  

---

## 🐝 **License**  
This project was developed as part of the CSC1029 module at Queen’s University Belfast.  

---

## 🤝 **Contributors**  
- **Noel Varghese Koshy** ([GitHub Profile](https://github.com/ganesh5176))  
