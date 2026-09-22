# Ride Booking — Review Service

Review Service is a Spring Boot microservice responsible for managing passenger reviews and ratings for completed rides.

## Features

* JWT validation through Auth Service
* Only passengers can create reviews
* Passenger must be associated with the booking
* Reviews allowed only for `COMPLETED` bookings
* One review per booking using a database `UNIQUE` constraint
* Service discovery using Eureka
* Inter-service communication using Retrofit

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA / Hibernate
* MySQL
* JWT
* Retrofit
* Eureka

## Review Flow

```text
Passenger
   ↓
Review Service
   ↓
Validate JWT → Auth Service
   ↓
Fetch Booking → Booking Service
   ↓
Verify Passenger + COMPLETED status
   ↓
Save Review
```

## API Endpoints

| Method | Endpoint               | Description     |
| ------ | ---------------------- | --------------- |
| POST   | `/api/v1/reviews`      | Create review   |
| GET    | `/api/v1/reviews/{id}` | Get review      |
| GET    | `/api/v1/reviews`      | Get all reviews |
| PUT    | `/api/v1/reviews/{id}` | Update review   |
| DELETE | `/api/v1/reviews/{id}` | Delete review   |

### Create Review

```http
POST /api/v1/reviews
Authorization: Bearer <JWT>
Content-Type: application/json
```

```json
{
  "content": "Amazing ride quality",
  "rating": 4,
  "bookingId": 1
}
```

### Design

The service stores `bookingId` instead of a direct `Booking` entity relationship. Booking details are retrieved from the Booking Service, keeping the microservices loosely coupled.

```text
Review Service
     │
     ├── Auth Service
     ├── Booking Service
     └── MySQL
```

## 🔗 Related Services
* [Auth Service](https://github.com/adarsh25tiwari/Ride-Booking-AuthService)
* [Booking Service](https://github.com/adarsh25tiwari/Ride-Booking-BookingService)
* [Location Service](https://github.com/adarsh25tiwari/Ride-Booking-LocationService)
* [Socket Service](https://github.com/adarsh25tiwari/Ride-Booking-SocketService)
* [Service Discovery](https://github.com/adarsh25tiwari/Ride-Booking-ServiceDiscovery)
* [Entity Library](https://github.com/adarsh25tiwari/Ride-Booking-EntityService)
