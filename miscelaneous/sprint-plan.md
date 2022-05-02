# Sprint Plan

![ER diagram](./er-diagram.webp)


## Sprint #1 (W18 2022)

```mermaid
erDiagram
    CINEMA ||--o{ ROOM : has
    ROOM ||--o{ SEAT : has
    RESERVATION }o--o{ SEAT : has
    MOVIE ||--o{ SHOWING : has
    ROOM ||--o{ SHOWING : has
    SHOWING ||--o{ RESERVATION : has
    ACCOUNT ||--o{ RESERVATION : has  
    
    CINEMA {
        long id PK
        
        string name
        string location
    }
    
    ROOM {
        long id PK
        long cinema_id FK
        
        string name
        string description
    }
    
    SEAT {
        long id PK
        long room_id FK
        
        enum type
    }
    
    MOVIE {
        string id PK
        
        string title
        string description
        string rating
        string duration
        string picture
        string trailer
        string category
    }
    
    SHOWING {
        long id PK
        long room_id FK
        string movie_id FK
        
        string start_datetime
        string duration
        string base_price
    }
    
    RESERVATION {
        long id PK
        long account_id FK
        long schedule_id FK
        
        bool paid
    }
    
    ACCOUNT {
        long id PK
        string email PK
        
        string name
        enum type
    }
    

```

We want to get the following done in this sprint:
- Project-related
  - An initial ER diagram
  - Describe a few use cases/user stories
  - Decide on tech stack (java version, docker, spring-security, front-end router)
- Deploy the project 
  - CI/CD for both frontend and backend, azure mysql database
  - Install Springdoc
- Develop the backend
  - Implement the ER diagram in code
  - Begin work on Paginated Rest API (GET operations > POST/PUT/PATCH/DELETE)
  - Create dummy data with configuration
- Develop the frontend
  - View data on frontend
