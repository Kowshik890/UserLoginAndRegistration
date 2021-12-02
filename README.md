# UserLoginAndRegistration
### This is a small module of a project, which is a complete backend application for "User Login and Registration with Email Verification" using Spring Boot and PostgreSQL database. 
* Database Setup (PostgreSQL):
     * create database in PostgreSQL
          * open terminal and write "psql postgres"
          * to see the list of databases, type "\l"
          * create database by "create database 'databaseName'"
          * add this database name in application.properties while configuring PostgreSQL
          ```
              # PostgreSQL Configuration
              spring.datasource.url = jdbc:postgresql://localhost:5432/databaseName
              spring.datasource.username = postgres
              spring.datasource.password = root
          ```
