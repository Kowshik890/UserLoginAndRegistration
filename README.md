# UserLoginAndRegistration
### This is a small module of a project, which is a complete backend application for "User Login and Registration with Email Verification" using Spring Boot and PostgreSQL database. 
1. Database Setup (PostgreSQL):
     * create database in PostgreSQL
          * open terminal and write "psql postgres"
          * to see the list of databases, type "\l"
          * create database by "create database 'databaseName'"
          * add this database name in application.properties while configuring PostgreSQL
          * to connect to database "databaseName" as user "username", type \c "databaseName" [e.g: \c userloginandregistration]
          * to see the list of relations, type \d
          * to see the data in expanded dispaly, type \x, then write select query.
          ```
              # PostgreSQL Configuration
              spring.datasource.url = jdbc:postgresql://localhost:5432/databaseName
              spring.datasource.username = postgres
              spring.datasource.password = root
          ```
1. Development of Backend Application:
    * create "AppUser" model & "AppUserRole" for the user
    * to register a user, create "RegistrationRequest" model
    * to secure the application, spring security is used
        1. "WebSecurityConfig" class is created which extends spring "WebSecurityConfigurerAdapter" class to authenticate the user
        2. to encrypt the password, "BCryptPasswordEncoder" is used
    * to register a user:
        1. check the email whether it is valid or not
        2. check the email whether the email id exists or not
        3. after fulfilling all conditions, user details have inserted into database with encrypted password
