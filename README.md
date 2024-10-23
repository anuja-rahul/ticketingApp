# Real-Time Event Ticketing System

```shell
  _____ _    _       _   _             _   ___ ___
 |_   _(_)__| |_____| |_(_)_ _  __ _  /_\ | _ \_ _|
   | | | / _| / / -_)  _| | ' \/ _` |/ _ \|  _/| |
   |_| |_\__|_\_\___|\__|_|_||_\__, /_/ \_\_| |___|  v1.0
                               |___/
   running on Spring Boot 3.3.4
```



## *Project proposal*

[![](https://mermaid.ink/img/pako:eNqlV21P20gQ_iuWpUpBBJIQYkJUIVGKVE70WkHak6p8WbwTe4W969tdG1IOfvvN2mvHdkxIW74Qz84zr8_M2k-uLyi4M3fB_Ygo9ZGRQJJ4wR38yyXOnPn3oJ2nQmb-3r-_5Jrp1dnZWrbvXAseOIzWRbdaMhRCBlz_TWKon11xDQFIh2SEReQugsKP6tLRQpNo23l-dAMREAU3RHc6isljYeKCJMTH8OtKmWDUIZRaJz3GteOLlOu9DS0JschstD17_Lzg9ZJ9B06F_JOS8Va1rDjLDV9gyzbDSvkr0VykSosY5LmfZ_QnYaUK5CuhJejqQcgulBQRGMFg4Fx8u51_-Xx542B5vl99_YUsioJ_FSKqJ7DvqBX3Qyk4-wm0s40FOdTeqyBL8B36WhzegsyYD80wdvVsnSWp9EMk6w7ubiARimkhV83OreXN7imSQc-6KSLYm1lTdbUl4_TD6or2bLdR6UuimeAkeim0X3Zh069GV_lo2XmxAX2zDOu1GLe1ISSC32J1LipqdLV54NsIm0dzFoPSJE5qPezebP-mJA9jy4o49zXLUOX3oy82wtVuaVU7l1KgHft0nZsuf20p-4XgGkc7AtluvaqdNdPAs0RwBUWKL9dMYecD0OdRud97e1v0LTENovjZYPAOwGpCWxOyA7Q1so0id7Pzr4fuXWGpHQAHiZfVXNwD7xnifwSNl6HKSW9_NyL7gNsPCHcyEjFaIa05bR76znY7rQjPUx12hli3EglCzfObw9nIjqBpvPaZj3G29fvtS6M7umsRBE1y7WMwQWkNGapIALi4zPLttHAppZCfCKdR206YC_Pz3uWjD_lacjqMvXuHhIiIOVYhS5RzB_oBAHUNPRgoBy05qiiinaaNxX1wcFZu_pmzcGPCMXC1cOvqZR_WujUDBoXVa0Hy23CtX1owyj6JopZ2bV67MYxnyKF2WGa5Gv32a4RBaEn8e4VXToR1WApZQlvbzcDtO5FBYQ-xasUhexNYq1sOLGauxK8MMu_S-Zpw2KvCXJ3fxlZtIo29cgKLHpZThYP7z7wMqG3h9evPGJSA1MTX3e2Vr9s0qPqoqCqfeSiBUEuv6n2llpyt6MHBf2fOTcq5eYku-hgnEcRosQqj3btdMJX5szrb8ngpLduA_8XrTjaQVX0q-FKKuEr5OicG5gtmLtVGHHYhdHBoWwxvo2ouGhvDQIpFocqQtvjZAbrgbt9FWEwYxY-ufCPhFIVY-YVrIJTIe6P4jHpIC3GLjXdnWqbQd9PEsNN-obmzJYlUJb2khoSV0KxswMcnV68S83kX4EWLJn3Blyww8lRGKA61TtRsMDDHhwHTYXp36It4oBgNidRhduoNvCNvSo7G4J2MyWQ8pv7d6HS6PDoeLenJcHRE3OfnvpsQbqw-urPp8HA4ORpNxxNvPBkfTyd9d-XORsPD0bHnjY6PT8dG7CHmpxCYxvDw9MQbTU8nE28yPvGGJwiAPJvPxZdp_oHad6VIg7BKEP39yOH58_P_FRS_ZQ?type=png)](https://mermaid.live/edit#pako:eNqlV21P20gQ_iuWpUpBBJIQYkJUIVGKVE70WkHak6p8WbwTe4W969tdG1IOfvvN2mvHdkxIW74Qz84zr8_M2k-uLyi4M3fB_Ygo9ZGRQJJ4wR38yyXOnPn3oJ2nQmb-3r-_5Jrp1dnZWrbvXAseOIzWRbdaMhRCBlz_TWKon11xDQFIh2SEReQugsKP6tLRQpNo23l-dAMREAU3RHc6isljYeKCJMTH8OtKmWDUIZRaJz3GteOLlOu9DS0JschstD17_Lzg9ZJ9B06F_JOS8Va1rDjLDV9gyzbDSvkr0VykSosY5LmfZ_QnYaUK5CuhJejqQcgulBQRGMFg4Fx8u51_-Xx542B5vl99_YUsioJ_FSKqJ7DvqBX3Qyk4-wm0s40FOdTeqyBL8B36WhzegsyYD80wdvVsnSWp9EMk6w7ubiARimkhV83OreXN7imSQc-6KSLYm1lTdbUl4_TD6or2bLdR6UuimeAkeim0X3Zh069GV_lo2XmxAX2zDOu1GLe1ISSC32J1LipqdLV54NsIm0dzFoPSJE5qPezebP-mJA9jy4o49zXLUOX3oy82wtVuaVU7l1KgHft0nZsuf20p-4XgGkc7AtluvaqdNdPAs0RwBUWKL9dMYecD0OdRud97e1v0LTENovjZYPAOwGpCWxOyA7Q1so0id7Pzr4fuXWGpHQAHiZfVXNwD7xnifwSNl6HKSW9_NyL7gNsPCHcyEjFaIa05bR76znY7rQjPUx12hli3EglCzfObw9nIjqBpvPaZj3G29fvtS6M7umsRBE1y7WMwQWkNGapIALi4zPLttHAppZCfCKdR206YC_Pz3uWjD_lacjqMvXuHhIiIOVYhS5RzB_oBAHUNPRgoBy05qiiinaaNxX1wcFZu_pmzcGPCMXC1cOvqZR_WujUDBoXVa0Hy23CtX1owyj6JopZ2bV67MYxnyKF2WGa5Gv32a4RBaEn8e4VXToR1WApZQlvbzcDtO5FBYQ-xasUhexNYq1sOLGauxK8MMu_S-Zpw2KvCXJ3fxlZtIo29cgKLHpZThYP7z7wMqG3h9evPGJSA1MTX3e2Vr9s0qPqoqCqfeSiBUEuv6n2llpyt6MHBf2fOTcq5eYku-hgnEcRosQqj3btdMJX5szrb8ngpLduA_8XrTjaQVX0q-FKKuEr5OicG5gtmLtVGHHYhdHBoWwxvo2ouGhvDQIpFocqQtvjZAbrgbt9FWEwYxY-ufCPhFIVY-YVrIJTIe6P4jHpIC3GLjXdnWqbQd9PEsNN-obmzJYlUJb2khoSV0KxswMcnV68S83kX4EWLJn3Blyww8lRGKA61TtRsMDDHhwHTYXp36It4oBgNidRhduoNvCNvSo7G4J2MyWQ8pv7d6HS6PDoeLenJcHRE3OfnvpsQbqw-urPp8HA4ORpNxxNvPBkfTyd9d-XORsPD0bHnjY6PT8dG7CHmpxCYxvDw9MQbTU8nE28yPvGGJwiAPJvPxZdp_oHad6VIg7BKEP39yOH58_P_FRS_ZQ)

[//]: # (```mermaid)

[//]: # ()
[//]: # (classDiagram)

[//]: # (    class Ticket {)

[//]: # (        <<Entity>>)

[//]: # (        + Long id)

[//]: # (        + String eventName)

[//]: # (        + Integer availableTickets)

[//]: # (        + Integer totalTickets)

[//]: # (        + Integer ticketReleaseRate)

[//]: # (        + Integer maxTicketCapacity)

[//]: # (        + void addTickets&#40;int count&#41;)

[//]: # (        + void removeTicket&#40;&#41;)

[//]: # (    })

[//]: # ()
[//]: # (    class Vendor {)

[//]: # (        <<Entity>>)

[//]: # (        + Long id)

[//]: # (        + String name)

[//]: # (        + String vendorCode)

[//]: # (        + void run&#40;&#41;)

[//]: # (    })

[//]: # ()
[//]: # (    class CustomerAccount {)

[//]: # (        <<Entity>>)

[//]: # (        + Long id)

[//]: # (        + String username)

[//]: # (        + String password)

[//]: # (        + String role    // CUSTOMER or VIP)

[//]: # (        + void run&#40;&#41;)

[//]: # (    })

[//]: # ()
[//]: # (    class TicketPool {)

[//]: # (        + synchronized void addTickets&#40;int tickets&#41;)

[//]: # (        + synchronized Ticket removeTicket&#40;&#41;)

[//]: # (    })

[//]: # ()
[//]: # (    class TicketService {)

[//]: # (        + void addTickets&#40;int tickets&#41;)

[//]: # (        + Ticket purchaseTicket&#40;&#41;)

[//]: # (    })

[//]: # ()
[//]: # (    class TicketRepository {)

[//]: # (        <<Repository>>)

[//]: # (        + save&#40;Ticket ticket&#41;: Ticket)

[//]: # (        + findById&#40;Long id&#41;: Optional~Ticket~)

[//]: # (    })

[//]: # ()
[//]: # (    class CustomerAccountRepository {)

[//]: # (        <<Repository>>)

[//]: # (        + Optional~CustomerAccount~ findByUsername&#40;String username&#41;)

[//]: # (    })

[//]: # ()
[//]: # (    class TicketSale {)

[//]: # (        <<Entity>>)

[//]: # (        + Long id)

[//]: # (        + Long ticketId)

[//]: # (        + Long customerId)

[//]: # (        + Timestamp purchaseTime)

[//]: # (        + Integer quantity)

[//]: # (    })

[//]: # ()
[//]: # (    class VendorActivity {)

[//]: # (        <<Entity>>)

[//]: # (        + Long id)

[//]: # (        + Long vendorId)

[//]: # (        + Long ticketId)

[//]: # (        + Integer addedTickets)

[//]: # (        + Timestamp timestamp)

[//]: # (    })

[//]: # ()
[//]: # (    class TicketController {)

[//]: # (        <<RestController>>)

[//]: # (        + ResponseEntity~List~ getAllTickets&#40;&#41;)

[//]: # (        + ResponseEntity~Ticket~ getTicketById&#40;Long id&#41;)

[//]: # (        + ResponseEntity~Ticket~ addTicket&#40;Ticket ticket&#41;)

[//]: # (        + ResponseEntity~Ticket~ purchaseTicket&#40;Long ticketId&#41;)

[//]: # (    })

[//]: # ()
[//]: # (    class JwtService {)

[//]: # (        + String generateToken&#40;UserDetails userDetails&#41;)

[//]: # (        + Boolean validateToken&#40;String token, UserDetails userDetails&#41;)

[//]: # (    })

[//]: # ()
[//]: # (    class AuthService {)

[//]: # (        + UserDetails loadUserByUsername&#40;String username&#41;)

[//]: # (        + String authenticate&#40;String username, String password&#41;)

[//]: # (    })

[//]: # ()
[//]: # (    class Logger {)

[//]: # (        + log&#40;String message&#41;: void)

[//]: # (    })

[//]: # ()
[//]: # (    class ErrorHandler {)

[//]: # (        + handleError&#40;Exception e&#41;: void)

[//]: # (    })

[//]: # ()
[//]: # (%% Relationships between entities and services)

[//]: # (    TicketRepository --> Ticket : "manages")

[//]: # (    TicketService --> TicketRepository : "uses")

[//]: # (    TicketPool --> TicketService : "calls")

[//]: # (    TicketController --> TicketService : "invokes")

[//]: # (    TicketSale --> CustomerAccount : "tracks sales for")

[//]: # (    VendorActivity --> Vendor : "logs activities for")

[//]: # (    VendorActivity --> Ticket : "logs ticket activity")

[//]: # ()
[//]: # (%% Authentication)

[//]: # (    AuthService --> JwtService : "generates and validates JWT")

[//]: # (    AuthService --> CustomerAccountRepository : "retrieves")

[//]: # (    TicketController --> AuthService : "authenticates")

[//]: # ()
[//]: # (%% Threads and synchronization)

[//]: # (    Vendor --|> Runnable : "implements")

[//]: # (    CustomerAccount --|> Runnable : "implements")

[//]: # (    Vendor --> TicketPool : "adds tickets to")

[//]: # (    CustomerAccount --> TicketPool : "retrieves tickets from")

[//]: # ()
[//]: # (%% Logs and errors)

[//]: # (    Vendor --> Logger : "logs activities")

[//]: # (    CustomerAccount --> Logger : "logs activities")

[//]: # (    Vendor --> ErrorHandler : "handles errors")

[//]: # (    CustomerAccount --> ErrorHandler : "handles errors")

[//]: # ()
[//]: # (```)

## JWT Authentication

[//]: # (```mermaid)

[//]: # (sequenceDiagram)

[//]: # (    participant Client)

[//]: # (    participant JWTAuthFilter)

[//]: # (    participant JWTService)

[//]: # (    participant UserDetailsService)

[//]: # (    participant Security)

[//]: # (    participant DispatcherServlet)

[//]: # (    participant Controller)

[//]: # (    participant Database)

[//]: # ()
[//]: # (    Client->>+JWTAuthFilter: Send HTTP Request)

[//]: # (    JWTAuthFilter->>JWTAuthFilter: Check JWT Token)

[//]: # (    )
[//]: # (    alt Missing or Invalid JWT)

[//]: # (        JWTAuthFilter-->>Client: HTTP 403 &#40;Forbidden&#41;)

[//]: # (    else Valid JWT)

[//]: # (        JWTAuthFilter->>+JWTService: Validate JWT Token)

[//]: # (        JWTService->>+UserDetailsService: Load User Details)

[//]: # (        UserDetailsService-->>-JWTService: User Details)

[//]: # (        JWTService-->>-JWTAuthFilter: Valid User)

[//]: # (    )
[//]: # (        JWTAuthFilter->>+Security: Update SecurityContextHolder)

[//]: # (        Security-->>-JWTAuthFilter: Success)

[//]: # ()
[//]: # (        JWTAuthFilter->>+DispatcherServlet: Pass Security Context)

[//]: # (        DispatcherServlet->>+Controller: Forward Request)

[//]: # (        Controller->>+Database: Query Database)

[//]: # (        Database-->>-Controller: Return Data)

[//]: # (        Controller-->>-DispatcherServlet: Return Response)

[//]: # (        DispatcherServlet-->>Client: HTTP 200 &#40;Success&#41;)

[//]: # (    end)

[//]: # ()
[//]: # (```)

[![](https://mermaid.ink/img/pako:eNqFVFFv2jAQ_iuWnzaNQkJIAD9UmsqqblqlrrBNmngx9kGsBjuzna6s4r_PTgyFJtvygMjdfffdZ3-5Z8wUB0ywgZ8VSAYzQTeabpcSuaek2gomSiotuioESNuOf_q-eF_Z_FoUFnRneg76UTBo574a0DOwVBTmrzVzYJUWdtfOzIQpqWU5aA8uoGO2KyWtVkXRNdiMWrqixlE2uUbfxeXluzNFxE0gObpZLO7QvT8jE3jOqhzsFeoqB_bgi9BCPUDgaH5pYdGtMEbIDVIafZSPtBDc1zb5dnfXvhmPNIOMogS9uVZ6JTgH-baBQWEAfftfq0ZfOG7S1FMLrycNwFDnUe3LIuizory-RRQyL-B2uVdxccrdDTxhDYDTY230eeTpiXbKPDjHEZW1xEPAuwKe7I0q-KGNfw7pLtp5xRgYs5T_4Gv5kaA7asyxLwq8Ly1aCN_mxbMEuSv-RTU_N15t1mNRzRysTNCXCvTuxNpHphCptZ0y3IOttKzznd19fYewALsHUyp5RtSS9Nq7wyhCb8J5HpwruT9Z3MNb0FsquNtHzz61xDaHLSwxcX851Q9LvJR7V0crq-Y7yTCxuoIeruobDrvrPPiBC6s0Jmvqvo8eLpxlwb0-Y7sr_eLbCGNdR6bkWmx8vNKFC-fWloYMBj7d3wibV6s-U9uBETx3WyR_nGaDbJhN6DCBbJzQNEk4W8XTyXo4itd8HMVDivf7HnbLxnd9wmQS9aN0GE-SNEvSZDRJe3iHSRz141GWxaPRNPHhzGF-K-VURP3pOIsn0zTN0mScRWMHgFrNbbOz69Xdw1pVm_wo0PH9qOH1-_4PXujrmQ?type=png)](https://mermaid.live/edit#pako:eNqFVFFv2jAQ_iuWnzaNQkJIAD9UmsqqblqlrrBNmngx9kGsBjuzna6s4r_PTgyFJtvygMjdfffdZ3-5Z8wUB0ywgZ8VSAYzQTeabpcSuaek2gomSiotuioESNuOf_q-eF_Z_FoUFnRneg76UTBo574a0DOwVBTmrzVzYJUWdtfOzIQpqWU5aA8uoGO2KyWtVkXRNdiMWrqixlE2uUbfxeXluzNFxE0gObpZLO7QvT8jE3jOqhzsFeoqB_bgi9BCPUDgaH5pYdGtMEbIDVIafZSPtBDc1zb5dnfXvhmPNIOMogS9uVZ6JTgH-baBQWEAfftfq0ZfOG7S1FMLrycNwFDnUe3LIuizory-RRQyL-B2uVdxccrdDTxhDYDTY230eeTpiXbKPDjHEZW1xEPAuwKe7I0q-KGNfw7pLtp5xRgYs5T_4Gv5kaA7asyxLwq8Ly1aCN_mxbMEuSv-RTU_N15t1mNRzRysTNCXCvTuxNpHphCptZ0y3IOttKzznd19fYewALsHUyp5RtSS9Nq7wyhCb8J5HpwruT9Z3MNb0FsquNtHzz61xDaHLSwxcX851Q9LvJR7V0crq-Y7yTCxuoIeruobDrvrPPiBC6s0Jmvqvo8eLpxlwb0-Y7sr_eLbCGNdR6bkWmx8vNKFC-fWloYMBj7d3wibV6s-U9uBETx3WyR_nGaDbJhN6DCBbJzQNEk4W8XTyXo4itd8HMVDivf7HnbLxnd9wmQS9aN0GE-SNEvSZDRJe3iHSRz141GWxaPRNPHhzGF-K-VURP3pOIsn0zTN0mScRWMHgFrNbbOz69Xdw1pVm_wo0PH9qOH1-_4PXujrmQ)

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
