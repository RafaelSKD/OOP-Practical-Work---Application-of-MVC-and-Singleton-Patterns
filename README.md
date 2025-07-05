# CESAE Resort – Thematic Hotel Programming Project

This is a Java application developed as a practical project for a Software Developer course focusing on **Design Patterns** and MVC architecture. The project simulates the management system of the CESAE Resort – a thematic hotel centered on programming experiences.

---

## Project Overview

CESAE Resort offers:

- Thematic rooms bookable on a weekly basis.
- Programming experiences led by specialized guides, sold to adults and children.
- Ratings for both experiences and their respective guides.

The application is structured following the **Model-View-Controller (MVC)** pattern to support modular development, team collaboration, ease of testing, maintenance, and clear documentation.

Additionally, the **Singleton pattern** is applied to ensure unique instances of repositories managing data throughout the system.

---

## User Roles and Functionalities

The system provides a login menu with access types:

- **Administrator (ADMIN)**
- **Receptionist (GESTAO)**
- **Experience Guide (GUIA)**
- **Public Client Access** (no login required)

### Client Menu (Public Access)

- View available rooms (room number, type, price per week).
- View available experiences (name, experience rating, guide name, guide rating, adult and child prices).
- View favorite experience (highest rated).
- View top-seller experience (most tickets sold).
- Rate an experience and its guide.

### Receptionist Menu (Login Required)

- View available rooms for the current week.
- View reserved rooms with client and reservation details.
- View current reservations of the week.
- Make a new room reservation after validating availability.
- Book an experience for a client with adult and child counts.

### Experience Guide Menu (Login Required)

- View their experience history including total adults and children booked and total revenue earned.

### Administrator Menu (Login Required)

- View total reservations (past and future).
- View total revenue from rooms and experience tickets.
- Query monthly reservations and revenue.
- Identify most booked room types.
- Identify most popular experiences for adults and children (tickets sold).
- Identify most and least profitable experiences.
- Find room with the best price per week.
- Add new user login accounts.

---

## Development Details

- Developed in **Java**, fully functional with no compile-time errors.
- Code follows good practices, includes comments, and targets performance optimization.
- Uses the current date.
- Login credentials and role-based access control implemented based on stored user data.
- Javadoc generated for all classes and methods to facilitate documentation.

---

## Author

- **Rafael Costa** – Student and primary developer

---

## Notes

This project was assigned and supervised by Professor Vitor Santos as part of the Software Developer course curriculum. It aims to apply design patterns and MVC architecture to a practical software system simulating a hotel management scenario.

---

Feel free to explore, test, and contribute!
