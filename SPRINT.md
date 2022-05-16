# Sprint Plan

## Sprint #1 (W18 2022)
We want to get the following done in this sprint:
- Project-related
  - [x] An initial ER diagram
  - [x] Describe a few use cases/user stories
  - [x] Decide on tech stack (java version, docker, spring-security, front-end router)
- Deploy the project 
  - [x] CI/CD for both frontend and backend, azure mysql database
  - [x] Install Springdoc
- Develop the backend
  - [x] Implement the ER diagram in code
  - [x] Begin work on Paginated Rest API (GET operations > POST/PUT/PATCH/DELETE)
  - [x] Create dummy data with configuration
- Develop the frontend
  - [x] View static data on frontend

We have completed the following so far in this sprint:
- Developed an initial ER diagram
- Described a few user stories
- Decided on a tech stack
  - Java 17 without Docker, sinze Azure supports it natively now
  - Spring Security since we want to have a user make a reservation and this seems the most feasible
  - We will use Navigo as a frontend router
  - MySQL 8
- CI/CD has been set up for both frontend and backend
- Springdoc has been installed for API documentation
- GET endpoints for movies have been created
- Manually entered a few movies as dummy data
- Frontend is able to render som static data, but it's still very early in the process

What did we miss in this sprint:
- Nothing :)

Who did what in this sprint:
- Mark
  - initial ER diagram
  - entities and relational mapping
  - springdoc implementation
- Simon
  - describe user stories
  - entering dummy data
  - layout and styling on frontend
- Frederik
  - CI/CD for backend
  - Host MySQL on Azure
  - Setup entities, repositories, services classes etc. 
- Malthe
  - CI/CD for frontend
  - Static data using json mock server
  - Setup grid for movie template
  - Created function to fetch movie data

## Sprint #2 (W19 2022)
We have decided to focus our work on showing which movies are in the cinema and getting reservations to work.

We want to get the following done in this sprint:
- [x] Figure out how reservation api should work and begin work on it
- [x] Endpoint to tell the server to import a movie from imdb or themoviedb
- [x] Begin writing a few tests
- [x] Figure out how frontend should look/how the user should navigate (maybe produce a few wireframes?)
- [x] Begin work on implementing wireframes

Who did what in this sprint:
- Mark
  - initial backend reservation implementation
  - few tests
- Simon
  - Dummy Data Config
  - ShowingResponse and ShowingService on backend
- Frederik
  - dummy data
  - test
- Malthe
    - Continous frontend work. Working on implementing how we show each showing.
    - Did some minor work on backend to fit the responses to frontend.

## Sprint #3 (W20 2022)
We will try to finish the implementation of the movie overview and reservation

We want to get the following done in this sprint:
