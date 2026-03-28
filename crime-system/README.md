CrimeDesk 
Project Status: In Progress
A Crime Investigation & Case Tracking System
A role-based web application designed to manage and track crime cases from reporting to final verdict. The system connects citizens, police departments, and the court to ensure a complete case lifecycle.

Features
Citizen
•	Register/Login
•	Report new crime cases
•	View case status and updates
Inspector
•	Login access
•	View all reported cases
•	Assign cases to Sub-Inspectors
Sub-Inspector
•	Login access
•	View assigned cases
•	Update case status (In Progress / Completed)
Court
•	View assigned/closed cases
•	Add hearing details
•	Update case verdict
•	Maintain case history
Admin
•	Manage users (Citizen, Inspector, Sub-Inspector)
•	Monitor all cases
•	System-level control

Tech Stack
•	Backend: Spring Boot (Java)
•	Frontend: HTML, CSS, JavaScript
•	Database: MySQL
•	Build Tool: Maven

Project Structure
crime-system/
│
├── src/main/java/com/crime/crime_system/
│ ├── controller/
│ ├── service/
│ ├── repository/
│ ├── entity/
│ └── dto/
│
├── src/main/resources/
│ ├── static/
│ ├── application.properties
│ └── data.sql
│
└── pom.xml

Case Status Flow
•	REPORTED
•	ASSIGNED
•	IN_PROGRESS
•	COMPLETED
•	UNDER_TRIAL
•	CLOSED (Verdict Given)

Future Enhancements
•	Secure authentication (JWT / Spring Security)
•	Email/SMS notifications
•	Advanced search & filtering
•	UI improvements
•	Cloud deployment (Render / Railway)

Project Objective
To build a structured and transparent system that connects citizens, police, and judicial authorities, ensuring efficient case tracking from complaint to final verdict.

Author

Kalaivani V
M.Tech Integrated Software Engineering
VIT Chennai

If you find this project useful, consider giving it a star!
