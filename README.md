# Real-Time Event Ticketing System


```mermaid

graph TD
    A[Front-End] <--> B[Controller Layer]
    B[Controller Layer] <--> C[Service Layer]
    C[Service Layer] <--> D[Repository Layer]
    D[Repository Layer] <--> E[(Database)]

    A <-->|Sends HTTP Requests| B
    B <-->|Handles Requests| C
    C <-->|Processes Business Logic| D
    D <-->|Interacts with| E

```


## *Project proposal*

```mermaid

classDiagram
    class Ticket {
        <<Entity>>
        + Long id
        + String eventName
        + Integer availableTickets
        + void addTickets(int count)
        + void removeTicket()
    }

    class Vendor {
        + void run()
    }

    class Customer {
        + void run()
    }

    class TicketPool {
        + synchronized void addTickets(int tickets)
        + synchronized Ticket removeTicket()
    }

    class TicketService {
        + void addTickets(int tickets)
        + Ticket purchaseTicket()
    }

    class TicketRepository {
        <<Repository>>
        + save(Ticket ticket): Ticket
        + findById(Long id): Optional~Ticket~
    }

    class TicketController {
        <<RestController>>
        + ResponseEntity~List~ getAllTickets()
        + ResponseEntity~Ticket~ getTicketById(Long id)
        + ResponseEntity~Ticket~ addTicket(Ticket ticket)
        + ResponseEntity~Ticket~ purchaseTicket(Long ticketId)
    }

    class JwtService {
        + String generateToken(UserDetails userDetails)
        + Boolean validateToken(String token, UserDetails userDetails)
    }

    class AuthService {
        + UserDetails loadUserByUsername(String username)
        + String authenticate(String username, String password)
    }

    class CustomerAccount {
        <<Entity>>
        + Long id
        + String username
        + String password
        + String role    // "CUSTOMER"
    }

    class CustomerAccountRepository {
        <<Repository>>
        + Optional~CustomerAccount~ findByUsername(String username)
    }

    class Logger {
        + log(String message): void
    }

    class ErrorHandler {
        + handleError(Exception e): void
    }

%% Relationships between entities and services
    TicketRepository --> Ticket : "manages"
    TicketService --> TicketRepository : "uses"
    TicketPool --> TicketService : "calls"
    TicketController --> TicketService : "invokes"

%% Authentication
    AuthService --> JwtService : "generates and validates JWT"
    AuthService --> CustomerAccountRepository : "retrieves"
    TicketController --> AuthService : "authenticates"

%% Threads and synchronization
    Vendor --|> Runnable : "implements"
    Customer --|> Runnable : "implements"
    Vendor --> TicketPool : "adds tickets to"
    Customer --> TicketPool : "retrieves tickets from"

%% Logs and errors
    Vendor --> Logger : "logs activities"
    Customer --> Logger : "logs activities"
    Vendor --> ErrorHandler : "handles errors"
    Customer --> ErrorHandler : "handles errors"

%% JPA Relationships
    class Ticket {
        <<Entity>>
        + @Id
        + @GeneratedValue(strategy = GenerationType.IDENTITY)
        + Long id
        + String eventName
        + Integer availableTickets
        + addTickets(int count)
        + removeTicket()
    }

    class TicketRepository {
        <<Repository>>
        + Ticket save(Ticket ticket)
        + Optional~Ticket~ findById(Long id)
    }

    class CustomerAccount {
        <<Entity>>
        + @Id
        + @GeneratedValue(strategy = GenerationType.IDENTITY)
        + Long id
        + String username
        + String password
        + String role    // "CUSTOMER"
    }

    class CustomerAccountRepository {
        <<Repository>>
        + Optional~CustomerAccount~ findByUsername(String username)
    }

```

## Real-Time Event Ticketing System Checklist

## Entities
- [ ] **Ticket**
    - Properties:
        - Long id
        - String eventName
        - Integer availableTickets
    - Methods:
        - void addTickets(int count)
        - void removeTicket()

- [ ] **CustomerAccount** (renamed from User)
    - Properties:
        - Long id
        - String username
        - String password
        - String role (e.g., "VENDOR" or "CUSTOMER")

## Repositories
- [ ] **TicketRepository**
    - Methods:
        - Ticket save(Ticket ticket)
        - Optional~Ticket~ findById(Long id)

- [ ] **CustomerAccountRepository** (renamed from UserRepository)
    - Methods:
        - Optional~CustomerAccount~ findByUsername(String username)

## Services
- [ ] **TicketService**
    - Methods:
        - void addTickets(int tickets)
        - Ticket purchaseTicket()

- [ ] **AuthService**
    - Methods:
        - UserDetails loadUserByUsername(String username)
        - String authenticate(String username, String password)

- [ ] **JwtService**
    - Methods:
        - String generateToken(UserDetails userDetails)
        - Boolean validateToken(String token, UserDetails userDetails)

## Controllers
- [ ] **TicketController**
    - Methods:
        - ResponseEntity~List~ getAllTickets()
        - ResponseEntity~Ticket~ getTicketById(Long id)
        - ResponseEntity~Ticket~ addTicket(Ticket ticket)
        - ResponseEntity~Ticket~ purchaseTicket(Long ticketId)

## Utility Classes
- [ ] **TicketPool**
    - Methods:
        - synchronized void addTickets(int tickets)
        - synchronized Ticket removeTicket()

- [x] **Logger**
    - Custom annotation:
        - [x] MethodLogger(String message)
        - [ ] ConstructorLogger(String message)

- [ ] **ErrorHandler**
    - Methods:
        - void handleError(Exception e)

## Thread Classes
- [ ] **Vendor**
    - Methods:
        - void run()

- [ ] **Customer**
    - Methods:
        - void run()
