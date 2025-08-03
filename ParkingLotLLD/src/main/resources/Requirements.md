# Parking Lot LLD (Low-Level Design)

## 📌 Problem Statement

Design and implement a **Parking Lot Management System** that supports:

- Parking and unparking of vehicles
- Parking ticket generation
- Fee calculation
- Management of multiple floors and spot types

---

## ✅ Requirements

- **Multiple Floors**: The parking lot can have multiple floors.
- **Parking Spots**: Each floor has multiple parking spots of different types (e.g., car, bike, truck).
- **Vehicle Types**: Support for different vehicle types (see `vehicletype/`).
- **Ticketing**: Generate a parking ticket when a vehicle is parked.
- **Unparking**: Allow vehicles to unpark and calculate the parking fee.
- **Fee Calculation**: Support for different fee strategies (see `fee/`).
- **Spot Allocation**: Allocate the nearest available spot of the correct type.
- **Extensibility**: Easy to add new vehicle types, spot types, or fee strategies.

---

## 🧱 Core Entities

> Adapted from: [Parking Lot Design Reference](https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/parkinglot#core-entities)

### 1. `ParkingLot`

- **Responsibilities**:
    - Main class managing the entire parking lot
    - Tracks all floors and active tickets

- **Methods**:
    - `parkVehicle(Vehicle vehicle)`
    - `unparkVehicle(String ticketId)`
    - `addFloor(ParkingFloor floor)`
    - `getAvailableSpots()`

- **Fields**:
    - List of floors
    - Mapping of tickets, etc.

---

### 2. `ParkingFloor`

- **Responsibilities**:
    - Represents a single floor in the parking lot
    - Manages parking spots on that floor

- **Methods**:
    - `getAvailableSpot(VehicleType type)`
    - `parkVehicle(Vehicle vehicle)`
    - `unparkVehicle(String spotId)`

- **Fields**:
    - List of spots
    - Floor number

---

### 3. `ParkingSpot`

- **Responsibilities**:
    - Represents an individual parking spot
    - Knows its type and occupancy state

- **Methods**:
    - `isAvailable()`
    - `assignVehicle(Vehicle vehicle)`
    - `removeVehicle()`

- **Fields**:
    - Spot ID
    - Spot type
    - Current vehicle

---

### 4. `Ticket`

- **Responsibilities**:
    - Represents a parking ticket issued when a vehicle is parked

- **Fields**:
    - Ticket ID
    - Vehicle info
    - Entry time
    - Spot info

---

### 5. `VehicleType` (in `vehicletype/`)

- Enum or class definitions for different vehicle types:
    - `Car`
    - `Bike`
    - `Truck`
    - etc.

---

### 6. Fee Calculation (in `fee/`)

- **Responsibilities**:
    - Calculate parking fees based on duration and vehicle type

- **Method**:
    - `calculateFee(Ticket parkingTicket, Date exitTime)`

- **Extensibility**:
    - Easily plug in new strategies (e.g., flat rate, hourly, vehicle-based)

---


---

## 📌 Design Patterns Used

| Pattern                | Where Used                             | Why Used                                                  |
|------------------------|----------------------------------------|-----------------------------------------------------------|
| **Singleton**          | `ParkingLot` class                     | To ensure only one instance of the parking lot exists     |
| **Strategy**           | `FeeStrategy` and its implementations  | To support dynamic fee calculation policies               |
| **Factory**            | `VehicleFactory`                       | To create `Vehicle` objects based on input type           |
| **Optional** (Java 8+) | `getAvailableSpot(...)`                | To handle null-safety and optional spot availability      |
| **Encapsulation**      | All entities                           | To maintain control over data and behavior per class      |
| **OOP Principles**     | Inheritance (Vehicle, Spot types)      | To extend functionality without breaking existing code    |

---

## 💬 References

- [Awesome LLD - GitHub Repository](https://github.com/ashishps1/awesome-low-level-design)

