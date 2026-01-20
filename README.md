# Hotel Reservation System

A **Java console-based application** for managing hotel room bookings, developed as part of the **CodeAlpha Internship**.  
This project demonstrates **Object-Oriented Programming, file handling, and practical system design** in Java.

---

##  Features

- Show available rooms by type: **Standard, Deluxe, Suite**  
- Book rooms and save bookings persistently in `bookings.txt`  
- Cancel bookings with automatic room availability update  
- View all bookings with customer and room details  
- Simulated payment confirmation  
- Room data persistence in `rooms.txt` for real-time tracking  

---

##  Technologies & Concepts

- **Language:** Java  
- **Concepts:**  
  - Object-Oriented Programming (OOP)  
  - Collections (`HashMap`)  
  - File Handling (`FileWriter`, `Scanner`)  
  - Data persistence with text files  

- **Package Structure:** `hotel`  
  - `Booking.java` – Handles booking creation, viewing, and cancellation  
  - `Hotel.java` – Manages room availability and persistence  
  - `HotelReservationSystem.java` – Main class with interactive console menu  

HotelReservationSystem/
│
├── hotel/
│   ├── Booking.java
│   ├── Hotel.java
│   └── HotelReservationSystem.java
│
├── bookings.txt      
├── rooms.txt         
└── README.md
