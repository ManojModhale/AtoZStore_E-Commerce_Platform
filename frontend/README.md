# AtoZStore E-Commerce Platform Frontend

## Overview

**AtoZStore** is a comprehensive, fully responsive, and user-friendly e-commerce platform developed by a team of four members in just two weeks. Designed to deliver a seamless shopping experience across diverse product categories, the platform leverages modern technologies like Angular, Spring Boot, MySQL, and Razorpay for payment integration.

As a team leader, I took charge of all major roles, including frontend and backend development, ensuring a client-centric approach while maintaining a balance between design and functionality. The application follows the MVC design pattern and a layered architecture comprising controllers, services, DAO, and beans at the backend to ensure modularity, scalability, and maintainability.

## Features

1. **Multi-Role Functionality**:
    - Customer: Browse products, add to cart, checkout, and track orders.
    - Vendor: Manage product listings, inventory, and orders.
    - Delivery Partner: Access delivery schedules and update delivery statuses.
    - Admin: Manage platform operations, users, and reports.

2. **Core Functionalities**:
    - User account creation with secure authentication.
    - Dynamic product search with category filters for enhanced usability.
    - Shopping cart and streamlined checkout experience.
    - Razorpay Payment integration for secure and seamless payments.
    - Real-time order tracking and management for all user roles.

3. **Project Highlights**: 
    - Team Effort: Successfully led a four-member team, ensuring effective collaboration and timely delivery.
    - Comprehensive Role Handling: Managed frontend and backend design and development while adopting a client’s perspective to ensure usability and satisfaction.
    - Responsive Design: Fully optimized for various devices, providing a consistent and smooth user experience.
    - Efficient Architecture: Designed with an MVC pattern and layered architecture for a robust and scalable system.

---

## Frontend (Angular)

The frontend of AtoZStore is developed using Angular, ensuring a dynamic and interactive user experience. The architecture and features are structured to provide a seamless flow and intuitive navigation for all user roles.

## Key Features

1. **Components**:
    - Modularized components for better maintainability and reusability like WelcomePage, Home, Login, Logout, Products, OrderHistory, Payment, etc.
    - Parent-child component relationships are effectively used for dynamic data sharing and UI updates.

2. **Pipes**:
    - Custom pipes for data transformation and enhanced UI functionality.

3. **Routing**:
    - Implemented using Angular's RouterModule for seamless navigation between different pages.
    - Lazy-loading modules for performance optimization.
    
4. **Services**:
    - Angular services, along with Axios, are used to facilitate communication between the frontend and backend APIs.
    - Handle business logic and data management efficiently.
    
5. **Responsive Design**:
    - Built with responsive layouts for compatibility with various devices.
    - Used inbuilt and external modules to enhance structural layout, aesthetics, and user interactivity.
      
6. **Assets Directory**:
    - Contains all images and static assets used in the application.

7. **Module.ts**:
    - Serves as the metadata hub for the frontend application, where all components, modules, and services are registered.

**Technologies and Tools**:
  - Angular
  - TypeScript
  - CSS/SCSS for styling
  - Axios for HTTP requests
  - Bootstrap/Material Design for responsiveness and layout
  - VS Code
  - Git and Github

---

## Backend (Spring Boot)

The backend of AtoZStore is built using Spring Boot, following a layered architecture to ensure a clean separation of concerns and a robust, scalable system.

## Architecture and Flow:

1. **Request Flow**:
    - The frontend sends a request to the Controller.
    - The controller assigns incoming data to a class object.
    - The object is passed to the Service layer, where core business logic is executed.
    - The DAO layer (Data Access Object) interacts with the database using JPA to perform transactions and retrieve results.
    - Results are sent back through the Service layer to the Controller, which formats the response for the frontend.

2. **Resources Directory**:
    - Contains all images and configuration file, such as application.properties, for user and application settings

3. **Email Feature**:
    - Implemented using the Java Email Library for sending automated emails.
    
4. **Payment Integration**:
    - Razorpay is integrated for secure and efficient payment handling.


**Key Features**:
  - Layered Architecture: Ensures separation of concerns between controllers, services, and DAOs.
  - Annotations: Used extensively for configuration and dependency injection.
  - Pom.xml: Manages dependencies and project configurations.


**Database**:
  - MySQL is used for data storage and management.
  - JPA is utilized for ORM (Object-Relational Mapping).

**Technologies and Tools**:
  - Spring Boot
  - Java
  - JPA for database interactions
  - Razorpay API for payment processing
  - Maven
  - SpringToolSuite
  - Git and Github

---

## Installation

### Prerequisites

Before starting, ensure you have the following installed:

- [Node.js](https://nodejs.org/) (which includes npm)
- [Angular CLI](https://angular.io/cli)

Additionally, ensure the backend (Spring Boot) is running on port `8081`.

### Steps to Run the Angular Frontend

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/atozstore-frontend.git
   cd atozstore-frontend
   ```

2. Install the dependencies:

   ```bash
   npm install
   ```

3. Start the development server:

   ```bash
   ng serve
   ```

4. Open your browser and navigate to:

   ```
   http://localhost:4200
   ```

The Angular frontend will be running and communicating with the backend on port `8081`.

---

## Folder Structure

```
atozstore-frontend/
|
├── src/
|   ├── app/
|   │   ├── components/                    # Reusable UI components
|   │   │   ├── homepage/                  # Homepage component
|   │   │   ├── login/                     # Login component
|   │   │   ├── register/                  # Registration component
|   │   │   ├── dashboard/                 # Dashboard for different user roles
|   │   │   ├── product-list/              # Product listing and search component
|   │   │   ├── cart/                      # Shopping cart component
|   │   │   ├── checkout/                  # Checkout process component
|   │   │   └── order-summary/             # Order summary and tracking component
|   │   ├── services/                      # Services to handle business logic
|   │   │   ├── auth.service.ts            # Authentication service
|   │   │   ├── product.service.ts         # Service for product-related operations
|   │   │   ├── cart.service.ts            # Service for managing the shopping cart
|   │   │   ├── order.service.ts           # Service for order management
|   │   │   └── payment.service.ts         # Service for Razorpay integration
|   │   ├── models/                        # TypeScript models (e.g., User, Product)
|   │   ├── app-rounting.module.ts         # Rounting Navigation between Pages
|   │   └── app.module.ts                  # Root module for the Angular app
|   ├── assets/                            # Static files like images and JSON files
|   ├── environments/                      # Environment configurations (e.g., dev, prod)
|
├── angular.json                           # Angular CLI configuration
├── package.json                           # Node.js dependencies and scripts
└── README.md                              # Project documentation
```

---

## Folder Description

- **src/app/components/**: Contains components for various pages and features.
- **src/app/services/**: Houses services that handle business logic and backend communication.
- **src/assets/**: Contains static files such as images and configuration JSON files.
- **src/app/models/**: Defines TypeScript interfaces and models used throughout the application.

---

## Backend Communication

The Angular frontend communicates with the Spring Boot backend running on port `8081` using Angular's `HttpClientModule`. All HTTP requests (GET, POST) for user authentication, product data, order processing, and payment handling are directed to the backend URL `http://localhost:8081`.

**Example API Endpoints**

- `GET /api/products`: Fetches product data.
- `POST /api/orders`: Places an order.
- `POST /api/payment`: Initiates payment through Razorpay.

**CORS Configuration (Backend)**

Ensure that CORS is enabled in the Spring Boot backend to allow communication between the frontend (port `4200`) and backend (port `8081`).

---

## Future Enhancements

- Implement advanced product recommendation algorithms.
- Enable multilingual support for a global audience.
- Add real-time order tracking with live updates.
- Integrate additional payment gateways for wider accessibility.

---

## Contact

Maintainer: Manoj Modhale

- GitHub: [https://github.com/ManojModhale](https://github.com/ManojModhale)
- Email: [manojmodhale2001@gmail.com](mailto:manojmodhale2001@gmail.com)

---
