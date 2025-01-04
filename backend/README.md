# AtoZStore E-Commerce Platform Backend

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

- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)
- [MySQL Server](https://dev.mysql.com/downloads/installer/)

### Steps to Set Up the Backend

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/atozstore-backend.git
   cd atozstore-backend
   ```

2. Configure the database:
   - Create a MySQL database named `atozstore_db`.
   - Update the database connection details in `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/atozstore_db
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. Backend will be accessible at:

   ```
   http://localhost:8081
   ```

---

## Folder Structure

```
big5-personality-test-backend/
|
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com\app\demo/
│   │   │   │   ├── controller/                        # REST controllers for API endpoints
│   │   │   │   │   ├──AdminController.java
│   │   │   │   │   ├──CartProductController.java
│   │   │   │   │   ├──CustomerController.java
│   │   │   │   │   ├──DeliveryPartnerController.java
│   │   │   │   │   ├──OrderController.java
│   │   │   │   │   ├──ProductController.java
│   │   │   │   │   ├──VendorController.java
│   │   │   │   ├── service/                            # Business logic and services
│   │   │   │   │   ├──CartService.java
│   │   │   │   │   ├──CartServiceImpl.java
│   │   │   │   │   ├──CustomerService.java
│   │   │   │   │   ├──CustomerServiceImpl.java
│   │   │   │   │   ├──DeliveryPartnerService.java
│   │   │   │   │   ├──DeliveryPartnerServiceImpl.java
│   │   │   │   │   ├──OrderDetailsService.java
│   │   │   │   │   ├──OrderDetailsServiceImpl.java
│   │   │   │   │   ├──ProductService.java
│   │   │   │   │   ├──ProductServiceImpl.java
│   │   │   │   │   ├──VendorService.java
│   │   │   │   │   ├──VendorServiceImpl.java
│   │   │   │   ├── dao/                                 # JPA repositories for database operations
│   │   │   │   │   ├──CartImageFileRepository.java
│   │   │   │   │   ├──CartProductRepository.java
│   │   │   │   │   ├──CustomerRepository.java
│   │   │   │   │   ├──DeliveryPartnerRepo.java
│   │   │   │   │   ├──OrderDetailsRepository.java
│   │   │   │   │   ├──OrderedProductRepository.java
│   │   │   │   │   ├──ProductsRepository.java
│   │   │   │   │   ├──VendorRepository.java
│   │   │   │   └── bean/                                # Entity classes representing database tables
│   │   │   │   │   ├──Address.java
│   │   │   │   │   ├──Admin.java
│   │   │   │   │   ├──CartImageFile.java
│   │   │   │   │   ├──CartProduct.java
│   │   │   │   │   ├──Color.java
│   │   │   │   │   ├──Customer.java
│   │   │   │   │   ├──DeliveryPartner.java
│   │   │   │   │   ├──ImageFile.java
│   │   │   │   │   ├──OrderDetails.java
│   │   │   │   │   ├──OrderedProduct.java
│   │   │   │   │   ├──Products.java
│   │   │   │   │   ├──Size.java
│   │   │   │   │   ├──TransactionDetails.java
│   │   │   │   │   ├──Vendor.java
│   │   ├── resources/
│   │   |   ├── images/
│   │   |   ├── application.properties        # Configuration properties
├── pom.xml                                   # Maven configuration
└── README.md                                 # Project documentation
```

---

## REST API Endpoints

### Authentication
- **POST /auth/register**: Register a new user.
- **POST /auth/login**: Authenticate a user and return a JWT.

### Product Management
- **GET /api/products**: Retrieve all products.
- **POST /api/products**: Add a new product (Vendor only).
- **GET /api/products/{productid}**: Retrieve a specific product by ID.
- **PUT /api/products/{productid}**: Update a product (Vendor only). 
- **DELETE /api/products/{productid}**: Delete a product (Vendor only). 

### Order Management
- **POST /api/orders**: Create a new order.
- **GET /api/orders/{userId}**: Retrieve all orders for a specific user.
- **GET /api/orders/{orderId}**: Retrieve order details by ID.
- **PUT /api/orders/{orderId}**: Update order status (Vendor only).

### User Management
- **GET /api/users/{userId}**: Retrieve user profile.
- **PUT /api/users/{userId}**: Update user profile.

### Payment
- **POST /api/payment/checkout**: Start a checkout process and generate a payment link with Razorpay integration.

---

## How It Works

1. **Account Creation**: Users register through the frontend, and their details are securely stored in the MySQL database.
2. **Product Management**: Admins can add, update, and delete product listings, while customers can browse products.
3. **Order Flow**:
   - Users add products to their cart and proceed to checkout.
   - Orders are created and stored in the database, along with payment details.
4. **Payment Integration**: Razorpay processes the payments, and the user is notified upon successful payment.
5. **Dashboard**: Users can view their order history, profile, and manage account settings.

---

## Future Enhancements

- Introduce a recommendation system for personalized product suggestions.
- Add support for product reviews and ratings.
- Implement an advanced search and filter functionality for better product discovery.
- Implement multi-currency and multi-language support for global expansion.

---

## Contact

Maintainer: Manoj Modhale

- GitHub: [https://github.com/ManojModhale](https://github.com/ManojModhale)
- Email: [manojmodhale2001@gmail.com](mailto:manojmodhale2001@gmail.com)

