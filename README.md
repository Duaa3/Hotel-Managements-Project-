# Hotel Management System

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Authentication](#authentication)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [Trello Board](#trello-board)
- [Google Slides Presentation](#google-slides-presentation)
- [Class Diagram](#class-diagram)

## Project Overview
The Hotel Management System is a web application for managing hotel-related operations. It includes functionality for creating and managing hotels, rooms, guests, reservations, and staff. This system is designed to simplify hotel management tasks, such as booking rooms, managing guest information, and handling reservations.

## Features
- Hotel creation and management
- Room management
- Guest registration
- Reservation booking
- Staff management
- Authentication and authorization
- Role-based access control
- RESTful API for integration

## Technologies Used
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JSON Web Tokens (JWT)
- Hibernate
- RESTful API
- Maven

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- MySQL database
- Git (optional)

### Installation
1. Clone the repository to your local machine.


## Usage
- Access the web application through a web browser at http://localhost:8080.
- Use the provided API endpoints for integration with other systems or applications.

## Authentication
- The system uses JSON Web Tokens (JWT) for authentication.
- To obtain a JWT token, you need to authenticate using your username and password.

## API Endpoints
| Controller Name      | Base Route         | Endpoint                    | Route                     | HTTP Method | Description                                         |
|-----------------------|--------------------|-----------------------------|---------------------------|-------------|-----------------------------------------------------|
| RoleController       | /api               | Save a New Role             | /roles                    | POST        | Save a new role.                                   |
|                      |                    | Add a Role to a User        | /roles/addtouser           | POST        | Add a role to a user.                              |
| UserController        | /api               | Get a List of All Users     | /users                    | GET         | Get a list of all users.                          |
|                      |                    | Save a New User             | /users                    | POST        | Save a new user.                                   |
| BillingController    | /billings          | Create Billing              | /create                    | POST        | Create a new billing entry.                       |
|                      |                    | Get Billing by ID           | /{billingId}               | GET         | Retrieve a billing entry by its ID.              |
|                      |                    | Get All Billings            | /all                       | GET         | Retrieve a list of all billing entries.          |
|                      |                    | Update Billing              | /update/{billingId}        | PUT         | Update a billing entry by its ID.                |
|                      |                    | Delete Billing              | /delete/{billingId}        | DELETE      | Delete a billing entry by its ID.                |
| GuestController      | /guests            | Register Guest              | /register                  | POST        | Register a new guest.                             |
|                      |                    | Get Guest by ID             | /{guestId}                 | GET         | Retrieve a guest by its ID.                      |
|                      |                    | Get All Guests              | /all                       | GET         | Retrieve a list of all guest entries.            |
|                      |                    | Update Guest                | /update/{guestId}          | PUT         | Update a guest by its ID.                        |
|                      |                    | Delete Guest                | /delete/{guestId}          | DELETE      | Delete a guest by its ID.                        |
| HotelController      | /hotels            | Create Hotel                | /create                    | POST        | Create a new hotel.                               |
|                      |                    | Update Hotel                | /update/{hotelId}          | PUT         | Update a hotel by its ID.                        |
|                      |                    | Get Hotel by ID             | /{hotelId}                 | GET         | Retrieve a hotel by its ID.                      |
|                      |                    | Get All Hotels              | /all                       | GET         | Retrieve a list of all hotel entries.            |
|                      |                    | Delete Hotel                | /delete/{hotelId}          | DELETE      | Delete a hotel by its ID.                        |
| ReservationController | /reservations       | Create Reservation           | /create                    | POST        | Create a new reservation.                         |
|                      |                    | Update Reservation           | /update/{reservationId}    | PUT         | Update a reservation by its ID.                  |
|                      |                    | Get Reservation by ID       | /{reservationId}           | GET         | Retrieve a reservation by its ID.                |
|                      |                    | Get All Reservations         | /all                       | GET         | Retrieve a list of all reservation entries.      |
|                      |                    | Delete Reservation           | /delete/{reservationId}    | DELETE      | Delete a reservation by its ID.                  |
| RoomController        | /rooms             | Create Room                 | /create                    | POST        | Create a new room.                                |
|                      |                    | Update Room                 | /update/{roomId}          | PUT         | Update a room by its ID.                          |
|                      |                    | Get Room by ID              | /{roomId}                 | GET         | Retrieve a room by its ID.                        |
|                      |                    | Get All Rooms               | /all                       | GET         | Retrieve a list of all room entries.              |
|                      |                    | Get Available Rooms         | /available                 | GET         | Retrieve a list of available room entries.       |
|                      |                    | Delete Room                 | /delete/{roomId}          | DELETE      | Delete a room by its ID.                          |
| StaffController       | /staff             | Create Staff                | /create                    | POST        | Create a new staff member.                        |
|                      |                    | Update Staff                | /update/{staffId}          | PUT         | Update a staff member by their ID.                |
|                      |                    | Get Staff by ID             | /{staffId}                 | GET         | Retrieve a staff member by their ID.             |
|                      |                    | Get All Staff Members       | /all                       | GET         | Retrieve a list of all staff members.            |
|                      |                    | Delete Staff                | /delete/{staffId}          | DELETE      | Delete a staff member by their ID.               |


## Contributing
1. Fork the repository on GitHub.
2. Clone your forked repository to your local machine.
3. Create a new branch to work on a feature or bug fix.
4. Make your changes, commit them, and push to your fork on GitHub.
5. Create a pull request to the original repository.

## Trello Board
Check the project progress on [Trello]
https://trello.com/your-trello-board-link](https://trello.com/b/GuAK5Abt/duaaprojectironhack

## Google Slides Presentation
Explore the project presentation on [Google Slides]
https://docs.google.com/presentation/d/your-presentation-id/edit](https://docs.google.com/presentation/d/1enl90goy0Gw9fIZnXQA7f80QahZHEte-7jiyDRV7iFw/edit#slide=id.gae08f917ff_0_0)https://docs.google.com/presentation/d/1enl90goy0Gw9fIZnXQA7f80QahZHEte-7jiyDRV7iFw/edit#slide=id.gae08f917ff_0_0


## Class Diagram


   
   
   
