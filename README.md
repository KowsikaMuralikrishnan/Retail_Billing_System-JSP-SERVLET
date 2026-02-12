# 🛒 Retail & Commerce System (JSP + JDBC)

A simple **Retail Transaction Management Web Application** built using **Java, JSP, Servlets, JDBC, and Oracle DB**.  
This project allows users to **add, view, and manage retail transactions** in a structured and validated manner.

---

## 📌 Project Objective

The objective of this project is to build an online system to manage **retail transaction details**, including:

- Customer Information  
- Product Details  
- Purchase Date  
- Quantity & Price  
- Remarks  

The application supports **adding new transactions**, **viewing specific transactions**, and **listing all transactions**.

---

## 🧰 Tech Stack

- **Frontend:** HTML, JSP  
- **Backend:** Java, Servlets, JDBC  
- **Database:** Oracle 11g  
- **Server:** Apache Tomcat  
- **IDE:** Eclipse  

---

## 📂 Project Structure

Retail-Commerce-System
│
├── com.wipro.retail.util
│ └── DBUtil.java
│
├── com.wipro.retail.bean
│ └── RetailBean.java
│
├── com.wipro.retail.dao
│ └── RetailDAO.java
│
├── com.wipro.retail.service
│ └── Administrator.java
│
├── com.wipro.retail.servlets
│ └── MainServlet.java
│
├── WebContent
│ ├── menu.html
│ ├── addRetailTransaction.jsp
│ ├── viewRetailTransaction.jsp
│ ├── viewAllRetailTransactions.jsp
│ ├── displayRetailTransaction.jsp
│ ├── displayAllRetailTransactions.jsp
│ ├── success.html
│ └── error.html
│
└── README.md


---

## ⚙️ Core Functionalities

### ➕ Add Retail Transaction
- Validates all user inputs before processing  
- Generates a unique **Record ID** for each transaction  
- Stores transaction details securely in the database  
- Redirects the user to **Success** or **Error** page based on the result  

---

### 🔍 View Retail Transaction
- Search transaction using **Customer Name** and **Purchase Date**  
- Displays the matching transaction details  
- Shows an appropriate message when no records are found  

---

### 📋 View All Transactions
- Fetches all retail transaction records from the database  
- Displays records in a structured **tabular format**  
- Handles scenarios when the database contains no records  

---

## 🛡️ Validations Implemented
- Customer name must not be empty  
- Customer name length must be **at least 2 characters**  
- Quantity must be **greater than or equal to 1**  
- Price must be **greater than or equal to 0**  
- Prevents duplicate transaction entries  
- Handles null inputs using a **custom exception**  

---

## 📸 Ouput

### 🏠 Menu Page
<img width="1919" height="501" alt="image" src="https://github.com/user-attachments/assets/a6edff6f-7dc7-4ccc-9511-a31c9ee4d0a7" />


### ➕ Add Retail Transaction Page

<img width="1919" height="604" alt="image" src="https://github.com/user-attachments/assets/dee6c9ad-5600-4546-b017-0363d03d3b16" />

<img width="1919" height="410" alt="image" src="https://github.com/user-attachments/assets/d7ab81e5-a653-43c5-9b05-f8e5de017c41" />


### 🔍 View Transaction Page

<img width="1919" height="455" alt="image" src="https://github.com/user-attachments/assets/855d8c8c-664f-4b19-b527-6aa5f20d7596" />

<img width="1919" height="513" alt="image" src="https://github.com/user-attachments/assets/b9539772-331c-47b5-8263-c00a25db4503" />


### 📋 View All Transactions Page

<img width="1919" height="487" alt="image" src="https://github.com/user-attachments/assets/ab01e03f-97ae-400e-85ae-0ed118e9bdd7" />

---

## 🧪 Sample Test Cases
- Add retail transaction with valid inputs  
- Add transaction with empty customer name  
- Add transaction with invalid quantity or price  
- Add transaction when record already exists  
- View retail transaction with valid data  
- View retail transaction with invalid data  
- Fetch all retail transactions  
- Fetch transactions when database is empty  

---

## 🚀 How to Run the Project
1. Import the project into **Eclipse IDE**  
2. Configure **Oracle Database** and update `DBUtil.java`  
3. Create required table and sequence in the database  
4. Deploy the application on **Apache Tomcat Server**  
5. Run `menu.html` in the browser  

---

## 👩‍💻 Author
**KOWSIKA M**  
🌐 GitHub: https://github.com/KowsikaMuralikrishnan  
🔗 LinkedIn: https://www.linkedin.com/in/kowsika-m-733b4b299  
