# Store Spring Boot API

A simple e-commerce backend built with Spring Boot and Java, exposing RESTful APIs for products, orders, and users. This is a demo project designed to showcase full‑stack backend skills, tested with Postman and deployed on Railway.

---

##  Live Demo

Try out the API on Railway:  
[**Store API (Railway)**])

------------------------------------------------------
## Tech Stack

- Java  
- Spring Boot  
- Maven  
- Database: < MySQL>  
- Stripe (test mode)  
- Postman (for API testing)  
- Environment variables for configuration

----------------------------------------------------

## Key Features

- CRUD operations for **Products**, **Orders**, **Users**  
- RESTful API design  
- Secure configuration with environment variables  
- Stripe test integration for payments  
- Deployment on Railway  
- Postman collection for testing

---

## API Endpoints

Here are some of the main endpoints (example):

| Entity    | Method | Endpoint                      | Description                |
|-----------|--------|-------------------------------|----------------------------|
| Products  | GET    | `/api/products`               | Get all products           |
| Products  | POST   | `/api/products`               | Create a new product       |
| Products  | GET    | `/api/products/{id}`          | Get a product by ID        |
| Products  | PUT    | `/api/products/{id}`          | Update a product           |
| Products  | DELETE | `/api/products/{id}`          | Delete a product           |
| Orders    | GET    | `/api/orders`                 | List all orders            |
| Orders    | POST   | `/api/orders`                 | Create a new order         |
| Orders    | GET    | `/api/orders/{id}`            | Get order by ID            |
| Users     | POST   | `/api/users/register`         | Register a new user        |
| Users     | POST   | `/api/users/login`            | Log in an existing user    |

---

## Getting Started (Local Setup)

1. **Clone the repo**  
   ```bash
   git clone https://github.com/Saratsi/Store_Spring-Boot.git  
   cd Store_Spring-Boot
   
2. Copy .env.example to .env and fill in your values e.g.
   
   DATABASE_URL=<your database URL>  
   STRIPE_SECRET_KEY=<your stripe test secret>  
   STRIPE_PUBLISHABLE_KEY=<your stripe publishable key> 

3. (Run the application)

4.Test the API
--------------
Use Postman to send requests to your running backend.
