# Product Microservice

A Spring Boot REST microservice for managing products. It supports creating, reading, updating, and deleting products, and stores data in a relational database using Spring Data JPA (Hibernate).

## Tech Stack

- Java <17>
- Spring Boot
- Spring Web
- Spring Data JPA 
- MySQL
- Maven 

## Features

- Create a new product
- Update a product (full update with PUT)
- Delete a product
- Automatic `createdAt` and `updatedAt` timestamps
- Product active/inactive status

## Project Structure

```
src/main/java/com/example/product
├── controller    # REST endpoints
├── service       # Business logic
├── repository    # Database access (JPA)
└── entity        # Product entity
```

## Prerequisites

- JDK <17> or higher
- Maven 3.6+
- <MySQL/PostgreSQL> running locally (not needed if using H2)

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/<your-repo>.git
cd <your-repo>
```

### 2. Configure the database

Edit `src/main/resources/application.properties`:

```properties
server.port=8181

spring.datasource.url=jdbc:mysql://localhost:3306/<your_db>
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Create the database first:

```sql
CREATE DATABASE <your_db>;
```

### 3. Run the application

```bash
mvn spring-boot:run
```

The service starts at `http://localhost:8181`.

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/create` | Create a new product |
| PUT    | `/{id}`   | Update an existing product |
| DELETE | `/{id}`   | Delete a product |

### Product Model

| Field | Type | Description |
|-------|------|-------------|
| id | Long | Auto-generated ID |
| produtname | String | Product name |
| price | Double | Product price |
| date | LocalDate | Product date (`yyyy-MM-dd`) |
| active | Boolean | Whether the product is active |
| createdAt | LocalDateTime | Set automatically on create |
| updatedAt | LocalDateTime | Updated automatically on every save |

### Example: Create a product

**Request**

```
POST http://localhost:8181/create
Content-Type: application/json
```

```json
{
    "produtname": "ABC",
    "price": 200,
    "date": "2026-11-20",
    "active": true
}
```

**Response**

```json
{
    "id": 1,
    "produtname": "ABC",
    "price": 200.0,
    "date": "2026-11-20",
    "active": true,
    "createdAt": "2026-11-20T10:30:00",
    "updatedAt": "2026-11-20T10:30:00"
}
```

### Example: Update a product

```
PUT http://localhost:8181/1
Content-Type: application/json
```

```json
{
    "produtname": "ABC",
    "price": 300,
    "date": "2026-11-20",
    "active": true
}
```

> Note: PUT replaces the whole record, so send all fields.

## Common Errors

| Status | Cause |
|--------|-------|
| 400 Bad Request | Invalid JSON, or a non-numeric id in the URL (for example `/id` instead of `/1`) |
| 404 Not Found | The URL does not match any endpoint |
| 405 Method Not Allowed | Wrong HTTP method (for example POST instead of PUT) |
| 500 Internal Server Error | Database connection problem or product id not found |

## Testing

Use Postman or curl:

```bash
curl -X POST http://localhost:8181/create \
  -H "Content-Type: application/json" \
  -d '{"produtname":"ABC","price":200,"date":"2026-11-20","active":true}'
```

## Author

<Your Name>  
GitHub: [@<your-username>](https://github.com/<your-username>)

## License

This project is licensed under the MIT License.
